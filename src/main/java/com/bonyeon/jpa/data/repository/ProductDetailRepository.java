package com.bonyeon.jpa.data.repository;

import com.bonyeon.jpa.data.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
