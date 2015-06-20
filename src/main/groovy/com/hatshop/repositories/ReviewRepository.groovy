package com.hatshop.repositories

import com.hatshop.models.Review
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface ReviewRepository extends JpaRepository<Review, Integer> {
}
