package com.hatshop.repositories

import com.hatshop.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by luis on 6/19/15.
 */
//@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
interface CustomerRepository extends JpaRepository<Customer, Integer> {

}