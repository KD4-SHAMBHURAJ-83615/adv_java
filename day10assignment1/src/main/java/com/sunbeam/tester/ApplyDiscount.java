package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;



public class ApplyDiscount  {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter product_category(BAKERY|SHOES|CLOTHES|STATIONAY)  discount_in_price");
			dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()), sc.nextDouble());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
