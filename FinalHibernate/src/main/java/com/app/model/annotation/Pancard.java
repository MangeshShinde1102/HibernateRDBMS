package com.app.model.annotation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "pancard")
public class Pancard {

	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
	@Column(name = "pancard_id")
	private Integer pancardId;
	@Column(name = "pancard_number")
	private String pancardNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Person person;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
