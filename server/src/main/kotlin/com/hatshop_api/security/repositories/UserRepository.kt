package com.hatshop_api.security.repositories

import com.hatshop_api.security.models.EUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<EUser, Int> {
  fun findOneByUsername(username: String): EUser?
}
