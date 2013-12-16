package com.chaminda.hibernate.Inheritance.tableforclass;

import javax.persistence.Entity;

@Entity
public class DomasticVehicle extends Vehicle {

	private static final long serialVersionUID = -1371551967021075726L;
	
	private Integer noOfPassengers;

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

}
