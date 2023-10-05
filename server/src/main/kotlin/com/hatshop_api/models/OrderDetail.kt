package com.hatshop_api.models

import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
class OrderDetail(
  @EmbeddedId
  @AttributeOverrides(
    AttributeOverride(name = "orderId", column = Column(name = "order_id", nullable = false)),
    AttributeOverride(name = "productId", column = Column(name = "product_id", nullable = false))
  )
  var id: OrderDetailId,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, insertable = false, updatable = false)
  var orders: EOrder,

  @Size(max = 50)
  @Column(nullable = false, length = 50)
  var productName: String,

  @Column(nullable = false)
  var quantity: Int,

  @Column(nullable = false, precision = 10)
  var unitCost: BigDecimal,
)
