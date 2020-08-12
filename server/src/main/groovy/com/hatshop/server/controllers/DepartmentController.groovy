package com.hatshop.server.controllers

import com.hatshop.server.models.Category
import com.hatshop.server.models.Department
import com.hatshop.server.models.Product
import com.hatshop.server.repositories.CategoryRepository
import com.hatshop.server.repositories.DepartmentRepository
import com.hatshop.server.repositories.ProductRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import static com.hatshop.server.utils.Constants.PAGE_NUMBER
import static com.hatshop.server.utils.Constants.PAGE_SIZE

/**
 * Rest controller that send department related data to clients
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("departments")
class DepartmentController extends AbstractRestController<Department, Integer> {
    @Autowired
    DepartmentController(DepartmentRepository repo) {
        super(repo)
    }

    @Autowired
    ProductRepository productRepository

    @Autowired
    CategoryRepository categoryRepository

    @RequestMapping('/{id}/products')
    Page<Product> departmentProducts(@PathVariable Integer id,
                                     @RequestParam(defaultValue = PAGE_NUMBER) int page,
                                     @RequestParam(defaultValue = PAGE_SIZE) int size) {
        productRepository.findPageByCategories_Department_Id(id, PageRequest.of(page, size))
    }

    @RequestMapping('/{id}/categories')
    List<Category> departmentCategories(@PathVariable Integer id) {
        categoryRepository.findAllByDepartment_Id(id)
    }

    @RequestMapping('/{departmentId}/categories/{categoryId}/products')
    Page<Product> departmentCategoryProducts(
            @PathVariable Integer departmentId,
            @PathVariable Integer categoryId,
            @RequestParam(defaultValue = PAGE_NUMBER) int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        productRepository.findPageByCategories_Id(categoryId, PageRequest.of(page, size))
    }
}
