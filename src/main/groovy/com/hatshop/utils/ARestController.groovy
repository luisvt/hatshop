package com.hatshop.utils

import org.apache.commons.beanutils.BeanUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

public abstract class ARestController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(ARestController.class);

    JpaRepository<T, ID> repo;


    ARestController(JpaRepository<T, ID> repo) {
        this.repo = repo
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    T findOne(@PathVariable ID id) {
        return repo.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    T create(@RequestBody T entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass());

        repo.save entity
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    T update(@PathVariable ID id, @RequestBody T json) {
        logger.debug("update() of id#{} with body {}", id, json);
        logger.debug("T json is of type {}", json.getClass());

        T entity = repo.findOne(id)
        try {
            BeanUtils.copyProperties(entity, json);
        }
        catch (Exception e) {
            logger.warn("while copying properties", e);
//            throw Throwables.propagate(e);
        }

        logger.debug("merged entity: {}", entity);

        repo.save entity
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable ID id) {
        repo.delete id
    }
}