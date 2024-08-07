package com.narainox.ecommercebackendapplication.repository;

import com.narainox.ecommercebackendapplication.models.Category;
import com.narainox.ecommercebackendapplication.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
