package com.eq.ishop.controllers;

import com.eq.ishop.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/productstore")
public class ProductStoreController {
    @Autowired
    private ProductStoreService productStoreService;

    @GetMapping("/price")
    public ResponseEntity<BigDecimal> getPriceForProductInStore(
            @RequestParam Long productId,
            @RequestParam Long storeId) {
        BigDecimal price = productStoreService.getPriceForProductInStore(productId, storeId);
        return ResponseEntity.ok(price);
    }
}




