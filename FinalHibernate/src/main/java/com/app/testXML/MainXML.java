package com.app.testXML;

import com.app.daoXML.OneToManyXML;
import com.app.daoXML.OneToOneXML;

public class MainXML {

	public static void main(String[] args) {
		OneToOneXML oneToOneXML = new OneToOneXML();
//		oneToOneXML.savePerson();
//		oneToOneXML.getPersonById();
//		oneToOneXML.showPersons();
//		oneToOneXML.updatePerson();
//		oneToOneXML.deletePersonById();
		OneToManyXML manyXML=new OneToManyXML();
		manyXML.saveCustomer();
	}
}
