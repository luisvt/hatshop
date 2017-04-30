package com.hatshop.models

import javax.persistence.*

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Product generated by hbm2java
 */
@Entity
@Table(name = "product", schema = "public")
public class Product implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    int id

    @Column(nullable = false, length = 50)
    String name

    @Column(nullable = false, length = 1000)
    String description

    @Column(nullable = false, precision = 10)
    BigDecimal price

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    Set<Review> reviews = new HashSet<Review>(0)

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    Set<ShoppingCart> shoppingCarts = new HashSet<ShoppingCart>(0)

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category", schema = "public",
            joinColumns = [@JoinColumn(name = "product_id", nullable = false, updatable = false)],
            inverseJoinColumns = [@JoinColumn(name = "category_id", nullable = false, updatable = false)])
    Set<Category> categories = new HashSet<Category>(0)
}


