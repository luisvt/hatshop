package com.hatshop.utils

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by luis on 11/4/15.
 */
public class AListRestController<T, ID extends Serializable> extends ARestController<T, ID> {
    public AListRestController(JpaRepository<T, ID> repo) {
        super(repo);
    }

    @RequestMapping
    List<T> findAll() {
        repo.findAll()
    }
}
