package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
class Tax(
  @NotEmpty
  @Size(max = 100)
  @Column(nullable = false, length = 100)
  var taxType: String,

  @NotNull
  @Column(nullable = false, precision = 10)
  var taxPercentage: BigDecimal,

  @OneToMany(mappedBy = "tax")
  var orders: MutableSet<EOrder> = HashSet(0),

  @Id
  @GeneratedValue
  var id: Int? = null,
)
