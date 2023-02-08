package com.bonyeon.jpa.data.repository;

import com.bonyeon.jpa.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
