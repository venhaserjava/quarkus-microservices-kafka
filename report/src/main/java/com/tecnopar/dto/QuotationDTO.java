package com.tecnopar.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class QuotationDTO {

    private Date date;

    private BigDecimal currencyPrice;

}
