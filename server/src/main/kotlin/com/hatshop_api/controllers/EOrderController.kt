package com.hatshop_api.controllers

import com.hatshop_api.models.EOrder
import com.hatshop_api.repositories.EOrderRepository
import com.hatshop_api.utils.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("orders")
class EOrderController(repository: EOrderRepository) : AbstractRestController<EOrder, Int>(repository)
