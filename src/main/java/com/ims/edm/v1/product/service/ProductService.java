package com.ims.edm.v1.product.service;

import com.ims.edm.v1.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

     Product createProduct(Product product);

     List<Product> getAllProduct();

     Product getProductByUUID(UUID id);

     Product getProductBySKU(String sku);


}
