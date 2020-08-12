package com.hatshop.server.controllers

import com.hatshop.server.models.Category
import com.hatshop.server.repositories.CategoryRepository
import com.hatshop.server.utils.AListRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("categories")
class CategoryController extends AListRestController<Category, Integer> {
    @Autowired
    CategoryController(CategoryRepository repo) {
        super(repo)
    }
}
