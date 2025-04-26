package com.ims.product.v1.service;

import com.ims.product.v1.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

     Product createProduct(Product product);

     List<Product> getAllProduct();

     Product getProductByUUID(String id);

     Product getProductBySKU(String sku);


}
