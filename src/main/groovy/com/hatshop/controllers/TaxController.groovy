package com.hatshop.controllers

import com.hatshop.utils.ARestController
import com.hatshop.models.Customer
import com.hatshop.repositories.TaxRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("taxes")
class TaxController extends ARestController<Customer, Integer> {
    @Autowired
    TaxController(TaxRepository repo) {
        super(repo)
    }
}
