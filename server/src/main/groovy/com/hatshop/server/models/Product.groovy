package com.hatshop.server.models


import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Product generated by hbm2java
 */
@Entity
class Product implements Serializable {
    Product() {}

    Product(String name,
            String description,
            BigDecimal price,
            BigDecimal discountedPrice,
            String image,
            String thumbnail,
            short display,
            Set<Category> categories) {
        this.name = name
        this.description = description
        this.price = price
        this.discountedPrice = discountedPrice
        this.image = image
        this.thumbnail = thumbnail
        this.display = display
        this.categories = categories
    }

    @Id
    @GeneratedValue
    int id

    @NotEmpty
    @Column(nullable = false, length = 50)
    String name

    @NotEmpty
    @Column(nullable = false, length = 1000)
    String description

    @NotNull
    @Column(nullable = false, precision = 10)
    BigDecimal price

    @NotNull
    @Column(nullable = false, precision = 10)
    BigDecimal discountedPrice

    @Column(length = 150)
    String image

    @Column(length = 150)
    String thumbnail

    @Column(nullable = false)
    short display

//    @Column(name = "search_vector")
//    Serializable searchVector

    @OneToMany(mappedBy = "product")
    Set<Review> reviews = new HashSet<Review>(0)

    @OneToMany(mappedBy = "product")
    Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0)

    @ManyToMany
    @JoinTable(
            joinColumns = [@JoinColumn(name = "product_id", nullable = false, updatable = false)],
            inverseJoinColumns = [@JoinColumn(name = "category_id", nullable = false, updatable = false)])
    Set<Category> categories = new HashSet<Category>(0)
}


