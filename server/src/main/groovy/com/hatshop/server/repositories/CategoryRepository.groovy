package com.hatshop.server.repositories

import com.hatshop.server.models.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Created by luis on 6/19/15.
 */
interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    List<Category> findAllByDepartment_Id(Integer id)
    List<Category> findAllByDepartment_Id(Integer id, Sort sort)

    Page<Category> findAllByDepartment_Id(Integer id, Pageable pageable)
}
