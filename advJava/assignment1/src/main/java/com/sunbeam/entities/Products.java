package com.sunbeam.entities;

import javax.persistence.*;

@Entity

@Table(name="products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
	@Column(length = 20,unique = true)
   private Category category;
   private String productName;
   private double price;
   private int availableQty;
   
   public Products() {
	// TODO Auto-generated constructor stub
   }

   public Products(Category category, String productName, double price, int availableQty) {
	super();
	this.category = category;
	this.productName = productName;
	this.price = price;
	this.availableQty = availableQty;
   }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getAvailableQty() {
		return availableQty;
	}
	
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	
	@Override
	public String toString() {
		return "Products [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", availableQty=" + availableQty + "]";
	}
	   
	   
   


   
   
}
