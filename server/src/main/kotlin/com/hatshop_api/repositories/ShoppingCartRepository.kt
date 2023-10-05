package com.hatshop_api.repositories

import com.hatshop_api.models.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface ShoppingCartRepository : JpaRepository<ShoppingCart, Int>, JpaSpecificationExecutor<ShoppingCart> {

}
