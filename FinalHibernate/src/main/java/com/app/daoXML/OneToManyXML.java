package com.app.daoXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernateUtil.HibernateUtiliyXML;
import com.app.model.xml.AccountXML;
import com.app.model.xml.CustomerXML;

public class OneToManyXML {
	Scanner sc = new Scanner(System.in);

	public void saveCustomer() {
		Session session = HibernateUtiliyXML.getSessionFactory().openSession();
		CustomerXML customerXML = new CustomerXML();
		System.out.println("Enter customer Email: ");
		customerXML.setCustomerEmail(sc.next());

		AccountXML accountXML1 = new AccountXML();
		System.out.println("Enter the account number");
		accountXML1.setAccountNumber(sc.next());
//		accountXML1.setCustomerXML(customerXML);

		AccountXML accountXML2 = new AccountXML();
		System.out.println("Enter the account number");
		accountXML2.setAccountNumber(sc.next());
//		accountXML2.setCustomerXML(customerXML);

		List<AccountXML> accountXMLs = new ArrayList<AccountXML>();
		accountXMLs.add(accountXML1);
		accountXMLs.add(accountXML2);

		customerXML.setAccountXMLs(accountXMLs);
		Transaction ts = session.beginTransaction();
		session.save(customerXML);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("success");
		} else {
			System.out.println("Failed");
		}
	}
}
