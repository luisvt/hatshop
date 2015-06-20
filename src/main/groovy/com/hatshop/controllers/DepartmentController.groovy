package com.hatshop.controllers

import com.hatshop.AbstractRestController
import com.hatshop.models.Department
import com.hatshop.repositories.DepartmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("departments")
class DepartmentController extends AbstractRestController<Department, Integer> {
    @Autowired
    DepartmentController(DepartmentRepository repo) {
        super(repo)
    }
}
