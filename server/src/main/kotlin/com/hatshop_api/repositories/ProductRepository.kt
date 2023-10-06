package com.hatshop_api.repositories

import com.hatshop_api.models.Product
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

/**
 * Handles the products data
 * Created by luis on 6/19/15.
 */
interface ProductRepository : JpaRepositoryAndSpecificationExecutor<Product, Int> {

  fun findAllByCategoriesDepartmentId(id: Int): List<Product>

  fun findAllByCategoriesDepartmentId(id: Int, pageable: Sort): Iterable<Product>

  fun findAllByCategoriesDepartmentId(id: Int, pageable: Pageable): Page<Product>

  fun findAllByCategories_Id(id: Int): List<Product>

  fun findAllByCategories_Id(id: Int, sort: Sort): Iterable<Product>

  fun findAllByCategories_Id(id: Int, pageable: Pageable): Page<Product>
}
