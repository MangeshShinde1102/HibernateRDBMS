package com.app.hibernateUtil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.app.model.annotation.College;
import com.app.model.annotation.Customer;
import com.app.model.annotation.Pancard;
import com.app.model.annotation.Person;
import com.app.model.annotation.Product;
import com.app.model.annotation.Student;

public class HibernateUtilityAnnotation {

	public static SessionFactory getSessionFactory() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatemss");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.show_sql", "true");

		Configuration cfg = new Configuration();
		cfg.setProperties(properties);
		cfg.addAnnotatedClass(Person.class);
		cfg.addAnnotatedClass(Pancard.class);
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(College.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Product.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry = builder.build();
		return cfg.buildSessionFactory(registry);
	}
}
