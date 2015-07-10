package com.hatshop.repositories

import com.hatshop.models.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Handles the products data
 * Created by luis on 6/19/15.
 */
interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN p.categories pc WHERE pc.department.id = ?")
    Page<Product> findPageByDepartmentId(Integer id, Pageable pageable)

    @Query('SELECT p FROM Product p JOIN p.categories pc WHERE pc.id = ?')
    Page<Product> findPageByCategoryId(Integer id, Pageable pageable)
}