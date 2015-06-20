package com.hatshop.repositories

import com.hatshop.models.Tax
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface TaxRepository extends JpaRepository<Tax, Integer> {

}