package com.hatshop_api.security.models

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority

@Entity
class Role(
  val role: String?,
  @Id
  @GeneratedValue
  var id: Int? = null,
) : GrantedAuthority {
  override fun getAuthority(): String? = role
}
