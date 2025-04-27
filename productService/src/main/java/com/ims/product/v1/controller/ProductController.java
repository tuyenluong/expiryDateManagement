package com.ims.product.v1.controller;

import com.ims.product.v1.dto.ProductDto;
import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.dto.response.UpdateExpiryDateDto;
import com.ims.product.v1.dto.response.UpdateProductionDto;
import com.ims.product.v1.entity.Product;
import com.ims.product.v1.mapper.ProductMapper;
import com.ims.product.v1.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProdct(@RequestBody ProductDto productDto) {
        productService.createProduct(ProductMapper.productDtoToEntity(productDto));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductDto> productDtos = products.stream().map(ProductMapper::productToDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @GetMapping("/products/uuid/{uuid}")
    public ResponseEntity<ProductDto> getProductByUUID(@PathVariable(name = "uuid") String uuid) {
        ProductDto productDto = ProductMapper.productToDto(productService.getProductByUUID(uuid));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/products/sku/{sku}")
    public ResponseEntity<ProductDto> getProductBySku(@PathVariable(name = "sku") String sku) {
        ProductDto productDto = ProductMapper.productToDto(productService.getProductBySKU(sku));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/product/{sku}/updateExpiryDate/{expiryDate}")
    public ResponseEntity<UpdateExpiryDateDto> updateExpiryDate(@PathVariable(name = "sku") String sku,
                                                                @PathVariable(name = "expiryDate")String date) {
        Integer affectedRows = productService.updateProductExpiryDateBSku(sku,date);
        UpdateExpiryDateDto updateExpiryDateDto = ProductMapper.productToUpdateExpiryDateDto(productService.getProductBySKU(sku), affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(updateExpiryDateDto);
    }

    @PatchMapping("/product/{sku}/updateProductionDate/{productionDate}")
    public ResponseEntity<UpdateProductionDto> updateProductionDate(@PathVariable(name = "sku") String sku,
                                                           @PathVariable(name = "productionDate")String date) {
        Integer affectedRows = productService.updateProductProductionDateBSku(sku,date);
        UpdateProductionDto updateProductionDto = ProductMapper.productToUpdateProductionDto(productService.getProductBySKU(sku), affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(updateProductionDto);
    }

    @DeleteMapping("/product/delete/{sku}")
    public ResponseEntity<DeletedDto> deleteProduct(@PathVariable(name = "sku") String sku) {
        Product product = productService.getProductBySKU(sku);
        Integer affectedRows = productService.deleteProductBySku(sku);
        DeletedDto deletedDto = ProductMapper.productToDeleteDto(product,affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }


}
