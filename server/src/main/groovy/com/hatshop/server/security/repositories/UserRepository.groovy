package com.hatshop.server.security.repositories

import com.hatshop.server.security.models.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by luis on 4/18/15.
 */
interface UserRepository extends JpaRepository<User, Integer> {
  User findOneByUsername(String username)
}
