package com.hatshop.server.controllers

import com.hatshop.server.models.Tax
import com.hatshop.server.repositories.TaxRepository
import com.hatshop.server.utils.AbstractRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("taxes")
class TaxController extends AbstractRestController<Tax, Integer> {
    @Autowired
    TaxController(TaxRepository repo) {
        super(repo)
    }
}
