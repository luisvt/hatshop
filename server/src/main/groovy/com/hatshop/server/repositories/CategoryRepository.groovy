package com.hatshop.server.repositories

import com.hatshop.server.models.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Created by luis on 6/19/15.
 */
interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {
    List<Category> findAllByDepartment_Id(Integer id)
}
