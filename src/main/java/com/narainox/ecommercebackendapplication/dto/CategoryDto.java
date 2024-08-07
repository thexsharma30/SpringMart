package com.narainox.ecommercebackendapplication.dto;

import com.narainox.ecommercebackendapplication.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {

    private Integer categoryId;
    @NotBlank(message = "categoryName required parameter")
    private String categoryName;
    @NotBlank(message = "description required parameter")
    private String description;
    @NotBlank(message = "imageUrl required parameter")
    private String imageUrl;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
