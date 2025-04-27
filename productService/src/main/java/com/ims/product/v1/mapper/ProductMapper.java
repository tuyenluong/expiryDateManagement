package com.ims.product.v1.mapper;

import com.ims.product.v1.dto.ProductDto;
import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.dto.response.UpdateExpiryDateDto;
import com.ims.product.v1.dto.response.UpdateProductionDto;
import com.ims.product.v1.entity.Product;

public class ProductMapper {

    public static ProductDto productToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setSku(product.getSku());
        productDto.setName(product.getName());
        productDto.setExpiryDate(product.getExpiryDate());
        productDto.setProductionDate(product.getProductionDate());
        return productDto;
    }

    public static Product productDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setSku(productDto.getSku());
        product.setName(productDto.getName());
        product.setExpiryDate(productDto.getExpiryDate());
        product.setProductionDate(productDto.getProductionDate());
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
            updateExpiryDateDto.setMessage("Technical error when delete SKU: " + sku);
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
            updateProductionDto.setMessage("Technical error when delete SKU: " + sku);
        }
        return updateProductionDto;
    }
}
