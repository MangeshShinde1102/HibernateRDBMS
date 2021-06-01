package com.app.testAnnotaion;

import com.app.daoAnnotation.ManyToMany;
import com.app.daoAnnotation.OneToMany;
import com.app.daoAnnotation.OneToOne;

public class MainAnnotation {
	public static void main(String[] args) {
//		OneToOne oneToOne = new OneToOne();
//		oneToOne.savePerson();
//		oneToOne.getPersonById();
//		oneToOne.showPersons();
//		oneToOne.updatePerson();
//		oneToOne.deletePersonById();

//		OneToMany oneToMany = new OneToMany();
//		oneToMany.saveStudent();
		ManyToMany manyToMany = new ManyToMany();
		manyToMany.save();
	}
}
