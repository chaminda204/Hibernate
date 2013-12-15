package com.chaminda.hibernate.mapping.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private Integer postCode;

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPostCode() {
		return postCode;
	}

	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	

}
