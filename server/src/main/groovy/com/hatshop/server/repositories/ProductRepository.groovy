package com.hatshop.server.repositories

import com.hatshop.server.models.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

/**
 * Handles the products data
 * Created by luis on 6/19/15.
 */
interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

    List<Product> findAllByCategories_Department_Id(Integer id)
    Iterable<Product> findAllByCategories_Department_Id(Integer id, Sort pageable)
    Page<Product> findAllByCategories_Department_Id(Integer id, Pageable pageable)

    List<Product> findAllByCategories_Id(Integer id)
    Iterable<Product> findAllByCategories_Id(Integer id, Sort sort)
    Page<Product> findAllByCategories_Id(Integer id, Pageable pageable)
}
