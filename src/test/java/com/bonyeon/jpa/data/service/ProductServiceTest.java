package com.bonyeon.jpa.data.service;

import com.bonyeon.jpa.data.dto.ProductDto;
import com.bonyeon.jpa.data.dto.ProductResponseDto;
import com.bonyeon.jpa.data.entity.Product;
import com.bonyeon.jpa.data.repository.ProductRepository;
import com.bonyeon.jpa.data.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


class ProductServiceTest {

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUpTest() {
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void getProductTest() {
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("펜");
        givenProduct.setPrice(1000);
        givenProduct.setStock(1234);

        Mockito.when(productRepository.findById(123L))
                .thenReturn(Optional.of(givenProduct));

        ProductResponseDto productResponseDto = productService.getProduct(123L);

        assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        assertEquals(productResponseDto.getName(), givenProduct.getName());
        assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);
    }

    @Test
    void saveProductTest() {
        Mockito.when(productRepository.save(any(Product.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("펜", 1000, 1234));

        assertEquals(productResponseDto.getName(), "펜");
        assertEquals(productResponseDto.getPrice(), 1000);
        assertEquals(productResponseDto.getStock(), 1234);

        verify(productRepository).save(any());
    }

}