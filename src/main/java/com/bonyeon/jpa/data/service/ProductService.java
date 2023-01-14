package com.bonyeon.jpa.data.service;

import com.bonyeon.jpa.data.dto.ProductDto;
import com.bonyeon.jpa.data.dto.ProductResponseDto;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
