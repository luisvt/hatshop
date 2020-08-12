package com.hatshop.server.controllers

import com.hatshop.server.utils.ARestController
import com.hatshop.server.models.Customer
import com.hatshop.server.repositories.TaxRepository
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
