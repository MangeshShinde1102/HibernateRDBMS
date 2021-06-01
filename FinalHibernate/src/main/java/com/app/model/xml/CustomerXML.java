package com.app.model.xml;

import java.util.List;

public class CustomerXML {

	private int customerId;
	private String customerEmail;
	private List<AccountXML> accountXMLs;

	public List<AccountXML> getAccountXMLs() {
		return accountXMLs;
	}

	public void setAccountXMLs(List<AccountXML> accountXMLs) {
		this.accountXMLs = accountXMLs;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
