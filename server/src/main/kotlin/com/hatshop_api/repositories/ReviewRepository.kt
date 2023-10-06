package com.hatshop_api.repositories

import com.hatshop_api.models.Review
import com.lv_spring.data.rest.jpa.JpaRepositoryAndSpecificationExecutor


interface ReviewRepository : JpaRepositoryAndSpecificationExecutor<Review, Int>
