package com.hatshop_api.controllers

import com.hatshop_api.models.EOrder
import com.hatshop_api.repositories.EOrderRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("orders")
@Tag(name = "Orders")
class EOrderController(repository: EOrderRepository) : AbstractRestController<EOrder, Int>(repository)
