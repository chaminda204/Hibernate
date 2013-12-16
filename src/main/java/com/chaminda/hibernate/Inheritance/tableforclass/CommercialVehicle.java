package com.chaminda.hibernate.Inheritance.tableforclass;

import javax.persistence.Entity;

@Entity
public class CommercialVehicle extends Vehicle{

	private static final long serialVersionUID = -7641053238805856501L; 
	
	private Integer maxCapacity;
	
	private boolean isTranspotationRequired;

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public boolean isTranspotationRequired() {
		return isTranspotationRequired;
	}

	public void setTranspotationRequired(boolean isTranspotationRequired) {
		this.isTranspotationRequired = isTranspotationRequired;
	}
	
}
