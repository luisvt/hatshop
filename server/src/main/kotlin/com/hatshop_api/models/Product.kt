package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.OneToMany
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

@Entity
class Product(
  @NotEmpty
  @Size(max = 1000)
  @Column(nullable = false, length = 50)
  var name: String,

  @NotEmpty
  @Size(max = 1000)
  @Column(nullable = false, length = 1000)
  var description: String,

  @NotNull
  @Column(nullable = false, precision = 10)
  var price: BigDecimal,

  @NotNull
  @Column(nullable = false, precision = 10)
  var discountedPrice: BigDecimal,

  @Size(max = 150)
  @Column(length = 150)
  var image: String,

  @Size(max = 150)
  @Column(length = 150)
  var thumbnail: String,

  @Column(nullable = false)
  var display: Short,

//    @Column(name = "search_vector")
//    var searchVector: Serializable,

  @ManyToMany
  @JoinTable(
    name = "product_category",
    joinColumns = [JoinColumn(name = "product_id", nullable = false, updatable = false)],
    inverseJoinColumns = [JoinColumn(name = "category_id", nullable = false, updatable = false)]
  )
  var categories: Set<Category> = HashSet(0),

  @OneToMany(mappedBy = "product")
  var reviews: Set<Review> = HashSet(0),

  @OneToMany(mappedBy = "product")
  var shoppingCarts: Set<ShoppingCart> = HashSet(0),

  @Id
  @GeneratedValue
  var id: Int? = null,
)


