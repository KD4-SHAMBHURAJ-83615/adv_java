package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.daos.ProductsDao;
import com.sunbeam.daos.ProductsDaoImpl;
import com.sunbeam.entities.Category;



public class DeleteProduct  {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductsDao dao = new ProductsDaoImpl();
			System.out.println("Enter product name");
			dao.deleteProduct(sc.next());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
