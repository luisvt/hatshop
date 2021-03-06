package com.hatshop.server.controllers

import com.hatshop.server.models.ShippingRegion
import com.hatshop.server.repositories.ShippingRegionRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shipping-regions")
class ShippingRegionController extends AbstractRestController<ShippingRegion, Integer> {
  @Autowired
  ShippingRegionController(ShippingRegionRepository repo) {
    super(repo)
  }
}
