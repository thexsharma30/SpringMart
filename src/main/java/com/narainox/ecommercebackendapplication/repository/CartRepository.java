package com.narainox.ecommercebackendapplication.repository;

import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);

}

