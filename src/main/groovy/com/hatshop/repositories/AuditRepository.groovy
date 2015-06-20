package com.hatshop.repositories

import com.hatshop.models.Audit
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface AuditRepository extends JpaRepository<Audit, Integer> {

}