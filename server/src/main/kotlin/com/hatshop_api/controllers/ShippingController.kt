package com.hatshop_api.controllers

import com.hatshop_api.models.Shipping
import com.hatshop_api.repositories.ShippingRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("shippings")
@Tag(name = "Shippings")
class ShippingController(repository: ShippingRepository) : AbstractRestController<Shipping, Int>(repository)
