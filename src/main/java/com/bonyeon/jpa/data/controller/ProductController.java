package com.bonyeon.jpa.data.controller;

import com.bonyeon.jpa.data.dto.ChangeProductNameDto;
import com.bonyeon.jpa.data.dto.ProductDto;
import com.bonyeon.jpa.data.dto.ProductResponseDto;
import com.bonyeon.jpa.data.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProduct(number));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.saveProduct(productDto));
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductNameDto changeProductNameDto) throws Exception {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.changeProductName(changeProductNameDto.getNumber(), changeProductNameDto.getName()));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("정상적으로 삭제되었습니다.");
    }
}
