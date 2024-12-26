package com.tecnopar.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "proposal")
@Data
@NoArgsConstructor
public class ProposalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal priceTonne;

    private Integer tonnes;

    private String country;

    @Column(name = "proposal_validity_days")
    private Integer proposalValidityDays;

}
