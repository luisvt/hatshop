package com.hatshop_api.repositories

import com.hatshop_api.models.Shipping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface ShippingRepository : JpaRepository<Shipping, Int>, JpaSpecificationExecutor<Shipping> {}
