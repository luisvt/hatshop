package com.hatshop.repositories

import com.hatshop.models.EOrder
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 6/19/15.
 */
interface EOrderRepository extends JpaRepository<EOrder, Integer> {

}