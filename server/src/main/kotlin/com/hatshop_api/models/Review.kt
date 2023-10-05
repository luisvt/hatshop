package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
class Review(
  @Id
  @GeneratedValue
  var id: Int,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  var customer: Customer,

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  var product: Product,

  @Column(nullable = false)
  var review: String,

  @Column(nullable = false)
  var rating: Short,

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, length = 29)
  var createdOn: Date,
)


