package com.narainox.ecommercebackendapplication.services.impl;

import com.narainox.ecommercebackendapplication.dto.CategoryDto;
import com.narainox.ecommercebackendapplication.utils.CommonPageRequest;
import com.narainox.ecommercebackendapplication.exception.RecordNotFoundException;
import com.narainox.ecommercebackendapplication.models.Category;
import com.narainox.ecommercebackendapplication.repository.CategoryRepository;
import com.narainox.ecommercebackendapplication.services.CategoryService;
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
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) throws Exception{
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) throws Exception{
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category", "CategoryId", categoryId));
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setUpdatedAt(LocalDateTime.now());
        category.setImageUrl(categoryDto.getImageUrl());
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId)throws Exception {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category", "CategoryId", categoryId));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories(CommonPageRequest commonPageRequest)throws Exception {
        Sort sort = commonPageRequest.getSortDir().equalsIgnoreCase("asc") ? Sort.by(commonPageRequest.getSortBy()).ascending() : Sort.by(commonPageRequest.getSortBy()).descending();
        Pageable pageable= PageRequest.of(commonPageRequest.getPageNo(), commonPageRequest.getPageSize(), sort);
        Page<Category> categories = categoryRepository.findAll(pageable);
        List<CategoryDto> categoryDtos=new ArrayList<>();
        for(Category category:categories)
        {
            categoryDtos.add(modelMapper.map(category,CategoryDto.class));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryByName(String categoryName)throws Exception {
        Category category = categoryRepository.findByCategoryName(categoryName).orElseThrow(()->new RecordNotFoundException("Category","CategoryName",categoryName));
        return modelMapper.map(category,CategoryDto.class);
    }
}
