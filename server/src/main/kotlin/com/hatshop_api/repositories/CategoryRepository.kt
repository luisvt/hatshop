package com.hatshop_api.repositories

import com.hatshop_api.models.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface CategoryRepository : JpaRepository<Category, Int>, JpaSpecificationExecutor<Category> {
  fun findAllByDepartmentId(id: Int): List<Category>

  fun findAllByDepartmentId(id: Int, sort: Sort): List<Category>

  fun findAllByDepartmentId(id: Int, pageable: Pageable): Page<Category>
}
