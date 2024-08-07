package com.narainox.ecommercebackendapplication.dto;

import com.narainox.ecommercebackendapplication.models.Cart;
import com.narainox.ecommercebackendapplication.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDto(Product product) {
        this.product = product;
    }
    public CartItemDto(Cart cart) {
        this.id = cart.getCartId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
