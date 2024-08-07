package com.narainox.ecommercebackendapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    private Integer cartId;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn( name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private Integer quantity;
}
