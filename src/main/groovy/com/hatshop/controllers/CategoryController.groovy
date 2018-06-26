package com.hatshop.controllers

import com.hatshop.models.Category
import com.hatshop.repositories.CategoryRepository
import com.hatshop.utils.AListRestController
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
