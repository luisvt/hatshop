package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty

@Entity
class ShippingRegion(
  @NotEmpty
  @Column(nullable = false, length = 100)
  var shippingRegion: String?,

  @OneToMany(mappedBy = "shippingRegion")
  var shippings: MutableSet<Shipping>? = mutableSetOf(),

  @OneToMany(mappedBy = "shippingRegion")
  var customers: MutableSet<Customer>? = mutableSetOf(),

  @Id
  @GeneratedValue
  var id: Int? = null,
)


