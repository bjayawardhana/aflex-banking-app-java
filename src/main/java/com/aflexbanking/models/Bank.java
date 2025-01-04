package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    private Long id;
    private String bankName;
    private String address;

    // Getters and setters
}
