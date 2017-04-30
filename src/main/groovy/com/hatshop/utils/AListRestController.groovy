package com.hatshop.utils

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Abstract class to be extended by rest-controllers which want to respond with a list of element
 */
class AListRestController<T, ID extends Serializable> extends ARestController<T, ID> {
    AListRestController(JpaRepository<T, ID> repo) {
        super(repo)
    }

    @RequestMapping
    List<T> findAll() {
        repo.findAll()
    }
}
