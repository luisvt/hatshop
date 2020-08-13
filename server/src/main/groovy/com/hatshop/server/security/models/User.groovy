package com.hatshop.server.security.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreType
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*
import javax.validation.constraints.NotEmpty

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY

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
    @Column(nullable = false, length = 100)
    @JsonProperty(access = WRITE_ONLY)
    String password

    @NotEmpty
    @Column(unique = true, nullable = false, length = 30)
    String username

    @NotEmpty
    @Column(unique = true, nullable = false, length = 50)
    String email

    @NotEmpty
    @Column(nullable = false, length = 50)
    String firstName

    @NotEmpty
    @Column(nullable = false, length = 50)
    String lastName

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
