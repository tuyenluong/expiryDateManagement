package com.product.v1.service.imp;

import com.product.v1.dto.request.UpdateRequestDto;
import com.product.v1.exception.ResourceAlreadyExists;
import com.product.v1.exception.ResourceNotFoundException;
import com.product.v1.model.Product;
import com.product.v1.repository.ProductRepository;
import com.product.v1.service.ProductService;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    public void importProducts(final MultipartFile file) throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        int lastRow = sheet.getLastRowNum();
        List<Product> products = new ArrayList<>();
        for (int i = 1; i < lastRow; i++){
            Row row = sheet.getRow(i);
            String sku = String.valueOf((int) row.getCell(0).getNumericCellValue()) ;
            Cell nameProduct = row.getCell(1);
            Product product = Product.builder().sku(sku).name(nameProduct.getStringCellValue()).build();
            products.add(product);
        }
        // Define the thread pool and submit tasks
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10 threads, adjust based on your system
        List<List<Product>> partitionedProducts = partitionList(products, 500); // Partition into smaller batches (100 products per batch)
        List<Future<?>> futures = new ArrayList<>();
        // Submit save tasks to executor service
        for (List<Product> productBatch : partitionedProducts) {
            futures.add(executorService.submit(() -> {
                try {
                    productRepository.saveAll(productBatch);
                } catch (Exception e) {
                    e.printStackTrace(); // Log the error, consider handling it gracefully
                }
            }));
        }
        // Wait for all tasks to complete
        for (Future<?> future : futures) {
            try {
                future.get(); // Will throw an exception if the task fails
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // Shutdown the executor service
        executorService.shutdown();
    }
    // Helper method to partition the list into smaller batches
    private List<List<Product>> partitionList(List<Product> list, int batchSize) {
        List<List<Product>> partitions = new ArrayList<>();
        for (int i = 0; i < list.size(); i += batchSize) {
            partitions.add(list.subList(i, Math.min(i + batchSize, list.size())));
        }
        return partitions;
    }

    @Override
    public void exportProducts(){

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
