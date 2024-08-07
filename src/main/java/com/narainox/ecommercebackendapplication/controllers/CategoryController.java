package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import com.narainox.ecommercebackendapplication.dto.CategoryDto;
import com.narainox.ecommercebackendapplication.utils.CommonPageRequest;
import com.narainox.ecommercebackendapplication.exception.RecordNotFoundException;
import com.narainox.ecommercebackendapplication.services.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class CategoryController {
    private CategoryService categoryService;
    @PostMapping("/v1/category")
    public ResponseEntity<APIResponse> createCategoryCall(@RequestBody @Valid CategoryDto categoryDto)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CategoryDto category = categoryService.createCategory(categoryDto);
            apiResponse.setData(category);
            apiResponse.setMessage("Category Created Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/v1/category/{categoryId}")
    public ResponseEntity<APIResponse> updateCategoryCall(@RequestBody @Valid CategoryDto categoryDto,@PathVariable Integer categoryId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CategoryDto category = categoryService.updateCategory(categoryDto,categoryId);
            apiResponse.setData(category);
            apiResponse.setMessage("Category Updated Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (RecordNotFoundException recordNotFoundException)
        {
            throw recordNotFoundException;
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/v1/category/{categoryId}")
    public ResponseEntity<APIResponse> getCategoryCall(@PathVariable Integer categoryId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CategoryDto category = categoryService.getCategory(categoryId);
            apiResponse.setData(category);
            apiResponse.setMessage("Category Get Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (RecordNotFoundException recordNotFoundException)
        {
            throw recordNotFoundException;
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/category/categoryName/{categoryName}")
    public ResponseEntity<APIResponse> getCategoryByNameCall(@PathVariable String categoryName)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            CategoryDto category = categoryService.getCategoryByName(categoryName);
            apiResponse.setData(category);
            apiResponse.setMessage("Category Get Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.OK);
        }
        catch (RecordNotFoundException recordNotFoundException)
        {
            throw recordNotFoundException;
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/v1/category")
    public ResponseEntity<APIResponse> getCategoriesCall(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0") Integer pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "Id") String sortBy,
            @RequestParam(name = "sortDir",required = false,defaultValue = "asc") String sortDir
    )
    {
        APIResponse apiResponse=new APIResponse();
        CommonPageRequest commonPageRequest=new CommonPageRequest();
        commonPageRequest.setPageSize(pageSize);
        commonPageRequest.setPageNo(pageNo);
        commonPageRequest.setSortBy(sortBy);
        commonPageRequest.setSortDir(sortDir);
        try {
            List<CategoryDto> category = categoryService.getCategories(commonPageRequest);
            apiResponse.setData(category);
            apiResponse.setMessage("Category Get Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
