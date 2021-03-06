package com.hatshop.server.repositories

import com.hatshop.server.models.Department
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

import static org.springframework.data.jpa.repository.EntityGraph.EntityGraphType.LOAD

/**
 * Created by luis on 6/19/15.
 */
interface DepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
}
