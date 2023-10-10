package com.hatshop_api.models

import com.hatshop_api.security.models.EUser
import com.hatshop_api.security.models.Role
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Customer(
  firstName: String,
  lastName: String,
  username: String,
  email: String,
  password: String,
  roles: MutableSet<Role>,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  var shippingRegion: ShippingRegion,

  id: Int? = null,
  @Column(length = 30)
  var creditCard: String? = null,

  @Column(length = 100)
  var address1: String? = null,

  @Column(length = 100)
  var address2: String? = null,

  @Column(length = 30)
  var city: String? = null,

  @Column(length = 30)
  var region: String? = null,

  @Column(length = 10)
  var postalCode: String? = null,

  @Column(length = 30)
  var country: String? = null,

  @Column(length = 20)
  var dayPhone: String? = null,

  @Column(length = 20)
  var evePhone: String? = null,

  @Column(length = 20)
  var mobPhone: String? = null,

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  var orders: MutableSet<EOrder> = HashSet(0),

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
  var reviews: MutableSet<Review> = HashSet(0),
) : EUser(firstName, lastName, username, email, password, roles, id = id)
