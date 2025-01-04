package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private Double balance;

    // Getters and setters
}
