package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;



public class GetProductDetails  {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter start_price end_price category (BAKERY|SHOES|CLOTHES|STATIONAY) ");
			dao.getAllProductsCategoryPriceRange(sc.nextDouble(),
					sc.nextDouble(), 
					Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
