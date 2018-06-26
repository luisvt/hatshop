package com.hatshop.models

import javax.persistence.*

import static javax.persistence.FetchType.LAZY
import static javax.persistence.GenerationType.IDENTITY
import static javax.persistence.TemporalType.TIMESTAMP

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
@Entity
@Table(name = "e_order", schema = "public")
class EOrder implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    int id

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id")
    Customer customer

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "shipping_id")
    Shipping shipping

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "tax_id")
    Tax tax

    @Column(name = "total_amount", nullable = false, precision = 10)
    BigDecimal totalAmount

    @Temporal(TIMESTAMP)
    @Column(name = "created_on", nullable = false, length = 29)
    Date createdOn

    @Temporal(TIMESTAMP)
    @Column(name = "shipped_on", length = 29)
    Date shippedOn

    @Column(name = "status", nullable = false)
    int status

    @Column(name = "comments")
    String comments

    @Column(name = "auth_code", length = 50)
    String authCode

    @Column(name = "reference", length = 50)
    String reference

    @OneToMany(mappedBy = "orders")
    Set<Audit> audits = new HashSet<Audit>(0)

    @OneToMany(mappedBy = "orders")
    Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0)
}


