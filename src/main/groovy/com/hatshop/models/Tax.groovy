package com.hatshop.models;
// Generated Jun 19, 2015 2:01:18 AM by Hibernate Tools 4.3.1


import javax.persistence.*

/**
 * Tax generated by hbm2java
 */
@Entity
@Table(name = "tax", schema = "public")
public class Tax implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "tax_type", nullable = false, length = 100)
    private String taxType;

    @Column(name = "tax_percentage", nullable = false, precision = 10)
    private BigDecimal taxPercentage;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tax")
    private Set<EOrder> orderses = new HashSet<EOrder>(0);
}


