package com.hatshop.security.models

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*
import javax.validation.constraints.NotEmpty

/**
 * Created by luis on 4/18/15.
 */
@Entity
class User implements UserDetails {
    @Id
    @GeneratedValue
    Integer id

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Collection<Role> authorities

    @NotEmpty
    @JsonIgnore
    String password

    @NotEmpty
    String username

    boolean accountNonExpired = true
    boolean accountNonLocked = true
    boolean credentialsNonExpired = true
    boolean enabled = true

    User() {}

    User(String username, String password, Collection<Role> authorities) {
        this.username = username
        this.password = password
        this.authorities = authorities
    }
}
