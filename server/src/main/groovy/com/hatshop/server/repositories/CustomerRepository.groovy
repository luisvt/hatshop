package com.hatshop.server.repositories

import com.hatshop.server.models.Customer
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
