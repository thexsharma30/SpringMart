package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.models.Wishlist;
import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import com.narainox.ecommercebackendapplication.security.JwtTokenHelper;
import com.narainox.ecommercebackendapplication.services.UserService;
import com.narainox.ecommercebackendapplication.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @GetMapping("/h")
    public String hi()
    {
        return "Hii";
    }

    @PostMapping("/add/{token}")
    public ResponseEntity<APIResponse> addToWishWishlist(
            @RequestBody Product product,
            @PathVariable String token
            )
    {
        String username = jwtTokenHelper.getUsernameFromToken(token);
        User user = userService.getUser(username);
        Wishlist wishlist=new Wishlist(user,product);

        wishlistService.createWishlist(wishlist);

        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage("Added to wishlist");

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishList(@PathVariable("token") String token) {

        // find the user
        String username = jwtTokenHelper.getUsernameFromToken(token);
        User user = userService.getUser(username);

        List<ProductDto> productDtos = wishlistService.getWishListForUser(user);

        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }
}
