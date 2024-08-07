package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.payloads.APIResponse;
import com.narainox.ecommercebackendapplication.utils.CommonPageRequest;
import com.narainox.ecommercebackendapplication.dto.ProductDto;
import com.narainox.ecommercebackendapplication.exception.RecordNotFoundException;
import com.narainox.ecommercebackendapplication.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Validated
public class ProductController {
    private ProductService productService;
    @PostMapping("/v1/category/{categoryId}/product")
    public ResponseEntity<APIResponse> createProductCall(@RequestBody @Valid ProductDto productDto,@PathVariable Integer categoryId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ProductDto product = productService.createProduct(productDto, categoryId);
            apiResponse.setData(product);
            apiResponse.setMessage("Product Created Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.CREATED);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/v1/product/{productId}")
    public ResponseEntity<APIResponse> updateProductCall(@RequestBody @Valid ProductDto productDto,@PathVariable Integer productId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            ProductDto product = productService.updateProduct(productDto, productId);
            apiResponse.setData(product);
            apiResponse.setMessage("Product Updated Successfully.");
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

    @DeleteMapping("/v1/product/{productId}")
    public ResponseEntity<APIResponse> deleteProductCall(@PathVariable Integer productId)
    {
        APIResponse apiResponse=new APIResponse();
        try {
            productService.deleteProduct(productId);
            apiResponse.setMessage("Product Deleted Successfully.");
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


    @GetMapping("/v1/product")
    public ResponseEntity<APIResponse> getProductsCall(
            @RequestParam(name = "pageNo",required = false,defaultValue = "0") Integer pageNo,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(name = "sortBy",required = false,defaultValue = "productId") String sortBy,
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
            List<ProductDto> products = productService.getProducts(commonPageRequest);
            apiResponse.setData(products);
            apiResponse.setMessage("Products Get Successfully.");
            return new ResponseEntity<>(apiResponse,HttpStatus.FOUND);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
