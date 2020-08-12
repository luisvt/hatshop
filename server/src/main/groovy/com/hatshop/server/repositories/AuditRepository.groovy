package com.hatshop.server.repositories

import com.hatshop.server.models.Audit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Created by luis on 6/19/15.
 */
interface AuditRepository extends JpaRepository<Audit, Integer>, JpaSpecificationExecutor<Audit> {

}
