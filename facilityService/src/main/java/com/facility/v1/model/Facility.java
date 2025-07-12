package com.facility.v1.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "facility")
public class Facility extends BaseEntity {

    @Id
    @Column(name = "facility_id")
    private UUID id;

    @Column(nullable = false, length = 100)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Embedded
    private Address address;

    @Column(nullable = false, length = 100)
    private String region;

    @Column(length = 100)
    private boolean isActive;
}
