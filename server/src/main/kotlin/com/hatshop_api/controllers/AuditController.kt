package com.hatshop_api.controllers

import com.hatshop_api.models.Audit
import com.hatshop_api.repositories.AuditRepository
import com.lv_spring.data.rest.jpa.AbstractRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("audits")
class AuditController(auditRepository: AuditRepository) : AbstractRestController<Audit, Int>(auditRepository)
