package com.hatshop_api.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

@Entity
class Department(
  @Column(length = 50)
  var name: String,

  @Column(length = 1000)
  var description: String,

  @OneToMany(mappedBy = "department")
  var categories: MutableSet<Category>? = HashSet(0),

  @Id
  @GeneratedValue
  var id: Int? = null,
)
