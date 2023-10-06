package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType.TIMESTAMP
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal
import java.util.*


// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
@Entity
class EOrder(
  @Id
  @GeneratedValue
  var id: Int,

  @ManyToOne(fetch = LAZY)
  var customer: Customer,

  @ManyToOne(fetch = LAZY)
  var shipping: Shipping,

  @ManyToOne(fetch = LAZY)
  var tax: Tax,

  @NotNull
  @Column(nullable = false, precision = 10)
  var totalAmount: BigDecimal,

  @NotNull
  @Temporal(TIMESTAMP)
  @Column(nullable = false, length = 29)
  var createdOn: Date,

  @Temporal(TIMESTAMP)
  @Column(length = 29)
  var shippedOn: Date,

  @NotNull
  @Column(nullable = false)
  var status: Int,

  var comments: String,

  @Size(max = 50)
  @Column(length = 50)
  var authCode: String,

  @Size(max = 50)
  @Column(length = 50)
  var reference: String,

  @OneToMany(mappedBy = "orders")
  var audits: Set<Audit> = HashSet(0),

  @OneToMany(mappedBy = "orders")
  var orderDetails: Set<OrderDetail> = HashSet(0),
)


