package com.user.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "authorities")
public class Authority {
    @Id
    @Column(name = "authority_id")
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
