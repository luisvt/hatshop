package com.hatshop.server.utils

import com.hatshop.server.utils.rsql.CustomRsqlVisitor
import cz.jirutka.rsql.parser.RSQLParser
import org.apache.commons.beanutils.BeanUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.domain.Specification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.*

import static com.hatshop.server.utils.Constants.PAGE_NUMBER
import static com.hatshop.server.utils.Constants.PAGE_SIZE

abstract class AbstractRestController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(AbstractRestController)

    JpaRepository<T, ID> repo


    AbstractRestController(JpaRepository<T, ID> repo) {
        this.repo = repo
    }

    @GetMapping(value = "/{id}")
    T findOne(@PathVariable ID id) {
        repo.findById(id).orElseThrow { new ResourceNotFoundException() }
    }


    @GetMapping
    def findAll(@RequestParam(defaultValue = PAGE_NUMBER) Integer page,
                @RequestParam(defaultValue = PAGE_SIZE) Integer size,
                @RequestParam(required = false) String search) {

        if (search) {
            def rootNode = new RSQLParser().parse(search)
            def spec = rootNode.accept(new CustomRsqlVisitor<T>())
            def repoExecutor = repo as JpaSpecificationExecutor<T>
            if (size == 0) return repoExecutor.findAll(spec)
            if (size == 1) return repoExecutor.findOne(spec)
            return repoExecutor.findAll(spec, PageRequest.of(page, size))
        }

        if (size == 0) return repo.findAll()
        repo.findAll(PageRequest.of(page, size))
    }

    @PostMapping
    T create(@RequestBody T entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass())

        repo.save entity
    }


    @PutMapping("/{id}")
    T update(@PathVariable ID id, @RequestBody T item) {
        logger.debug("update() of id#{} with body {}", id, item)
        logger.debug("T json is of type {}", item.getClass())

        T entity = repo.findById(id).orElseThrow { new ResourceNotFoundException() }
        try {
            BeanUtils.copyProperties(entity, item)
        }
        catch (Exception e) {
            logger.warn("Error while copying properties", e)
        }

        logger.debug("merged entity: {}", entity)

        repo.save entity
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable ID id) {
        repo.deleteById id
    }
}
