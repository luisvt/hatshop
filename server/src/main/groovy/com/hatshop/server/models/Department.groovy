package com.hatshop.server.models


import javax.persistence.*

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Department generated by hbm2java
 */
@Entity
class Department {
  Department() {}

  Department(String name, String description) {
    this.name = name
    this.description = description
  }

  @Id
  @GeneratedValue
  Integer id

  @Column(length = 50)
  String name

  @Column(length = 1000)
  String description

  @OneToMany(mappedBy = "department")
  Set<Category> categories = new HashSet<Category>(0)
}


