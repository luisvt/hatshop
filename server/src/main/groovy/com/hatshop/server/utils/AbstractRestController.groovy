package com.hatshop.server.utils

import com.hatshop.server.utils.rsql.CustomRsqlVisitor
import cz.jirutka.rsql.parser.RSQLParser
import org.apache.commons.beanutils.BeanUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.*

import static com.hatshop.server.utils.Constants.PAGE_NUMBER
import static com.hatshop.server.utils.Constants.PAGE_SIZE
import static com.hatshop.server.utils.ToSerializable.toSerializable

abstract class AbstractRestController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(AbstractRestController)

    JpaRepository<T, ID> repo


    AbstractRestController(JpaRepository<T, ID> repo) {
        this.repo = repo
    }

    @GetMapping(value = "/{id}")
    def findOne(@PathVariable ID id, @RequestParam(required = false) List<String> project) {
        toSerializable(repo.findById(id).orElseThrow { new ResourceNotFoundException() }, project)
    }

    protected _findAll(page, size, search) {
        if (search) {
            def rootNode = new RSQLParser().parse(search)
            def spec = rootNode.accept(new CustomRsqlVisitor<T>())
            def repoExecutor = repo as JpaSpecificationExecutor<T>
            if (size == 0) return repoExecutor.findAll(spec)
            if (size == 1) return repoExecutor.findOne(spec).orElseThrow(ResourceNotFoundException.&newInstance)
            return repoExecutor.findAll(spec, PageRequest.of(page, size))
        }

        if (size == 0) return repo.findAll()
        repo.findAll(PageRequest.of(page, size))
    }

    @GetMapping
    def findAll(@RequestParam(defaultValue = PAGE_NUMBER) Integer page,
                @RequestParam(defaultValue = PAGE_SIZE) Integer size,
                @RequestParam(required = false) String search,
                @RequestParam(required = false) List<String> project) {
        toSerializable(_findAll(page, size, search), project)
    }

    @PostMapping
    def create(@RequestBody T entity, @RequestParam(required = false) List<String> project) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass())

        toSerializable(repo.save(entity), project)
    }


    @PutMapping("/{id}")
    def update(@PathVariable ID id, @RequestBody T item, @RequestParam(required = false) List<String> project) {
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

        toSerializable(repo.save(entity), project)
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable ID id) {
        repo.deleteById id
    }
}
