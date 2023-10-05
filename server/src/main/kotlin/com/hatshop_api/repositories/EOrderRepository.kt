package com.hatshop_api.repositories

import com.hatshop_api.models.EOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface EOrderRepository : JpaRepository<EOrder, Int>, JpaSpecificationExecutor<EOrder> {

}
