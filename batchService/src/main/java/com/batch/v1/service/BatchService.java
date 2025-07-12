package com.batch.v1.service;

import com.batch.v1.model.Batch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface BatchService {

    Page<Batch> getBatches(Pageable pageable);

    Batch getBatchById(UUID uuid);

    Batch createBatch(Batch batch);
}
