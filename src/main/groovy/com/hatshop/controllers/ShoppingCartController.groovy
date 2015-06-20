package com.hatshop.controllers

import com.hatshop.RESTController
import com.hatshop.models.Customer
import com.hatshop.repositories.ShoppingCartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("shopping-carts")
class ShoppingCartController extends RESTController<Customer, Integer> {
    @Autowired
    ShoppingCartController(ShoppingCartRepository repo) {
        super(repo)
    }
}
