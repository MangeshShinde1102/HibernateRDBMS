package com.app.model.xml;

public class PancardXML {

	private Integer pancardId;
	private String pancardNumber;
	private PersonXML personXML;

	public PersonXML getPersonXML() {
		return personXML;
	}

	public void setPersonXML(PersonXML personXML) {
		this.personXML = personXML;
	}

	public Integer getPancardId() {
		return pancardId;
	}

	public void setPancardId(Integer pancardId) {
		this.pancardId = pancardId;
	}

	public String getPancardNumber() {
		return pancardNumber;
	}

	public void setPancardNumber(String pancardNumber) {
		this.pancardNumber = pancardNumber;
	}

}
