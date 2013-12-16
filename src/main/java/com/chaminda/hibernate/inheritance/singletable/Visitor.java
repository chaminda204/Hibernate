package com.chaminda.hibernate.inheritance.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Visitor")
public class Visitor extends Person {

	private static final long serialVersionUID = -3091564918537896441L;

	private String visitorID;

	private String purposeOfVisit;

	public String getVisitorID() {
		return visitorID;
	}

	public void setVisitorID(String visitorID) {
		this.visitorID = visitorID;
	}

	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

}
