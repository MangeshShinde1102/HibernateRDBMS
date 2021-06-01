package com.app.hibernateUtil;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtiliyXML {
	public static SessionFactory getSessionFactory() {

		Configuration cfg = new Configuration();
		cfg.configure();
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		StandardServiceRegistry registry = builder.build();
		return cfg.buildSessionFactory(registry);
}
}
