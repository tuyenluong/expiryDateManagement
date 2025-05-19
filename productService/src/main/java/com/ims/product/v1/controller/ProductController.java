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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> getProducts(
            @PageableDefault(size = 10, page = 0, sort = "name",
                    direction = Sort.Direction.ASC)
            Pageable pageable) {
        Page<Product> products = productService.getAllProducts(pageable);
        Page<ProductDto> productDtos = products.map(ProductMapper::productToDto);
        return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProdct(@RequestBody @Valid ProductDto productDto) {
        productService.createProduct(ProductMapper.productDtoToEntity(productDto));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductDto> getProductBySku(@PathVariable(name = "sku") String sku) {
        ProductDto productDto = ProductMapper.productToDto(productService.getProductBySKU(sku));
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/updateDate/{sku}")
    public ResponseEntity<UpdateResponseDto> updateDate(@PathVariable(name = "sku") String sku,
                                                        @RequestBody @Valid UpdateRequestDto updateRequestDto) {

        Integer affectedRows = productService.updateDateBySku(sku,updateRequestDto);
        UpdateResponseDto updateResponseDto = ProductMapper.productToUpdateResponseDto(productService.getProductBySKU(sku), affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(updateResponseDto);
    }

    @DeleteMapping("/delete/{sku}")
    public ResponseEntity<DeletedDto> deleteProduct(@PathVariable(name = "sku") String sku) {
        Product product = productService.getProductBySKU(sku);
        Integer affectedRows = productService.deleteProductBySku(sku);
        DeletedDto deletedDto = ProductMapper.productToDeleteDto(product,affectedRows);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }


}
