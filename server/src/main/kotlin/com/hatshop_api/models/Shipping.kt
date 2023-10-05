package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
class Shipping(
  @NotEmpty
  @Size(max = 100)
  @Column(nullable = false, length = 100)
  var shippingType: String,

  @NotNull
  @Column(nullable = false, precision = 10)
  var shippingCost: BigDecimal,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  var shippingRegion: ShippingRegion,

  @OneToMany(mappedBy = "shipping")
  var orders: Set<EOrder> = HashSet(0),

  @Id
  @GeneratedValue
  var id: Int? = null,
)
