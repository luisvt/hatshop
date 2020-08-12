package com.hatshop.server.utils

import org.apache.commons.beanutils.BeanUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.*

import static com.hatshop.server.utils.Constants.PAGE_NUMBER
import static com.hatshop.server.utils.Constants.PAGE_SIZE

abstract class ARestController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(ARestController.class)

    JpaRepository<T, ID> repo


    ARestController(JpaRepository<T, ID> repo) {
        this.repo = repo
    }

    @GetMapping(value = "/{id}")
    T findOne(@PathVariable ID id) {
        repo.findById(id).orElseThrow { new ResourceNotFoundException() }
    }


    @GetMapping
    Iterable<T> findAll(@RequestParam(defaultValue = PAGE_NUMBER) Integer page,
                    @RequestParam(defaultValue = PAGE_SIZE) Integer size) {

        if (size == 0) return repo.findAll()
        if (size == 1) return repo.findOne().orElseThrow { new ResourceNotFoundException() }
        repo.findAll(PageRequest.of(page, size))
    }

    @RequestMapping(method = RequestMethod.POST)
    T create(@RequestBody T entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass())

        repo.save entity
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    T update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id#{} with body {}", id, json)
        logger.debug("T json is of type {}", json.getClass())

        Optional<T> entity = repo.findById(id)
        try {
            BeanUtils.copyProperties(entity, json)
        }
        catch (Exception e) {
            logger.warn("while copying properties", e)
//            throw Throwables.propagate(e)
        }

        logger.debug("merged entity: {}", entity)

        repo.save entity.get()
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable ID id) {
        repo.deleteById id
    }
}
