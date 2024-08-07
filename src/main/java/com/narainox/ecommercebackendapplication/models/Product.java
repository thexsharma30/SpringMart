package com.narainox.ecommercebackendapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    private Integer productId;
    @Column(name = "product_Name",nullable = false)
    private String productName;
    @Column(name = "image_url",nullable = false)
    private String imageUrl;
    @Column(name = "description",nullable = false)
    private String description;

    private Double price;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(
            name = "category_id"
    )
    private Category category;

}
