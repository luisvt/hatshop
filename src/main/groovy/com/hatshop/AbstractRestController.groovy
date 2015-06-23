package com.hatshop

import org.apache.commons.beanutils.BeanUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*

public abstract class AbstractRestController<T, ID extends Serializable> {

    private Logger logger = LoggerFactory.getLogger(AbstractRestController.class);

    private JpaRepository<T, ID> repo;


    public AbstractRestController(JpaRepository<T, ID> repo) {
        this.repo = repo
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public T findOne(@PathVariable ID id) {
        return repo.findOne(id);
    }

    @RequestMapping
    public Iterable<T> findAll(@RequestParam(defaultValue = "0") Integer page,
                           @RequestParam(defaultValue = "20") Integer size) {
        repo.findAll(new PageRequest(page, size))
    }

    @RequestMapping(method = RequestMethod.POST)
    public T create(@RequestBody T entity) {
        logger.debug("create() with body {} of type {}", entity, entity.getClass());

        repo.save entity
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public T update(@PathVariable ID id, @RequestBody T json) {
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
    public void delete(@PathVariable ID id) {
        repo.delete id
    }
}