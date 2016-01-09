package com.hatshop.controllers

import com.hatshop.utils.ARestController
import com.hatshop.models.Shipping
import com.hatshop.repositories.ShippingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shippings")
class ShippingController extends ARestController<Shipping, Integer> {
    @Autowired
    ShippingController(ShippingRepository repo) {
        super(repo)
    }
}
