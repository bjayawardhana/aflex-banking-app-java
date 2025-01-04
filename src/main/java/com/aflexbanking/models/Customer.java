package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    private Long id;
    private String name;
    private String email;

    // Getters and setters
}
