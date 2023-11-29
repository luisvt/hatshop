package com.hatshop_api.controllers

import com.hatshop_api.models.ShoppingCart
import com.hatshop_api.repositories.ShoppingCartRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("shopping-carts")
@Tag(name = "Shopping Carts")
class ShoppingCartController(repository: ShoppingCartRepository) : AbstractRestController<ShoppingCart, Int>(repository)
