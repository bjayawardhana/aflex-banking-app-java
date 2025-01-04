package com.aflexbanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Bank {
    @Id
    private Long id;
    private String bankName;
    private String name;
    private String address;

    // Getters and setters
}
