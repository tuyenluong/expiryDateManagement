package com.ims.product.v1.service.imp;

import com.ims.product.v1.dto.request.UpdateRequestDto;
import com.ims.product.v1.entity.Product;
import com.ims.product.v1.exception.ResourceAlreadyExists;
import com.ims.product.v1.exception.ResourceNotFoundException;
import com.ims.product.v1.repository.ProductRepository;
import com.ims.product.v1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        if(productRepository.findBySku(product.getSku()).isPresent()){
            throw new ResourceAlreadyExists("Resource already exists with SKU: " + product.getSku());
        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public int updateDateBySku(String sku, UpdateRequestDto updateRequestDto) {
        if(productRepository.findBySku(sku).isEmpty()){
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
        if(productRepository.findBySku(sku).isEmpty()){
            throw new ResourceNotFoundException("Not found resource with current SKU: " + sku);
        }
        return productRepository.deleteBySku(sku);
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku).orElseThrow(() -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
    }

}
