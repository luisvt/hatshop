package com.hatshop_api.repositories

import com.hatshop_api.models.Audit
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface AuditRepository : JpaRepositoryAndSpecificationExecutor<Audit, Int>
