package com.facility.v1.model;

import jakarta.persistence.*;

@Embeddable
public class Address {

    @Column(name = "address_line", length = 100)
    private String addressLine;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;
}
