package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
    @Id
    private Long id;
    private String branchName;
    private String location;

    // Getters and setters
}
