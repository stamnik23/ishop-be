package com.eq.ishop.repository;

import com.eq.ishop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Optional<Product> findById(Long id);
    boolean existsById(Long id);
    boolean deleteById(Long id);

//    List<Product> findByName(String name);
//    List<Product> findByCategory(String category);
//    List<Product> findByPriceBetween(double minPrice, double maxPrice);
//    List<Product> findByAvailable(boolean available);
//    List<Product> findByNameAndCategory(String name, String category);
//    List<Product> findByNameOrCategory(String name, String category);
//    long countByCategory(String category);
//    void deleteByCategory(String category);
//    List<Product> findByOrderByPriceAsc();
//    List<Product> findByOrderByPriceDesc();

}