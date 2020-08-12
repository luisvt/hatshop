package com.hatshop.server.models

import javax.persistence.*

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * ShoppingCart generated by hbm2java
 */
@Entity
@Table(name = "shopping_cart", schema = "public")
class ShoppingCart implements Serializable {
    @EmbeddedId
    @AttributeOverrides([
            @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false, length = 32)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false))])
    ShoppingCartId id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    Product product

    @Column(name = "quantity", nullable = false)
    int quantity

    @Column(name = "buy_now", nullable = false)
    boolean buyNow

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_on", nullable = false, length = 29)
    Date addedOn
}

