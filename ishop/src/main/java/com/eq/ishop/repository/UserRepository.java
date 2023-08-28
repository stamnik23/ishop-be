package com.eq.ishop.repository;

import com.eq.ishop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
    Optional<User> findByUsername(String username);
}