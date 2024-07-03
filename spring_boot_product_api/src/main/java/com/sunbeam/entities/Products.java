package com.sunbeam.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="products")
public class Products extends BaseEntity {

	
	
	
	
	
   @Column(name = "product_name", length = 20,unique = true)
   private String productName;
   private double price;
   @Column(name = "available_qty")
   private int availableQty;
//   @ManyToOne 
//   @JoinColumn(name = "category_id " , nullable = false)
//   private Category productCategory;
   
   
   
   
   
   
   
   
//   public Products() {
//	// TODO Auto-generated constructor stub
//   }

//   public Products( String productName, double price, int availableQty) {
//	super();
//	this.productName = productName;
//	this.price = price;
//	this.availableQty = availableQty;
//   }

	
	
	
	
//	public String getProductName() {
//		return productName;
//	}
//	
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//	
//	public double getPrice() {
//		return price;
//	}
//	
//	public void setPrice(double price) {
//		this.price = price;
//	}
//	
//	public int getAvailableQty() {
//		return availableQty;
//	}
//	
//	public void setAvailableQty(int availableQty) {
//		this.availableQty = availableQty;
//	}
//	
//	public Category getProductCategory() {
//		return productCategory;
//	}
//
//	public void setProductCategory(Category productCategory) {
//		this.productCategory = productCategory;
//	}
//	
//	
//	
//
//	@Override
//	public String toString() {
//		return "Products "+ getId()+  "[productName=" + productName + ", price=" + price + ", availableQty=" + availableQty + "]";
//	}
	
	 
	   
   


   
   
}
