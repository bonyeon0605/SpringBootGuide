package com.bonyeon.jpa.data.repository;

import com.bonyeon.jpa.data.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
