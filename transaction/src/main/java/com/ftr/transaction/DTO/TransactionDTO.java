package com.ftr.transaction.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDTO {

    private Long userId;
    private String UserEmail;
    private Long categoryId;
    private Long typeID;
    private BigDecimal value;
    private String receiptBase64;
    private String description;
}

