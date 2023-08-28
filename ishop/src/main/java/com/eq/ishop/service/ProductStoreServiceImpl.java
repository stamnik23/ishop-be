package com.eq.ishop.service;

import com.eq.ishop.exception.ProductNotFoundException;
import com.eq.ishop.model.ProductStore;
import com.eq.ishop.repository.ProductStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProductStoreServiceImpl implements ProductStoreService {

    private final ProductStoreRepository productStoreRepository;

    @Autowired
    public ProductStoreServiceImpl(ProductStoreRepository productStoreRepository) {
        this.productStoreRepository = productStoreRepository;
    }

    @Override
    public BigDecimal getPriceForProductInStore(Long productId, Long storeId) {
        // Implement the logic to fetch the price of the product in the specified store
        Optional<ProductStore> productStore = productStoreRepository.findByProductIdAndStoreId(productId, storeId);

        if (productStore.isPresent()) {
            return productStore.get().getPrice();
        } else {
            // Handle the case where the product is not found in the specified store
            throw new ProductNotFoundException("Product not found in store");
        }
    }

    // Implement other methods...
}