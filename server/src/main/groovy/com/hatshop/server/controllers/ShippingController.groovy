package com.hatshop.server.controllers

import com.hatshop.server.models.Shipping
import com.hatshop.server.repositories.ShippingRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shippings")
class ShippingController extends AbstractRestController<Shipping, Integer> {
  @Autowired
  ShippingController(ShippingRepository repo) {
    super(repo)
  }
}
