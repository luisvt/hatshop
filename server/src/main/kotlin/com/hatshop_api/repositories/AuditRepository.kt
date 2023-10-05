package com.hatshop_api.repositories

import com.hatshop_api.models.Audit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface AuditRepository : JpaRepository<Audit, Int>, JpaSpecificationExecutor<Audit> {

}
