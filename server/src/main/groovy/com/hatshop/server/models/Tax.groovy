package com.hatshop.server.models
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1


import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Tax generated by hbm2java
 */
@Entity
class Tax implements Serializable {
  Tax() {}

  Tax(String taxType, BigDecimal taxPercentage) {
    this.taxType = taxType
    this.taxPercentage = taxPercentage
  }

  @Id
  @GeneratedValue
  Integer id

  @NotEmpty
  @Size(max = 100)
  @Column(nullable = false, length = 100)
  String taxType

  @NotNull
  @Column(nullable = false, precision = 10)
  BigDecimal taxPercentage

  @OneToMany(mappedBy = "tax")
  Set<EOrder> orders = new HashSet<EOrder>(0)
}


