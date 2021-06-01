package com.app.daoAnnotation;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernateUtil.HibernateUtilityAnnotation;
import com.app.model.annotation.Pancard;
import com.app.model.annotation.Person;

public class OneToOne {

	Scanner sc = new Scanner(System.in);

	public void savePerson() {
		Person person = new Person();
		System.out.println("Enter the name");
		person.setPersonName(sc.next());

		Pancard pancard = new Pancard();
		System.out.println("Enter Pancard Number");
		pancard.setPancardNumber(sc.next());
		pancard.setPerson(person);

		person.setPancard(pancard);
		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		session.save(person);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	public Person getPersonById() {
		System.out.println("Enter the id");
		int id = sc.nextInt();
		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Person person = (Person) session.get(Person.class, id);
		session.close();
		return person;
	}

	public void updatePerson() {
		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		Person person = getPersonById();
		Pancard pancard = person.getPancard();
		System.out.println("Enter the person Name");
		person.setPersonName(sc.next());
		System.out.println("ENter the Pancard Number");
		pancard.setPancardNumber(sc.next());
		person.setPancard(pancard);
		session.update(person);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}

	@SuppressWarnings("unchecked")
	public void showPersons() {
		List<Person> persons = HibernateUtilityAnnotation.getSessionFactory().openSession().createCriteria(Person.class)
				.list();
		for (Person person : persons) {
			System.out.println("Sr. No. " + person.getPersonId() + " : " + person.getPersonName() + " "
					+ person.getPancard().getPancardNumber());
		}
	}

	public void deletePersonById() {
		Person person = getPersonById();
		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		session.delete(person);
		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}
}
