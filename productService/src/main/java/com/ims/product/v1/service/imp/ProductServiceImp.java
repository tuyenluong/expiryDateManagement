package com.ims.product.v1.service.imp;

import com.ims.product.v1.entity.Product;
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
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public int updateProductExpiryDateBSku(String sku, String localDate) {
        productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
        LocalDate date = LocalDate.parse(localDate);
        return productRepository.updateExpiryDateBySku(date,sku);
    }

    @Override
    public int updateProductProductionDateBSku(String sku, String localDate) {
        productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
        LocalDate date = LocalDate.parse(localDate);
        return productRepository.updateProductionDateBySku(date,sku);
    }

    @Override
    public int deleteProductBySku(String sku) {
        productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
        return productRepository.deleteBySku(sku);
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: " + sku));
    }

}
