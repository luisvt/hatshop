package com.hatshop_api.repositories

import com.hatshop_api.models.Tax
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface TaxRepository : JpaRepository<Tax, Int>, JpaSpecificationExecutor<Tax>
