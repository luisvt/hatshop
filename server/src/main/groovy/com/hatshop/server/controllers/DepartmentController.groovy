package com.hatshop.server.controllers

import com.hatshop.server.models.Department
import com.hatshop.server.repositories.CategoryRepository
import com.hatshop.server.repositories.DepartmentRepository
import com.hatshop.server.repositories.ProductRepository
import com.hatshop.server.utils.AbstractRestController
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
  def departmentProducts(@PathVariable Integer id,
                         @RequestParam(defaultValue = PAGE_NUMBER) int page,
                         @RequestParam(defaultValue = PAGE_SIZE) int size,
                         @RequestParam(required = false) List<String> project) {
    toSerializable(size == 0
      ? productRepository.findAllByCategories_Department_Id(id)
      : size == 1
      ? productRepository.findAllByCategories_Department_Id(id, PageRequest.of(page, size))[0]
      : productRepository.findAllByCategories_Department_Id(id, PageRequest.of(page, size)),
      project)
  }

  @RequestMapping('/{id}/categories')
  def departmentCategories(@PathVariable Integer id,
                           @RequestParam(defaultValue = PAGE_NUMBER) Integer page,
                           @RequestParam(defaultValue = PAGE_SIZE) Integer size,
                           @RequestParam(required = false) List<String> project) {
    toSerializable(size == 0
      ? categoryRepository.findAllByDepartment_Id(id)
      : size == 1
      ? categoryRepository.findAllByDepartment_Id(id, PageRequest.of(page, size))[0]
      : categoryRepository.findAllByDepartment_Id(id, PageRequest.of(page, size)),
      project)
  }
}
