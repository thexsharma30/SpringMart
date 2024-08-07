package com.narainox.ecommercebackendapplication.repository;

import com.narainox.ecommercebackendapplication.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryName(String categoryName);
}
