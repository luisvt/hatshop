package com.hatshop.repositories

import com.hatshop.models.Customer
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface CustomerRepository extends JpaRepository<Customer, Integer> {

}