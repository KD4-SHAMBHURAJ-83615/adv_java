package com.sunbeam.daos;

import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

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
	
}
