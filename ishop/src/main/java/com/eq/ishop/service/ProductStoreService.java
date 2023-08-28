package com.eq.ishop.service;

import java.math.BigDecimal;

public interface ProductStoreService {
    // Other methods...

    BigDecimal getPriceForProductInStore(Long productId, Long storeId);
}