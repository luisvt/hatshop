package com.hatshop.server.repositories

import com.hatshop.server.models.EOrder
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Created by luis on 6/19/15.
 */
interface EOrderRepository extends JpaRepository<EOrder, Integer>, JpaSpecificationExecutor<EOrder> {

}
