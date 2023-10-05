package com.hatshop_api.controllers

import com.hatshop_api.models.Customer
import com.hatshop_api.repositories.CustomerRepository
import com.hatshop_api.utils.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("customers")
class CustomerController(repository: CustomerRepository) : AbstractRestController<Customer, Int>(repository)
