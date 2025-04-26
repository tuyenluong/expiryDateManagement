package com.ims.product.v1.service.imp;

import com.ims.product.v1.entity.Product;
import com.ims.product.v1.exception.ResourceNotFoundException;
import com.ims.product.v1.repository.ProductRepository;
import com.ims.product.v1.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByUUID(UUID id) {
        return productRepository.findByUUID(id).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current UUID: "+ id.toString()));
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku).orElseThrow(
                () -> new ResourceNotFoundException("Not found resource with current SKU: "+ sku));
    }

}
