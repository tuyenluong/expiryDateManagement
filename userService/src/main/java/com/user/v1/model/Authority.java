package com.user.v1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Authority {
    @Id
    @GeneratedValue
    private Long id;
    private String name; // e.g., EDIT_SALARY
}
