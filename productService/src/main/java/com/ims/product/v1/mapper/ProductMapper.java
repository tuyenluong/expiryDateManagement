package com.ims.product.v1.mapper;

import com.ims.product.v1.dto.request.ProductDto;
import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.dto.response.UpdateResponseDto;
import com.ims.product.v1.entity.Product;
import com.ims.product.v1.constant.DateFormatCons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductMapper {

    public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setSku(product.getSku());
        productDto.setName(product.getName());
        String getExpiryDate = product.getExpiryDate().toString();
        productDto.setExpiryDate(getExpiryDate);
        String getProductionDate = product.getProductionDate().toString();
        productDto.setProductionDate(getProductionDate);
        return productDto;
    }

    public static Product productDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
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
