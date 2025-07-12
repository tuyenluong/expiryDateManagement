package com.batch.v1.service.imp;

import com.batch.v1.exception.ResourceNotFoundException;
import com.batch.v1.model.Batch;
import com.batch.v1.repository.BatchRepository;
import com.batch.v1.service.BatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BatchServiceImp implements BatchService {

    private BatchRepository batchRepository;

    public Page<Batch> getBatches(Pageable pageable) {
        return batchRepository.findAll(pageable);
    }

    @Override
    public Batch getBatchById(UUID uuid) {
        return batchRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Not found resource with current ID: " + uuid));
    }

    @Override
    public Batch createBatch(Batch batch) {
//        if(batchRepository.existsByBatchId(batch.getBatchId())){
//            throw new ResourceAlreadyExists("Resource already exists with ID: " +batch.getBatchId());
//        }
//        // Todo: create batchCode and qrCodeValue
//        return batchRepository.save(batch);
        return new Batch();
    }
}
