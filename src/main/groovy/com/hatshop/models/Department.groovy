package com.hatshop.models

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.ObjectIdGenerators

import javax.persistence.*
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", schema = "public")
@NamedEntityGraph(name = "Department.categories",
    attributeNodes = @NamedAttributeNode("categories"))
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator)
class Department {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    Integer id

    @Column(name = "name", nullable = false, length = 50)
    String name

    @Column(name = "description", length = 1000)
    String description

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    Set<Category> categories = new HashSet<Category>(0)
}


