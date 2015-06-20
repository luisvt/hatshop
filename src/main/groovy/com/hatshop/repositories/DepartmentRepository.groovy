package com.hatshop.repositories

import com.hatshop.models.Department
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface DepartmentRepository extends JpaRepository<Department, Integer> {

}