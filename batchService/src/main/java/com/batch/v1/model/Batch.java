package com.batch.v1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "batch")
@Data
public class Batch extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "batchId", length = 50)
    private UUID batchId;

    @Column(name = "batchCode")
    private String batchCode;

    @Column(name = "qrCode")
    private String qrCodeValue;

}

