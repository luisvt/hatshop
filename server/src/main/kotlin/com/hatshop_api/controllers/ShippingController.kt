package com.hatshop_api.controllers

import com.hatshop_api.models.Shipping
import com.hatshop_api.repositories.ShippingRepository
import com.hatshop_api.utils.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("shippings")
class ShippingController(repository: ShippingRepository) : AbstractRestController<Shipping, Int>(repository)
