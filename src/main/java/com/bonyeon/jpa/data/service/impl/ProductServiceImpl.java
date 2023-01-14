package com.bonyeon.jpa.data.service.impl;

import com.bonyeon.jpa.data.dao.ProductDAO;
import com.bonyeon.jpa.data.dto.ProductDto;
import com.bonyeon.jpa.data.dto.ProductResponseDto;
import com.bonyeon.jpa.data.entity.Product;
import com.bonyeon.jpa.data.repository.ProductRepository;
import com.bonyeon.jpa.data.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productRepository.findById(number).get();

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());
        product.setPrice(productDto.getPrice());
        product.setCreatedAt(LocalDateTime.now());
        product.setModifiedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);

        ProductResponseDto dto = new ProductResponseDto();
        dto.setNumber(savedProduct.getNumber());
        dto.setName(savedProduct.getName());
        dto.setPrice(savedProduct.getPrice());
        dto.setStock(savedProduct.getStock());

        return dto;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception {
        Product foundProduct = productRepository.findById(number).get();
        foundProduct.setName(name);
        Product changedProduct = productRepository.save(foundProduct);

        ProductResponseDto dto = new ProductResponseDto();
        dto.setNumber(changedProduct.getNumber());
        dto.setName(changedProduct.getName());
        dto.setPrice(changedProduct.getPrice());
        dto.setStock(changedProduct.getStock());

        return dto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productRepository.deleteById(number);
    }
}
