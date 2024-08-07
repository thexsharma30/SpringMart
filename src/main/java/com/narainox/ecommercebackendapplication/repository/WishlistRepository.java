package com.narainox.ecommercebackendapplication.repository;

import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.models.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist,Integer> {
    List<Wishlist> findAllByUserOrderByCreatedDateDesc(User user);


}
