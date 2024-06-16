package com.sunbeam.daos;

import com.sunbeam.entities.Products;

public interface ProductsDao {
	String addProduct(Products product);
	Products getProductDetails(Long productId);

}
