package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.models.User;
import com.narainox.ecommercebackendapplication.models.Wishlist;
import com.narainox.ecommercebackendapplication.repository.WishlistRepository;
import com.narainox.ecommercebackendapplication.services.ProductService;
import com.narainox.ecommercebackendapplication.services.WishlistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createWishlist(Wishlist wishlist) {
        wishlist.setCreatedDate(new Date());
        wishlistRepository.save(wishlist);
    }

    @Override
    public List<ProductDto> getWishListForUser(User user) {
        List<Wishlist> all = wishlistRepository.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Wishlist wishList: all) {
            productDtos.add(modelMapper.map(wishList.getProduct(), ProductDto.class));
        }
        return productDtos;
    }
}
