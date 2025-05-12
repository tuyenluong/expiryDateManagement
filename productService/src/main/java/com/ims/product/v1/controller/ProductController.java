package com.ims.product.v1.controller;

import com.ims.product.v1.dto.request.ProductDto;
import com.ims.product.v1.dto.request.UpdateRequestDto;
import com.ims.product.v1.dto.response.DeletedDto;
import com.ims.product.v1.dto.response.UpdateResponseDto;
import com.ims.product.v1.entity.Product;
import com.ims.product.v1.mapper.ProductMapper;
import com.ims.product.v1.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = productService.getAllProduct();
        List<ProductDto> productDtos = products.stream().map(ProductMapper::productToDto).toList();
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProdct(@RequestBody @Valid ProductDto productDto) {
        productService.createProduct(ProductMapper.productDtoToEntity(productDto));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/products/sku/{sku}")
    public ResponseEntity<ProductDto> getProductBySku(@PathVariable(name = "sku") String sku) {
        ProductDto productDto = ProductMapper.productToDto(productService.getProductBySKU(sku));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/product/updateDate/{sku}")
    public ResponseEntity<UpdateResponseDto> updateDate(@PathVariable(name = "sku") String sku,
                                                        @RequestBody @Valid UpdateRequestDto updateRequestDto) {

        Integer affectedRows = productService.updateDateBySku(sku,updateRequestDto);
        UpdateResponseDto updateResponseDto = ProductMapper.productToUpdateResponseDto(productService.getProductBySKU(sku), affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(updateResponseDto);
    }

    @DeleteMapping("/product/delete/{sku}")
    public ResponseEntity<DeletedDto> deleteProduct(@PathVariable(name = "sku") String sku) {
        Product product = productService.getProductBySKU(sku);
        Integer affectedRows = productService.deleteProductBySku(sku);
        DeletedDto deletedDto = ProductMapper.productToDeleteDto(product,affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }


}
