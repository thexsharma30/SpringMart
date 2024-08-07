package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.dto.CartDto;
import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.User;

public interface CartService  {
    Cart addToCartDto(AddToCartDto addToCartDto, User user) throws Exception;

    CartDto getCartItems(User user);
    void deleteCartItem(Integer cartItemId, User user);
}
