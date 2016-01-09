package com.hatshop.controllers

import com.hatshop.utils.ARestController
import com.hatshop.models.ShippingRegion
import com.hatshop.repositories.ShippingRegionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shipping-regions")
class ShippingRegionController extends ARestController<ShippingRegion, Integer> {
    @Autowired
    ShippingRegionController(ShippingRegionRepository repo) {
        super(repo)
    }
}
