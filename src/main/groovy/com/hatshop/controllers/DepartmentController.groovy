package com.hatshop.controllers

import com.hatshop.AbstractRestController
import com.hatshop.models.Department
import com.hatshop.models.Product
import com.hatshop.repositories.DepartmentRepository
import com.hatshop.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

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

    @RequestMapping('/{id}/products')
    Page<Product> departmentProducts(@PathVariable Integer id,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "25") int size) {
        productRepository.findPageByDepartmentId(id, new PageRequest(page, size))
    }
}
