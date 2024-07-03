package com.sunbeam.daos;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

public class ProductsDaoImpl implements ProductsDao  {

	@Override
	public String addProduct(Products product) {
		String msg="product not added!!";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Serializable productId = session.save(product);
			tx.commit();
			msg="product added succesfully!!!";
			
		} catch (RuntimeException e) {
			if (tx !=null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public Products getProductDetails(Long productId) {
		Products product=null;
		
		Session session =getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			product=session.get(Products.class, productId);
			
		} catch (RuntimeException e) {
			
			if(tx !=null)
				tx.rollback();
			
			throw e;
			
		}
		
		return product;
	}

	
	public List<Products> getAllProductsCategoryPriceRange(Double start,Double end, Category productCategory) {
		String jpql="select p from Products p where p.price between :start and :end and p.category=:cat ";
		
		List<Products> products = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			products= session.createQuery(jpql,Products.class).setParameter("start", start).setParameter("end", end)
					.setParameter("cat",productCategory ).getResultList();
			
			tx.commit();
					
		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			
			throw e;
		}
		
		
		
		
		return products;
	}

	@Override
	public String applyDiscount(Category category, Double discount) {
		
		String msg="applying discount failed!!!";
		String jpql="Update Products p set p.price=p.price-:disc where p.category=:cat";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			int row= session.createQuery(jpql).setParameter("cat",category)
					.setParameter("disc",discount ).executeUpdate();
			
			tx.commit();
			msg= "applied discount to products" + row;
			
		} catch (RuntimeException e) {
			
			if ( tx != null)
				tx.rollback();
			
			throw e;
		}
		
		
		
		return msg;
	}

	@Override
	public String deleteProduct(String productName) {
		String msg="deletion failed !!!";
		String jpql="select p from Products p where p.productName=:pname";
		
		
		Session session =getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Products product = session.createQuery(jpql,Products.class).setParameter("pname",productName)
					.getSingleResult();
			
			
			if(product != null) {
			
			session.delete(product);
			
			msg="deleted succesully!!";
			}
			tx.commit();
			
			
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			
			throw e;
		}	
		return msg;
	}

	@Override
	public String productPurchase(Long productId, int quntity) {
		String msg ="Product purchasing failed!!";
		
		Session session =getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Products product = session.get(Products.class, productId);
			  
				  if(product.getAvailableQty() >= quntity) {
					  product.setAvailableQty(product.getAvailableQty()-quntity);
					  msg="you product "+product.getProductName()+"quntity"+quntity;
				  }else {
					  msg="product is available";
				  }
				  
			  
			tx.commit();
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			
			throw e;
		}
		
		
		
		return null;
	}
	
}

























