package com.app.model.xml;

public class PersonXML {

	private Integer personId;
	private String personName;
	private PancardXML pancardXML;

	public PancardXML getPancardXML() {
		return pancardXML;
	}

	public void setPancardXML(PancardXML pancardXML) {
		this.pancardXML = pancardXML;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
