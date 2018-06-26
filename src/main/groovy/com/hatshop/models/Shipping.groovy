package com.hatshop.models
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1


import javax.persistence.*

/**
 * Shipping generated by hbm2java
 */
@Entity
@Table(name = "shipping"
        , schema = "public"
)
class Shipping implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    int id
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_region_id", nullable = false)
    ShippingRegion shippingRegion

    @Column(name = "shipping_type", nullable = false, length = 100)
    String shippingType

    @Column(name = "shipping_cost", nullable = false, precision = 10)
    BigDecimal shippingCost

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipping")
    Set<EOrder> orders = new HashSet<EOrder>(0)

    Shipping() {}

    Shipping(int id, ShippingRegion shippingRegion, String shippingType, BigDecimal shippingCost) {
        this.id = id
        this.shippingRegion = shippingRegion
        this.shippingType = shippingType
        this.shippingCost = shippingCost
    }

    Shipping(int id, ShippingRegion shippingRegion, String shippingType, BigDecimal shippingCost, Set<EOrder> orderses) {
        this.id = id
        this.shippingRegion = shippingRegion
        this.shippingType = shippingType
        this.shippingCost = shippingCost
        this.orderses = orderses
    }
}


