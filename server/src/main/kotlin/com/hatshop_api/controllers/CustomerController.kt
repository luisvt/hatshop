package com.hatshop_api.controllers

import com.hatshop_api.models.Customer
import com.hatshop_api.repositories.CustomerRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("customers")
@Tag(name = "Customers")
class CustomerController(repository: CustomerRepository) : AbstractRestController<Customer, Int>(repository)
