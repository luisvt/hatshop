package com.hatshop.controllers

import com.hatshop.RESTController
import com.hatshop.models.Category
import com.hatshop.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("categories")
class CategoryController extends RESTController<Category, Integer> {
    @Autowired
    CategoryController(CustomerRepository repo) {
        super(repo)
    }
}
