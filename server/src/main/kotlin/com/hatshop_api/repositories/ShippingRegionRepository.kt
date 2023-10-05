package com.hatshop_api.repositories

import com.hatshop_api.models.ShippingRegion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface ShippingRegionRepository : JpaRepository<ShippingRegion, Int>, JpaSpecificationExecutor<ShippingRegion> {

}
