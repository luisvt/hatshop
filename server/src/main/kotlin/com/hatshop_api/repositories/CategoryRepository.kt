package com.hatshop_api.repositories

import com.hatshop_api.models.Category
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort


interface CategoryRepository : JpaRepositoryAndSpecificationExecutor<Category, Int> {
  fun findAllByDepartmentId(id: Int): List<Category>

  fun findAllByDepartmentId(id: Int, sort: Sort): List<Category>

  fun findAllByDepartmentId(id: Int, pageable: Pageable): Page<Category>
}
