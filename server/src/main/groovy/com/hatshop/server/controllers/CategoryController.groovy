package com.hatshop.server.controllers

import com.hatshop.server.models.Category
import com.hatshop.server.repositories.CategoryRepository
import com.hatshop.server.repositories.ProductRepository
import com.hatshop.server.utils.AbstractRestController
import com.hatshop.server.utils.ToSerializable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static com.hatshop.server.utils.Constants.PAGE_NUMBER
import static com.hatshop.server.utils.Constants.PAGE_SIZE
import static com.hatshop.server.utils.ToSerializable.toSerializable

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("categories")
class CategoryController extends AbstractRestController<Category, Integer> {
    @Autowired
    CategoryController(CategoryRepository repo) {
        super(repo)
    }

    @Autowired
    ProductRepository productRepository

    @RequestMapping('{categoryId}/products')
    def departmentCategoryProducts(
            @PathVariable Integer categoryId,
            @RequestParam(defaultValue = PAGE_NUMBER) int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        toSerializable(size == 0
                ? productRepository.findAllByCategories_Id(categoryId)
                : size == 1
                ? productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size))[0]
                : productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size)))
    }
}
