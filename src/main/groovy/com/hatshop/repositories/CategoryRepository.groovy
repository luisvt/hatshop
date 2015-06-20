package com.hatshop.repositories

import com.hatshop.models.Category
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface CategoryRepository extends JpaRepository<Category, Integer> {

}