package com.hatshop_api.controllers

import com.hatshop_api.models.Department
import com.hatshop_api.repositories.CategoryRepository
import com.hatshop_api.repositories.DepartmentRepository
import com.hatshop_api.repositories.ProductRepository
import com.hatshop_api.utils.AbstractRestController
import com.hatshop_api.utils.Constants.PAGE_NUMBER
import com.hatshop_api.utils.Constants.PAGE_SIZE
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("departments")
class DepartmentController(
  repository: DepartmentRepository,
  val productRepository: ProductRepository,
  val categoryRepository: CategoryRepository,
) : AbstractRestController<Department, Int>(repository) {

  @RequestMapping("/{id}/products")
  fun departmentProducts(
    @PathVariable id: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int
  ): Any? = when (size) {
    0 -> productRepository.findAllByCategoriesDepartmentId(id)
    1 -> productRepository.findAllByCategoriesDepartmentId(id, PageRequest.of(page, size)).elementAt(0)
    else -> productRepository.findAllByCategoriesDepartmentId(id, PageRequest.of(page, size))
  }

  @RequestMapping("/{id}/categories")
  fun departmentCategories(
    @PathVariable id: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int,
    @RequestParam(required = false) project: List<String>
  ): Any? = when (size) {
    0 -> categoryRepository.findAllByDepartmentId(id)
    1 -> categoryRepository.findAllByDepartmentId(id, PageRequest.of(page, size)).elementAt(0)
    else -> categoryRepository.findAllByDepartmentId(id, PageRequest.of(page, size))
  }
}
