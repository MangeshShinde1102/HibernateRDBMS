package com.app.daoAnnotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.hibernateUtil.HibernateUtilityAnnotation;
import com.app.model.annotation.College;
import com.app.model.annotation.Student;

public class OneToMany {
	Scanner sc = new Scanner(System.in);

	public void saveStudent() {
		College college = new College();
		System.out.println("Enter the COllege Name: ");
		college.setCollegeName(sc.next());

		Student student1 = new Student();
		System.out.println("Enter the student name: ");
		student1.setStudentName(sc.next());
		student1.setCollege(college);
		Student student2 = new Student();
		System.out.println("Enter the student name: ");
		student2.setStudentName(sc.next());
		student2.setCollege(college);

		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);

		college.setStudents(students);

		Session session = HibernateUtilityAnnotation.getSessionFactory().openSession();
		Transaction ts = session.beginTransaction();
		session.save(college);

		ts.commit();
		if (ts.wasCommitted()) {
			System.out.println("Success");
		} else {
			System.out.println("Failed");
		}
	}
}
