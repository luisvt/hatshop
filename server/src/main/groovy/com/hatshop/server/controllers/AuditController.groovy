package com.hatshop.server.controllers

import com.hatshop.server.utils.AbstractRestController
import com.hatshop.server.models.Audit
import com.hatshop.server.repositories.AuditRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by luis on 6/20/15.
 */
@RestController
@RequestMapping("audits")
class AuditController extends AbstractRestController<Audit, Integer> {
    @Autowired
    AuditController(AuditRepository repo) {
        super(repo)
    }
}
