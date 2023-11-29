package com.hatshop_api.security.models


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.ManyToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class EUser(
  @NotEmpty
  @Size(max = 50)
  @Column(nullable = false, length = 50)
  var firstName: String?,

  @NotEmpty
  @Size(max = 50)
  @Column(nullable = false, length = 50)
  var lastName: String?,

  @NotEmpty
  @Size(max = 30)
  @Column(unique = true, nullable = false, length = 30)
  @get:JvmName("getUsername_")
  var username: String?,

  @NotEmpty
  @Size(max = 50)
  @Column(unique = true, nullable = false, length = 50)
  var email: String?,

  @JsonIgnore
  @NotEmpty
  @Column(nullable = false, length = 100)
  private var password: String?,

  @ManyToMany(fetch = FetchType.EAGER)
  var roles: MutableSet<Role>? = mutableSetOf(),

  private var accountNonExpired: Boolean = true,

  private var accountNonLocked: Boolean = true,

  private var credentialsNonExpired: Boolean = true,

  private var enabled: Boolean = true,

  @Id
  @GeneratedValue
  var id: Int? = null,
) : UserDetails {
  override fun getAuthorities(): MutableCollection<out GrantedAuthority>? = roles

  override fun getPassword(): String? = password

  override fun getUsername(): String? = username

  override fun isAccountNonExpired(): Boolean = accountNonExpired

  override fun isAccountNonLocked(): Boolean = accountNonLocked

  override fun isCredentialsNonExpired(): Boolean = credentialsNonExpired

  override fun isEnabled(): Boolean = enabled
}
