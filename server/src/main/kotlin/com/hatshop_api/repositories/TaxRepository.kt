package com.hatshop_api.repositories

import com.hatshop_api.models.Tax
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface TaxRepository : JpaRepositoryAndSpecificationExecutor<Tax, Int>
