package com.narainox.ecommercebackendapplication.dto;

import com.narainox.ecommercebackendapplication.models.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {

    private Integer productId;
    @NotBlank(message = "productName required parameter")
    private String productName;
    @NotBlank(message = "description required parameter")
    private String description;
    @NotBlank(message = "imageUrl required parameter")
    private String imageUrl;

    private Double price;
    private CategoryDto category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
