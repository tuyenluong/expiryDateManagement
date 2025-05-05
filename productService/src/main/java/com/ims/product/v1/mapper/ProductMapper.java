package com.ims.product.v1.mapper;

import com.ims.product.v1.dto.request.ProductDto;
import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.dto.response.UpdateExpiryDateDto;
import com.ims.product.v1.dto.response.UpdateProductionDto;
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
        LocalDate getExpiryDate = LocalDate.parse(productDto.getExpiryDate(), DateTimeFormatter.ofPattern(DateFormatCons.YYYY_MM_DD_HYPHEN));
        product.setExpiryDate(getExpiryDate);
        LocalDate getProductionDate = LocalDate.parse(productDto.getProductionDate(), DateTimeFormatter.ofPattern(DateFormatCons.YYYY_MM_DD_HYPHEN));
        product.setProductionDate(getProductionDate);
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

    public static UpdateExpiryDateDto productToUpdateExpiryDateDto(Product product, Integer affectedRows){
        UpdateExpiryDateDto updateExpiryDateDto = new UpdateExpiryDateDto();
        String sku = product.getSku();
        updateExpiryDateDto.setSku(sku);
        updateExpiryDateDto.setName(product.getName());
        updateExpiryDateDto.setExpiryDate(product.getExpiryDate());
        if(affectedRows.equals(1)){
            updateExpiryDateDto.setMessage("Update SKU Expiry date successfully: " + sku);
        }else{
            updateExpiryDateDto.setMessage("Technical error when update ExpiryDate with SKU: " + sku);
        }
        return updateExpiryDateDto;
    }

    public static UpdateProductionDto productToUpdateProductionDto(Product product, Integer affectedRows){
        UpdateProductionDto updateProductionDto = new UpdateProductionDto();
        String sku = product.getSku();
        updateProductionDto.setSku(sku);
        updateProductionDto.setName(product.getName());
        updateProductionDto.setProductionDate(product.getProductionDate());
        if(affectedRows.equals(1)){
            updateProductionDto.setMessage("Update SKU Production date successfully: " + sku);
        }else{
            updateProductionDto.setMessage("Technical error when update ProductionDate with SKU: " + sku);
        }
        return updateProductionDto;
    }
}
