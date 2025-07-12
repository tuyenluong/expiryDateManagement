package com.product.v1.service;

import com.product.v1.dto.request.UpdateRequestDto;
import com.product.v1.model.Product;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ProductService {

    Product createProduct(Product product);

    Page<Product> getAllProducts(Pageable pageable);

    int updateDateBySku(String sku, UpdateRequestDto updateRequestDto);

    int deleteProductBySku(String sku);

    Product getProductBySKU(String sku);

    void importProducts(MultipartFile fileLocation);

    ByteArrayResource exportProducts();
}
