package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotEmpty

@Entity
class Category(
  @ManyToOne(fetch = FetchType.LAZY)
  var department: Department,

  @NotEmpty
  @Column(nullable = false, length = 50)
  var name: String,

  @Column(length = 1000)
  var description: String,

  @ManyToMany
  @JoinTable(
    name = "product_category",
    joinColumns = [JoinColumn(name = "category_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "product_id", nullable = false, updatable = false)]
  )
  var products: MutableSet<Product>? = HashSet(0),

  @Id
  @GeneratedValue
  var id: Int? = null,
)
