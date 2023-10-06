package com.hatshop_api.controllers

import com.hatshop_api.models.Category
import com.hatshop_api.repositories.CategoryRepository
import com.hatshop_api.repositories.ProductRepository
import com.hatshop_api.utils.Constants.PAGE_NUMBER
import com.hatshop_api.utils.Constants.PAGE_SIZE
import com.lv_spring.data.rest.jpa.AbstractRestController
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("categories")
class CategoryController(
  categoryRepository: CategoryRepository,
  val productRepository: ProductRepository,
) : AbstractRestController<Category, Int>(categoryRepository) {

  @RequestMapping("{categoryId}/products")
  fun departmentCategoryProducts(
    @PathVariable categoryId: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int
  ): Any = when (size) {
    0 -> productRepository.findAllByCategories_Id(categoryId)
    1 -> productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size)).elementAt(0)
    else -> productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size))
  }
}
