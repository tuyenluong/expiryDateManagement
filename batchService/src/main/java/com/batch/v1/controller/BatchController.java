package com.batch.v1.controller;

import com.batch.v1.model.Batch;
import com.batch.v1.service.BatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/batches", produces = {MediaType.APPLICATION_JSON_VALUE})
public class BatchController {

    private BatchService batchService;

    @GetMapping
    public ResponseEntity<Page<Batch>> getBatches(@PageableDefault(size = 10, page = 0, sort = "name",
            direction = Sort.Direction.ASC) Pageable pageable){
        Page<Batch> batches = batchService.getBatches(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(batches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(batchService.getBatchById(id));
    }

    @PostMapping
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch){
        return ResponseEntity.status(HttpStatus.OK).body(batchService.createBatch(batch));
    }

}
