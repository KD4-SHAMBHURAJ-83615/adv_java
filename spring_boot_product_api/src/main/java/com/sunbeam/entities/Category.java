package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	
	@Column(length = 50,unique = true)
	private String name;
	@Column(length = 150)
	private String description;
	
//	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL )
//	private List<Products> list =new ArrayList<>();
//	
//	public Category() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	
	
	public Category(String name, String description, List<Products> list) {
		super();
		this.name = name;
		this.description = description;
		//this.list = list;
	}





//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	
//	
//	
//	public List<Products> getList() {
//		return list;
//	}
//	public void setList(List<Products> list) {
//		this.list = list;
//	}
//	
//	/*
//	 * add helper method
//	 */
//	public void addProduct(Products product) {
//		
//		this.list.add(product);
//		
//		product.setProductCategory(this);
//		
//	}
//	
//	
//	@Override
//	public String toString() {
//		return "Category"+ getId()+" [name=" + name + ", description=" + description + "]";
//	}
	
	
}
