package com.hatshop.repositories

import com.hatshop.models.ShippingRegion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

/**
 * Created by luis on 6/19/15.
 */
//@RepositoryRestResource(collectionResourceRel = "/shipping-regions", path = "/shipping-regions")
interface ShippingRegionRepository extends JpaRepository<ShippingRegion, Integer> {

}