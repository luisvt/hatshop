package com.hatshop.controllers

import com.hatshop.RESTController
import com.hatshop.models.Customer
import com.hatshop.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("customers")
class CustomerController extends RESTController<Customer, Integer> {
    @Autowired
    CustomerController(CustomerRepository repo) {
        super(repo)
    }
}
