package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.validation.constraints.NotNull
import java.io.Serializable

@Embeddable
data class ShoppingCartId(
  @Column(nullable = false, length = 32)
  var id: String,

  @NotNull
  @Column(nullable = false)
  var productId: Int,
) : Serializable
