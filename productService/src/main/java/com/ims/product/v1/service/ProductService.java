package com.ims.product.v1.service;

import com.ims.product.v1.dto.request.UpdateRequestDto;
import com.ims.product.v1.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProduct();

    int updateDateBySku(String sku, UpdateRequestDto updateRequestDto);

    int deleteProductBySku(String sku);

    Product getProductBySKU(String sku);


}
