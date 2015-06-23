package com.hatshop.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1


import javax.persistence.*

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer",
        schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Customer.class)
public class Customer implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    int id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_region_id", nullable = false)
    ShippingRegion shippingRegion

    @Column(name = "name", nullable = false, length = 50)
    String name

    @Column(name = "email", unique = true, nullable = false, length = 100)
    String email

    @Column(name = "password", nullable = false, length = 50)
    String password

    @Column(name = "credit_card")
    String creditCard

    @Column(name = "address_1", length = 100)
    String address1

    @Column(name = "address_2", length = 100)
    String address2

    @Column(name = "city", length = 100)
    String city

    @Column(name = "region", length = 100)
    String region

    @Column(name = "postal_code", length = 100)
    String postalCode

    @Column(name = "country", length = 100)
    String country

    @Column(name = "day_phone", length = 100)
    String dayPhone

    @Column(name = "eve_phone", length = 100)
    String evePhone

    @Column(name = "mob_phone", length = 100)
    String mobPhone

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    Set<EOrder> orders = new HashSet<EOrder>(0)
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    Set<Review> reviews = new HashSet<Review>(0)


}


