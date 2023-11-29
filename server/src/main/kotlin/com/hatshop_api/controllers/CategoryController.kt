package com.hatshop_api.controllers

import com.hatshop_api.models.Category
import com.hatshop_api.repositories.CategoryRepository
import com.hatshop_api.repositories.ProductRepository
import com.hatshop_api.utils.Constants.PAGE_NUMBER
import com.hatshop_api.utils.Constants.PAGE_SIZE
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("categories")
@Tag(name = "Categories")
class CategoryController(
  categoryRepository: CategoryRepository,
  val productRepository: ProductRepository,
) : AbstractRestController<Category, Int>(categoryRepository) {

  @GetMapping("{categoryId}/products")
  fun findAllProducts(
    @PathVariable categoryId: Int,
    @RequestParam(defaultValue = PAGE_NUMBER) page: Int,
    @RequestParam(defaultValue = PAGE_SIZE) size: Int
  ): Any = when (size) {
    0 -> productRepository.findAllByCategories_Id(categoryId)
    1 -> productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size)).elementAt(0)
    else -> productRepository.findAllByCategories_Id(categoryId, PageRequest.of(page, size))
  }
}
