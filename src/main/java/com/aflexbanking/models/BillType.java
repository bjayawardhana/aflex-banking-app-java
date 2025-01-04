package com.aflexbanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class BillType {
    @Id
    private Long id;
    private String billTypeName;
    private String name;

    // Getters and setters
}
