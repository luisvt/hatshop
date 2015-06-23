package com.hatshop.repositories

import com.hatshop.models.ShippingRegion
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface ShippingRegionRepository extends JpaRepository<ShippingRegion, Integer> {

}