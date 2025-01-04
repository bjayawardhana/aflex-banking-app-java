package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Payment {
    @Id
    private Long id;
    private Double amount;
    private String paymentDate;

    // Getters and setters
}
