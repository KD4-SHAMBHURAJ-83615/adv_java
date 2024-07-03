package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Products;

public interface ProductService  {
	
	List<Products> getAllProducts();
	ApiResponse addNewProduct(Products product);
	Products getProductDetails(Long productId);
	ApiResponse updateProductById(Long productId,Products product);

}
