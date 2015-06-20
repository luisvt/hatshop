package com.hatshop.repositories

import com.hatshop.models.Product
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface ProductRepository extends JpaRepository<Product, Integer> {

}