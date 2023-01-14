package com.bonyeon.jpa.data.repository;

import com.bonyeon.jpa.data.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductRepositoryTest2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void basicCRUDTest() {
        /* Create */
        // given
        Product product = Product.builder()
                .name("bonyeon")
                .price(1000)
                .stock(1234)
                .build();

        // when
        Product savedProduct = productRepository.save(product);

        // then
        assertEquals(savedProduct.getNumber(), product.getNumber());
        assertEquals(savedProduct.getName(), product.getName());
        assertEquals(savedProduct.getPrice(), product.getPrice());
        assertEquals(savedProduct.getStock(), product.getStock());

    }
}
