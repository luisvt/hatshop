package com.hatshop_api.repositories

import com.hatshop_api.models.ShoppingCart
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface ShoppingCartRepository : JpaRepositoryAndSpecificationExecutor<ShoppingCart, Int>
