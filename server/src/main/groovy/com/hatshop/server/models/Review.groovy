package com.hatshop.server.models

import javax.persistence.*

// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1
/**
 * Review generated by hbm2java
 */
@Entity
class Review implements Serializable {
  @Id
  @GeneratedValue
  int id

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  Customer customer

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false)
  Product product

  @Column(nullable = false)
  String review

  @Column(nullable = false)
  short rating

  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false, length = 29)
  Date createdOn
}


