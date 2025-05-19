package com.ims.product.v1.service;

import com.ims.product.v1.dto.request.UpdateRequestDto;
import com.ims.product.v1.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product createProduct(Product product);

    Page<Product> getAllProducts(Pageable pageable);

    int updateDateBySku(String sku, UpdateRequestDto updateRequestDto);

    int deleteProductBySku(String sku);

    Product getProductBySKU(String sku);


}
