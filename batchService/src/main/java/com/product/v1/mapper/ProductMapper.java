package com.product.v1.mapper;

import com.product.v1.dto.request.ProductDto;
import com.product.v1.dto.response.DeletedDto;
import com.product.v1.dto.response.UpdateResponseDto;
import com.product.v1.model.Product;
import com.product.v1.constant.DateFormatCons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductMapper {

    public static ProductDto productToDto(Product product) {
        ProductDto productDto = ProductDto.builder().sku(product.getSku()).name(product.getName()).build();
        String getExpiryDate = product.getExpiryDate().toString();
        productDto.setExpiryDate(getExpiryDate);
        String getProductionDate = product.getProductionDate().toString();
        productDto.setProductionDate(getProductionDate);
        return productDto;
    }

    public static Product productDtoToEntity(ProductDto productDto) {
        Product product = Product.builder().sku(productDto.getSku()).name(productDto.getName()).build();
        if(productDto.getExpiryDate() != null){
            LocalDate getExpiryDate = LocalDate.parse(productDto.getExpiryDate(), DateTimeFormatter.ofPattern(DateFormatCons.YYYY_MM_DD_HYPHEN));
            product.setExpiryDate(getExpiryDate);
        }
        if(productDto.getProductionDate() != null){
            LocalDate getProductionDate = LocalDate.parse(productDto.getProductionDate(), DateTimeFormatter.ofPattern(DateFormatCons.YYYY_MM_DD_HYPHEN));
            product.setProductionDate(getProductionDate);
        }
        return product;
    }

    public static DeletedDto productToDeleteDto(Product product, Integer affectedRows){
        DeletedDto deletedDto = new DeletedDto();
        String sku = product.getSku();
        deletedDto.setSku(sku);
        deletedDto.setName(product.getName());
        if(affectedRows.equals(1)){
            deletedDto.setMessage("Delete SKU successfully: " + sku);
        }else{
            deletedDto.setMessage("Technical error when delete SKU: " + sku);
        }
        return deletedDto;
    }

    public static UpdateResponseDto productToUpdateResponseDto(Product product, Integer affectedRows){
        UpdateResponseDto updateResponseDto = new UpdateResponseDto();
        String sku = product.getSku();
        updateResponseDto.setSku(sku);
        if(affectedRows.equals(1)){
            updateResponseDto.setExpiryDate(String.valueOf(product.getExpiryDate()));
            updateResponseDto.setProductionDate(String.valueOf(product.getProductionDate()));
            updateResponseDto.setMessage("Update SKU Expiry date successfully: " + sku);
        }else{
            updateResponseDto.setMessage("Technical error when update Date with SKU: " + sku);
        }
        return updateResponseDto;
    }
}
