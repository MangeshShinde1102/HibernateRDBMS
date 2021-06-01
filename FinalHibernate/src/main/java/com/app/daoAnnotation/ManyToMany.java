package com.app.daoAnnotation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernateUtil.HibernateUtilityAnnotation;
import com.app.model.annotation.Customer;
import com.app.model.annotation.Product;

public class ManyToMany {
	public void save() {
		Product product1 = new Product();
		product1.setModel_no("model1");
		
		Product product2 = new Product();
		product2.setModel_no("model2");
		
		Product product3 = new Product();
		product3.setModel_no("model3");

		List<Product> products1 = new ArrayList<Product>();
		products1.add(product1);
		products1.add(product2);
		
		List<Product> products2 = new ArrayList<Product>();
		products2.add(product1);
		products2.add(product3);
		
		Customer customer1 = new Customer();
		customer1.setEmail("email1");
		customer1.setProducts(products1);
		
		Customer customer2 = new Customer();
		customer2.setEmail("email2");
		customer2.setProducts(products2);

		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.save(product1);
		session.save(product2);
		session.save(product3);
		session.save(customer1);
		session.save(customer2);

		tx.commit();
		if (tx.wasCommitted())
			System.out.println("saved");
		else
			System.out.println("failed");
	}
}
