package com.sunbeam.daos;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public interface ProductsDao {
	String addProduct(Products product);
	Products getProductDetails(Long productId);
	List<Products> getAllProductsCategoryPriceRange(Double start,Double end, Category productCategory);
	String applyDiscount(Category category , Double Discount);
	String deleteProduct(String productName);
	String productPurchase(Long productId , int quntity);
}
