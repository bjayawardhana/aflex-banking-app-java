package com.aflexbanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    private Long id;
    private String accountNumber;
    private Double balance;

    // Getters and setters
}
