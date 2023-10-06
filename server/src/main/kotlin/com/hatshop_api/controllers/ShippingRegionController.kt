package com.hatshop_api.controllers

import com.hatshop_api.models.ShippingRegion
import com.hatshop_api.repositories.ShippingRegionRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("shipping-regions")
class ShippingRegionController(repository: ShippingRegionRepository) :
  AbstractRestController<ShippingRegion, Int>(repository)
