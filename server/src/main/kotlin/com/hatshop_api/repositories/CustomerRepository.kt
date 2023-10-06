package com.hatshop_api.repositories

import com.hatshop_api.models.Customer
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface CustomerRepository : JpaRepositoryAndSpecificationExecutor<Customer, Int>
