package com.hatshop_api.repositories

import com.hatshop_api.models.ShippingRegion
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface ShippingRegionRepository : JpaRepositoryAndSpecificationExecutor<ShippingRegion, Int>
