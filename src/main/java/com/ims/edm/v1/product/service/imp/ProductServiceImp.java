package com.ims.edm.v1.product.service.imp;

import com.ims.edm.v1.product.entity.Product;
import com.ims.edm.v1.product.repository.ProductRepository;
import com.ims.edm.v1.product.service.ProductService;
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
        return productRepository.findByUUID(id);
    }

    @Override
    public Product getProductBySKU(String sku) {
        return productRepository.findBySku(sku);
    }

}
