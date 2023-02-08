package com.bonyeon.jpa.data.repository.support;

import com.bonyeon.jpa.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
}
