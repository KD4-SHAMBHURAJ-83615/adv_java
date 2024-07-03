package com.sunbeam.productsdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Products;

public interface ProductDao extends JpaRepository<Products, Long>{

}
