package com.tecnopar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@Jacksonized
public class ProposalDTO {

    private Long proposalId;

//    private Date created;

    private String customer;

    private BigDecimal priceTonne;

}
