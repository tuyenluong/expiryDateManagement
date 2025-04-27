package com.ims.product.v1.service;

import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.entity.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProduct();

    int updateProductExpiryDateBSku(String sku, String localDate);

    int updateProductProductionDateBSku(String sku, String localDate);

    int deleteProductBySku(String sku);

    Product getProductByUUID(String id);

    Product getProductBySKU(String sku);


}
