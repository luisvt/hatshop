package com.hatshop.utils

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import static com.hatshop.utils.Constants.PAGE_NUMBER
import static com.hatshop.utils.Constants.PAGE_SIZE

/**
 * Abstract class to be extended by rest controllers which wants to respond a page of elements
 */
class APageRestController<T, ID extends Serializable> extends ARestController<T, ID> {

    APageRestController(JpaRepository<T, ID> repo) {
        super(repo)
    }

    @RequestMapping
    Page<T> findAll(@RequestParam(defaultValue = PAGE_NUMBER) Integer page,
                    @RequestParam(defaultValue = PAGE_SIZE) Integer size) {
        repo.findAll(new PageRequest(page, size))
    }
}
