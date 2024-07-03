package com.sunbeam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Products;
import com.sunbeam.productsdao.ProductDao;



@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productsDao;
	
	
	@Override
	public List<Products> getAllProducts() {
		
		return productsDao.findAll();
	}


	@Override
	public ApiResponse addNewProduct(Products product) {
		
		Products persistentProduct= productsDao.save(product);
		if(persistentProduct !=null) {
			
			return new ApiResponse("product added succesfully") ;
		}
		return new ApiResponse("product not added succesfully!!") ;
		
	}


	@Override
	public Products getProductDetails(Long productId) {
		
		return productsDao.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Category ID!!!!"));
	}
	
	
public ApiResponse updateProductById(Long productId,Products product) {
		
		String msg= "product not updated!!!";
		
		if(productsDao.existsById(productId)) {
			productsDao.save(product);
			msg="update succesfully !!";
		}
		return new ApiResponse(msg);
		
	}
	

}
