package com.hatshop_api.repositories

import com.hatshop_api.models.EOrder
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface EOrderRepository : JpaRepositoryAndSpecificationExecutor<EOrder, Int>
