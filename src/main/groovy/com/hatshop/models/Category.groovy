package com.hatshop.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

import javax.persistence.*
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", schema = "public")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator)
class Category {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    int id

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    Department department

    @Column(name = "name", nullable = false, length = 50)
    String name

    @Column(name = "description", length = 1000)
    String description

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_category", schema = "public",
            joinColumns = [@JoinColumn(name = "category_id", nullable = false, updatable = false)],
            inverseJoinColumns = [@JoinColumn(name = "product_id", nullable = false, updatable = false)])
    Set<Product> products = new HashSet<Product>(0)
}


