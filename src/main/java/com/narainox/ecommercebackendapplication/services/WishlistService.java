package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.models.Wishlist;

import java.util.List;

public interface WishlistService {

    void createWishlist(Wishlist wishlist);

    List<ProductDto> getWishListForUser(User user);
}
