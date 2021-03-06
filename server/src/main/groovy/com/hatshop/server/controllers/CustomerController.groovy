package com.hatshop.server.controllers

import com.hatshop.server.models.Customer
import com.hatshop.server.repositories.CustomerRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("customers")
class CustomerController extends AbstractRestController<Customer, Integer> {
  @Autowired
  CustomerController(CustomerRepository repo) {
    super(repo)
  }
}
