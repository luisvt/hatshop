package com.hatshop_api.repositories

import com.hatshop_api.models.Department
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface DepartmentRepository : JpaRepositoryAndSpecificationExecutor<Department, Int>
