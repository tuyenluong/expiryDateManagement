package com.batch.v1.repository;

import com.batch.v1.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BatchRepository extends JpaRepository<Batch, UUID> {

    boolean existsByBatchId(UUID uuid);

}
