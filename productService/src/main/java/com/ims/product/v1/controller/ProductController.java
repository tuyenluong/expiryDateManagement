package com.ims.product.v1.controller;

import com.ims.product.v1.dto.ProductDto;
import com.ims.product.v1.entity.Product;
import com.ims.product.v1.mapper.ProductMapper;
import com.ims.product.v1.service.ProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProdct(@RequestBody ProductDto productDto){
        productService.createProduct(ProductMapper.toEntity(productDto, new Product()));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<Product> products = productService.getAllProduct();
        List<ProductDto> productDtos = products.stream().map(product -> ProductMapper.toDto(product, new ProductDto())).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @GetMapping("/products/{uuid}")
    public ResponseEntity<ProductDto> getProductByUUID(@PathVariable(name = "uuid")UUID uuid){
        ProductDto productDto = ProductMapper.toDto(productService.getProductByUUID(uuid), new ProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/products/{sku}")
    public ResponseEntity<ProductDto> getProductBySku(@PathVariable(name = "sku")String sku){
        ProductDto productDto = ProductMapper.toDto(productService.getProductBySKU(sku), new ProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/product/updateExpiryDate/{uuid}")
    public ResponseEntity<ProductDto> updateExpiryDate(@PathVariable(name = "uuid")UUID uuid){
        ProductDto productDto = ProductMapper.toDto(productService.getProductByUUID(uuid), new ProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/product/updateProductionDate/{uuid}")
    public ResponseEntity<ProductDto> updateProductionDate(@PathVariable(name = "uuid")UUID uuid){
        ProductDto productDto = ProductMapper.toDto(productService.getProductByUUID(uuid), new ProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @DeleteMapping("/product/delete/{uuid}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable(name = "uuid")UUID uuid){
        ProductDto productDto = ProductMapper.toDto(productService.getProductByUUID(uuid), new ProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }


}
