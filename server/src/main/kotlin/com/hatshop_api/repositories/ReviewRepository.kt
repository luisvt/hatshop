package com.hatshop_api.repositories

import com.hatshop_api.models.Review
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface ReviewRepository : JpaRepository<Review, Int>, JpaSpecificationExecutor<Review> {
}
