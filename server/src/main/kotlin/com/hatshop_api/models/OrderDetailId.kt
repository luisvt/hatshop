package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class OrderDetailId(
  @Column(nullable = false)
  var orderId: Int,

  @Column(nullable = false)
  var productId: Int,
) : Serializable
