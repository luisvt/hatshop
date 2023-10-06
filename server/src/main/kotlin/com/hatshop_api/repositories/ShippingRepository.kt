package com.hatshop_api.repositories

import com.hatshop_api.models.Shipping
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface ShippingRepository : JpaRepositoryAndSpecificationExecutor<Shipping, Int>
