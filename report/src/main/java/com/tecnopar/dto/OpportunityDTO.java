package com.tecnopar.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
//import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class OpportunityDTO {

//    private Date date;
    private Long proposalId;

    private String customer;

    private BigDecimal PriceTonne;

    private BigDecimal lastDollarQuotation;
}
