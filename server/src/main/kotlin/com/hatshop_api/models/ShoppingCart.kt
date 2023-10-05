package com.hatshop_api.models

import jakarta.persistence.AttributeOverride
import jakarta.persistence.AttributeOverrides
import jakarta.persistence.Column
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import jakarta.validation.constraints.NotNull
import java.util.Date

@Entity
class ShoppingCart(
  @EmbeddedId
  @AttributeOverrides(
    AttributeOverride(name = "id", column = Column(name = "id", nullable = false, length = 32)),
    AttributeOverride(name = "productId", column = Column(name = "product_id", nullable = false))
  )
  var id: ShoppingCartId,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, insertable = false, updatable = false)
  var product: Product,

  @NotNull
  @Column(nullable = false)
  var quantity: Int,

  @NotNull
  @Column(nullable = false)
  var buyNow: Boolean,

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, length = 29)
  var addedOn: Date,
)
