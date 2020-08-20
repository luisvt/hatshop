package com.hatshop.server.models

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import static javax.persistence.FetchType.LAZY
import static javax.persistence.GenerationType.IDENTITY
import static javax.persistence.TemporalType.TIMESTAMP

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
@Entity
class EOrder implements Serializable {
    @Id
    @GeneratedValue
    Integer id

    @ManyToOne(fetch = LAZY)
    Customer customer

    @ManyToOne(fetch = LAZY)
    Shipping shipping

    @ManyToOne(fetch = LAZY)
    Tax tax

    @NotNull
    @Column(nullable = false, precision = 10)
    BigDecimal totalAmount

    @NotNull
    @Temporal(TIMESTAMP)
    @Column(nullable = false, length = 29)
    Date createdOn

    @Temporal(TIMESTAMP)
    @Column(length = 29)
    Date shippedOn

    @NotNull
    @Column(nullable = false)
    int status

    String comments

    @Size(max = 50)
    @Column(length = 50)
    String authCode

    @Size(max = 50)
    @Column(length = 50)
    String reference

    @OneToMany(mappedBy = "orders")
    Set<Audit> audits = new HashSet<>(0)

    @OneToMany(mappedBy = "orders")
    Set<OrderDetail> orderDetails = new HashSet<>(0)
}


