package com.aflexbanking.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillType {
    @Id
    private Long id;
    private String billTypeName;

    // Getters and setters
}
