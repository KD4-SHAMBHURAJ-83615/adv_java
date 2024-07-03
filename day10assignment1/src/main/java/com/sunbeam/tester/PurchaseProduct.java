package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;



public class PurchaseProduct  {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter product name and quntity");
			dao.productPurchase(sc.nextLong(), sc.nextInt());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
