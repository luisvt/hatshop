package com.hatshop.controllers

import com.hatshop.RESTController
import com.hatshop.models.Audit
import com.hatshop.repositories.AuditRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("audits")
class AuditController extends RESTController<Audit, Integer> {
    @Autowired
    AuditController(AuditRepository repo) {
        super(repo)
    }
}
