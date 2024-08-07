package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.dto.AddToCartDto;
import com.narainox.ecommercebackendapplication.dto.CartDto;
import com.narainox.ecommercebackendapplication.dto.CartItemDto;
import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.exception.RecordNotFoundException;
import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.repository.CartRepository;
import com.narainox.ecommercebackendapplication.services.CartService;
import com.narainox.ecommercebackendapplication.services.ProductService;
import org.antlr.v4.runtime.RecognitionException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;

    @Override
    public Cart addToCartDto(AddToCartDto addToCartDto, User user) throws Exception{
        ProductDto product = productService.getProduct(addToCartDto.getProductId());
        Cart cart=new Cart();
        cart.setCreatedDate(new Date());
        cart.setProduct(modelMapper.map(product, Product.class));
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public CartDto getCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart: cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);
        return  cartDto;
    }

    public void deleteCartItem(Integer cartItemId, User user) {
        // the item id belongs to user

        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if (optionalCart.isEmpty()) {
            throw new RecordNotFoundException("Cart","cartId",cartItemId);
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw  new RecordNotFoundException("Cart","cartId",cartItemId);
        }

        cartRepository.delete(cart);


    }
}
