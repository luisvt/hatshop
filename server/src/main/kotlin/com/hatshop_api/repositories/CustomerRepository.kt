package com.hatshop_api.repositories

import com.hatshop_api.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface CustomerRepository : JpaRepository<Customer, Int>, JpaSpecificationExecutor<Customer> {

}
