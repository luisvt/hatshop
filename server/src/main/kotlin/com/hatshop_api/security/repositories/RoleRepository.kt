package com.hatshop_api.security.repositories

import com.hatshop_api.security.models.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Int>
