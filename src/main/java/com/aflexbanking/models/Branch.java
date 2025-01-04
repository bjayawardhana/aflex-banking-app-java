package com.aflexbanking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Branch {
    @Id
    private Long id;
    private String branchName;
    private String location;
    private String name;

}
