package com.hatshop.server.models
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1


import javax.persistence.*

/**
 * OrderDetail generated by hbm2java
 */
@Entity
@Table(name = "order_detail"
        , schema = "public"
)
class OrderDetail implements Serializable {
    @EmbeddedId
    @AttributeOverrides([
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false))])
    OrderDetailId id
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    EOrder orders

    @Column(name = "product_name", nullable = false, length = 50)
    String productName

    @Column(name = "quantity", nullable = false)
    int quantity

    @Column(name = "unit_cost", nullable = false, precision = 10)
    BigDecimal unitCost

    OrderDetail() {}

    OrderDetail(OrderDetailId id, EOrder orders, String productName, int quantity, BigDecimal unitCost) {
        this.id = id
        this.orders = orders
        this.productName = productName
        this.quantity = quantity
        this.unitCost = unitCost
    }
}

