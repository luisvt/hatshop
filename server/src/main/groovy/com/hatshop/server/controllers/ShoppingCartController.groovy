package com.hatshop.server.controllers

import com.hatshop.server.models.ShoppingCart
import com.hatshop.server.repositories.ShoppingCartRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shopping-carts")
class ShoppingCartController extends AbstractRestController<ShoppingCart, Integer> {
  @Autowired
  ShoppingCartController(ShoppingCartRepository repo) {
    super(repo)
  }
}
