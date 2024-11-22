package com.tecnopar.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class QuotationDTO {

    private Date date;

    private BigDecimal currencyPrice;
//
//    private String pctChange;
//
//    private String pair;
}
