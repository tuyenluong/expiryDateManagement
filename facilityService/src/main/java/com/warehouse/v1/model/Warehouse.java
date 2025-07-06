//package com.warehouse.v1.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "warehouses")
//public class Warehouse {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "warehouse_id")
//    private Long id;
//
//    @Column(nullable = false, length = 100)
//    private String name;
//
//    @OneToOne(targetEntity = Address.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "address_id", nullable = false)
//    private Address address;
//}
