package com.sunbeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Products;
import com.sunbeam.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController  {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Products> listAllProducts(){
		return productService.getAllProducts();
	}
	
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Products newProduct){
		try {
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(productService.addNewProduct(newProduct));
					
			
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/{prodId}")
	public ResponseEntity<?> getProductDetails(@PathVariable Long prodId){
		
		try {
			return ResponseEntity.ok(productService.getProductDetails(prodId));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		
		}
	}
	
	
	@PutMapping("/{prodId}")
	public ResponseEntity<?> getUpdateDetails(@PathVariable Long prodId,@RequestBody Products product){
		
		try {
			return ResponseEntity.ok(productService.updateProductById(prodId, product));
			
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		
		}
	}
	
	
	

}
