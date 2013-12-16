package com.chaminda.hibernate.inheritance.jointtable;

import javax.persistence.Entity;

@Entity
public class PermanentEmployee extends Employee {

	private static final long serialVersionUID = 3045449798967192670L;
	
	private Double annualSalary;
	
	private String permanantSpecificVal;

	public String getPermanantSpecificVal() {
		return permanantSpecificVal;
	}

	public void setPermanantSpecificVal(String permanantSpecificVal) {
		this.permanantSpecificVal = permanantSpecificVal;
	}

	public Double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
	}


	

}
