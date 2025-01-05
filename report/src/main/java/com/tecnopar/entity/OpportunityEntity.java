package com.tecnopar.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "opportunity")
@Data@NoArgsConstructor
public class OpportunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    @Column(name = "proposal_id")
    private Long proposal;

    private String customer;

    @Column(name = "price_tonne")
    private BigDecimal PriceTonne;

    @Column(name = "last_currency_quotation")
    private BigDecimal lastDollarQuotation;
}
