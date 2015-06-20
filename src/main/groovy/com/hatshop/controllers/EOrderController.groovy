package com.hatshop.controllers

import com.hatshop.RESTController
import com.hatshop.models.EOrder
import com.hatshop.repositories.EOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("orders")
class EOrderController extends RESTController<EOrder, Integer> {
    @Autowired
    EOrderController(EOrderRepository repo) {
        super(repo)
    }
}
