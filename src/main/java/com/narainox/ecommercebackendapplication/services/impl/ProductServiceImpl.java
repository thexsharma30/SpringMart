package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.utils.CommonPageRequest;
import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.exception.RecordNotFoundException;
import com.narainox.ecommercebackendapplication.models.Category;
import com.narainox.ecommercebackendapplication.models.Product;
import com.narainox.ecommercebackendapplication.repository.CategoryRepository;
import com.narainox.ecommercebackendapplication.repository.ProductRepository;
import com.narainox.ecommercebackendapplication.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto,Integer categoryId)throws Exception {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category", "CategoryId", categoryId));
        Product product = modelMapper.map(productDto, Product.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        product.setCategory(category);
        Product save = productRepository.save(product);
        return modelMapper.map(save, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Integer productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
        product.setProductName(productDto.getProductName());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setUpdatedAt(LocalDateTime.now());
        product.setDescription(productDto.getDescription());
        Product save = productRepository.save(product);
        return modelMapper.map(save, ProductDto.class);
    }

    @Override
    public List<ProductDto> getProducts(CommonPageRequest commonPageRequest) throws Exception {
        Sort sort = commonPageRequest.getSortDir().equalsIgnoreCase("asc") ? Sort.by(commonPageRequest.getSortBy()).ascending() : Sort.by(commonPageRequest.getSortBy()).descending();
        Pageable pageable= PageRequest.of(commonPageRequest.getPageNo(), commonPageRequest.getPageSize(), sort);
        Page<Product> products = productRepository.findAll(pageable);
        List<ProductDto> productDtos=new ArrayList<>();
        for(Product product:products)
        {
            productDtos.add(modelMapper.map(product, ProductDto.class));
        }
        return productDtos;
    }

    @Override
    public ProductDto getProduct(Integer productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product", "productId", productId));
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public void deleteProduct(Integer productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product", "ProductId", productId));
        productRepository.delete(product);
    }
}
