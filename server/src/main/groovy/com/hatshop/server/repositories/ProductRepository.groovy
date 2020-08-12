package com.hatshop.server.repositories

import com.hatshop.server.models.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Handles the products data
 * Created by luis on 6/19/15.
 */
interface ProductRepository extends JpaRepository<Product, Integer> {

    Page<Product> findPageByCategories_Department_Id(Integer id, Pageable pageable)

    Page<Product> findPageByCategories_Id(Integer id, Pageable pageable)
}
