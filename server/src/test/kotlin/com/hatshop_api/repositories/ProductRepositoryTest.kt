package com.hatshop_api.repositories

import com.hatshop_api.models.Department
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

/**
 * Test for ProductRepository
 * Created by luis on 7/9/15.
 */
@SpringBootTest
class ProductRepositoryTest @Autowired constructor(
  val productRepository: ProductRepository,
  val departmentRepository: DepartmentRepository,
  val categoryRepository: CategoryRepository
) {

  @Test
  @Throws(Exception::class)
  fun testFindAllByCategories_Department_Id() {
    val dep2 = departmentRepository.findOne { root, _, cb ->
      cb.equal(root.get<Department>("name"), "Caps and Berets")
    }.get()
    val productsPage = productRepository.findAllByCategoriesDepartmentId(
      dep2.id!!, PageRequest.of(0, 50)
    )
    assertEquals(8, productsPage.content.size)
  }

  @Test
  fun testFindAllByCategories_Id() {
    val cat1 = categoryRepository.findOne { root, _, cb ->
      cb.equal(root.get<String>("name"), "Christmas Hats")
    }.get()
    val productsPage = productRepository.findAllByCategories_Id(
      cat1.id!!, PageRequest.of(0, 20)
    )
    assertEquals(7, productsPage.content.size)
  }

}
