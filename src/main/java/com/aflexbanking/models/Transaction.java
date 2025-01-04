package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    private Long id;
    private Double amount;
    private String transactionDate;

    // Getters and setters
}
