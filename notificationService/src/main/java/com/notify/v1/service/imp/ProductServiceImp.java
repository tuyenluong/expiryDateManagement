package com.notify.v1.service.imp;

import com.notify.v1.dto.request.UpdateRequestDto;
import com.notify.v1.exception.ResourceAlreadyExists;
import com.notify.v1.exception.ResourceNotFoundException;
import com.notify.v1.model.Product;
import com.notify.v1.repository.ProductRepository;
import com.notify.v1.service.ProductService;
import com.notify.v1.utils.ExcelFileManagement;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if(productRepository.existsBySku(product.getSku())){
            throw new ResourceAlreadyExists("Resource already exists with SKU: " + product.getSku());
        }
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public void importProducts(final MultipartFile file){
        List<Product> productList = ExcelFileManagement.readExcelFile(file);
        // Define the thread pool and submit tasks
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10 threads, adjust based on your system
        List<List<Product>> partitionedProducts = ExcelFileManagement.partitionList(productList, 500); // Partition into smaller batches (100 products per batch)
        List<Future<?>> futures = new ArrayList<>();
        // Submit save tasks to executor service
        for (List<Product> productBatch : partitionedProducts) {
            futures.add(executorService.submit(() -> {
                productRepository.saveAll(productBatch);
            }));
        }
        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // Will throw an exception if the task fails
            } catch (InterruptedException | ExecutionException e) {
                log.debug(e.toString());
            }
        }
        // Shutdown the executor service
        executorService.shutdown();
    }


    @Override
    public ByteArrayResource exportProducts(){
        List<Product> list = productRepository.findAll();
        byte[] fileBytes = ExcelFileManagement.exportExcelBytes(list);
        return new ByteArrayResource(fileBytes);
    }

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public int updateDateBySku(String sku, UpdateRequestDto updateRequestDto) {
        if(productRepository.existsBySku(sku)){
            throw new ResourceNotFoundException("Not found resource with current SKU: " + sku);
        }
        if(updateRequestDto.getExpiryDate() != null && updateRequestDto.getProductionDate() != null){
            LocalDate getExpiryDate = LocalDate.parse(updateRequestDto.getExpiryDate());
            LocalDate getProductionDate = LocalDate.parse(updateRequestDto.getProductionDate());
            return productRepository.updateDateBySku(getExpiryDate, getProductionDate, sku);
        }
        if(updateRequestDto.getExpiryDate() != null){
            LocalDate date = LocalDate.parse(updateRequestDto.getExpiryDate());
            return productRepository.updateExpiryDateBySku(date, sku);
        }
        if(updateRequestDto.getProductionDate() != null){
            LocalDate date = LocalDate.parse(updateRequestDto.getProductionDate());
            return productRepository.updateProductionDateBySku(date, sku);
        }
        return 0;
    }

    @Override
    public int deleteProductBySku(String sku) {
        if(productRepository.existsBySku(sku)){
            throw new ResourceNotFoundException("Not found resource with current SKU: " + sku);
        }
        return productRepository.deleteBySku(sku);
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku).orElseThrow(() -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
    }

}
