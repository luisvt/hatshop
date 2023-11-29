package com.hatshop_api.controllers

import com.hatshop_api.models.Department
import com.hatshop_api.repositories.CategoryRepository
import com.hatshop_api.repositories.DepartmentRepository
import com.hatshop_api.repositories.ProductRepository
import com.hatshop_api.utils.Constants.PAGE_NUMBER
import com.hatshop_api.utils.Constants.PAGE_SIZE
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("departments")
@Tag(name = "Departments")
class DepartmentController(
  repository: DepartmentRepository,
  val productRepository: ProductRepository,
  val categoryRepository: CategoryRepository,
) : AbstractRestController<Department, Int>(repository) {

  @GetMapping("/{id}/products")
  fun findAllProducts(
    @PathVariable id: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int
  ): Any? = when (size) {
    0 -> productRepository.findAllByCategoriesDepartmentId(id)
    1 -> productRepository.findAllByCategoriesDepartmentId(id, PageRequest.of(page, size)).elementAt(0)
    else -> productRepository.findAllByCategoriesDepartmentId(id, PageRequest.of(page, size))
  }

  @GetMapping("/{id}/categories")
  fun findAllCategories(
    @PathVariable id: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int
  ): Any? = when (size) {
    0 -> categoryRepository.findAllByDepartmentId(id)
    1 -> categoryRepository.findAllByDepartmentId(id, PageRequest.of(page, size)).elementAt(0)
    else -> categoryRepository.findAllByDepartmentId(id, PageRequest.of(page, size))
  }
}
