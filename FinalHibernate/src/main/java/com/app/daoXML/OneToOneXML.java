package com.app.daoXML;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernateUtil.HibernateUtilityAnnotation;
import com.app.hibernateUtil.HibernateUtiliyXML;
import com.app.model.annotation.Pancard;
import com.app.model.annotation.Person;
import com.app.model.xml.PancardXML;
import com.app.model.xml.PersonXML;

public class OneToOneXML {

	Scanner sc = new Scanner(System.in);

	public void savePerson() {

		PersonXML personXML = new PersonXML();
		System.out.println("Enter the Person Name: ");
		personXML.setPersonName(sc.next());

		PancardXML pancardXML = new PancardXML();
		System.out.println("Enter the Pancard Number");
		pancardXML.setPancardNumber(sc.next());
		pancardXML.setPersonXML(personXML);
		personXML.setPancardXML(pancardXML);
		Session session = HibernateUtiliyXML.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		session.save(personXML);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	public PersonXML getPersonById() {
		System.out.println("Enter the id");
		int id = sc.nextInt();
		Session session = HibernateUtiliyXML.getSessionFactory().openSession();
		PersonXML personXML = (PersonXML) session.get(PersonXML.class, id);
		session.close();
		return personXML;
	}

	public void updatePerson() {
		Session session = HibernateUtiliyXML.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		PersonXML personXML = getPersonById();
		PancardXML pancardXML = personXML.getPancardXML();
		System.out.println("Enter the person Name");
		personXML.setPersonName(sc.next());
		System.out.println("ENter the Pancard Number");
		pancardXML.setPancardNumber(sc.next());
		personXML.setPancardXML(pancardXML);
		session.update(personXML);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@SuppressWarnings("unchecked")
	public void showPersons() {
		List<PersonXML> personXMLs = HibernateUtiliyXML.getSessionFactory().openSession()
				.createCriteria(PersonXML.class).list();
		for (PersonXML personXML : personXMLs) {
			System.out.println("Sr. No. " + personXML.getPersonId() + " : " + personXML.getPersonName() + " "
					+ personXML.getPancardXML().getPancardNumber());
		}
	}

	public void deletePersonById() {
		PersonXML personXML = getPersonById();
		Session session = HibernateUtiliyXML.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		session.delete(personXML);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}
}
