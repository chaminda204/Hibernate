package com.chaminda.hibernate.inheritance.jointtable;

import javax.persistence.Entity;

@Entity
public class TempEmployee extends Employee {


	private static final long serialVersionUID = 7512015141817862569L;
	
	private Double hourlyRate;
	
	private String tempSpecificVal;

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(Double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getTempSpecificVal() {
		return tempSpecificVal;
	}

	public void setTempSpecificVal(String tempSpecificVal) {
		this.tempSpecificVal = tempSpecificVal;
	}
	
	
	

}
