package com.hatshop.server.security.models


import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.security.core.userdetails.UserDetails

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY

/**
 * Created by luis on 4/18/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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
    @Size(max = 30)
    @Column(unique = true, nullable = false, length = 30)
    String username

    @NotEmpty
    @Size(max = 50)
    @Column(unique = true, nullable = false, length = 50)
    String email

    @NotEmpty
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    String firstName

    @NotEmpty
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    String lastName

    boolean accountNonExpired = true

    boolean accountNonLocked = true

    boolean credentialsNonExpired = true

    boolean enabled = true

    User() {}

    User(String firstName, String lastName, String username, String email, String password, Collection<Role> authorities) {
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.email = email
        this.password = password
        this.authorities = authorities
    }
}
