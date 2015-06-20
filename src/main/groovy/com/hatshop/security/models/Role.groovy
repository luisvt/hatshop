package com.hatshop.security.models

import org.springframework.security.core.GrantedAuthority

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by luis on 4/18/15.
 */
@Entity
class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    int id
    String authority
}
