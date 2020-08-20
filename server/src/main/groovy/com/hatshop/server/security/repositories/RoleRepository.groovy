package com.hatshop.server.security.repositories

import com.hatshop.server.security.models.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository extends JpaRepository<Role, Integer> {

}
