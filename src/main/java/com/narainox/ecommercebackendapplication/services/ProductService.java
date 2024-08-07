package com.narainox.ecommercebackendapplication.services;

import com.narainox.ecommercebackendapplication.utils.CommonPageRequest;
import com.narainox.ecommercebackendapplication.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto,Integer CategoryId)throws Exception;
    ProductDto updateProduct(ProductDto productDto,Integer productId)throws Exception;
    List<ProductDto> getProducts(CommonPageRequest commonPageRequest)throws Exception;
    ProductDto getProduct(Integer productId) throws Exception;
    void deleteProduct(Integer productId) throws Exception;
}
