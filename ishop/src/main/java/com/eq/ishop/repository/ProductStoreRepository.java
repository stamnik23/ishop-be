package com.eq.ishop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eq.ishop.model.ProductStore;

import java.util.Optional;

@Repository
public interface ProductStoreRepository extends JpaRepository<ProductStore, Long> {
    Optional<ProductStore> findByProductIdAndStoreId(Long productId, Long storeId);
}
