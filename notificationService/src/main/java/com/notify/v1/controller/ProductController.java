package com.notify.v1.controller;

import com.notify.v1.dto.request.ProductDto;
import com.notify.v1.dto.request.UpdateRequestDto;
import com.notify.v1.dto.response.DeletedDto;
import com.notify.v1.dto.response.UpdateResponseDto;
import com.notify.v1.mapper.ProductMapper;
import com.notify.v1.model.Product;
import com.notify.v1.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/api/v1/products", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> getProducts(
            @PageableDefault(size = 10, page = 0, sort = "name",
                    direction = Sort.Direction.ASC) Pageable pageable) {
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

    @PostMapping(value = "/import", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> importProdcts(@RequestPart final MultipartFile file){
        productService.importProducts(file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportProducts() {
        ByteArrayResource resource = productService.exportProducts();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=products_info.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
    }

    @GetMapping("/offShelfDate")
    public ResponseEntity<?> getOffShelfDateProducts() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/expiryDate")
    public ResponseEntity<?> getExpiryDateProducts() {
        return ResponseEntity.ok().build();
    }

}
