package com.ims.product.v1.service.imp;

import com.ims.product.v1.entity.Product;
import com.ims.product.v1.exception.ResourceNotFoundException;
import com.ims.product.v1.repository.ProductRepository;
import com.ims.product.v1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        product.setUuid(UUID.randomUUID());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByUUID(String id) {
        return productRepository.findByUuid(UUID.fromString(id)).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current UUID: "+ id));
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: "+ sku));
    }

}
