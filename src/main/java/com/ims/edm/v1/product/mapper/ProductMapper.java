package com.ims.edm.v1.product.mapper;

import com.ims.edm.v1.product.dto.ProductDto;
import com.ims.edm.v1.product.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product, ProductDto productDto){
        productDto.setSku(product.getSku());
        productDto.setName(product.getName());
        productDto.setExpiryDate(product.getExpiryDate());
        productDto.setProductionDate(product.getProductionDate());
        return productDto;
    }

    public static Product toEntity(ProductDto productDto, Product product){
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
        product.setExpiryDate(productDto.getExpiryDate());
        product.setProductionDate(productDto.getProductionDate());
        return product;
    }
}
