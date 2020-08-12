package com.hatshop.server.controllers

import com.hatshop.server.utils.AbstractRestController
import com.hatshop.server.models.EOrder
import com.hatshop.server.repositories.EOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("orders")
class EOrderController extends AbstractRestController<EOrder, Integer> {
    @Autowired
    EOrderController(EOrderRepository repo) {
        super(repo)
    }
}
