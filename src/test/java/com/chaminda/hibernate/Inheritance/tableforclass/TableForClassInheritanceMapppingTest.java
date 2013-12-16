package com.chaminda.hibernate.Inheritance.tableforclass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaminda.hibernate.common.AbstractTest;
import com.chaminda.hibernate.dao.VehicleDao;

public class TableForClassInheritanceMapppingTest extends AbstractTest {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Test
	public void shouldInjectVehicleDaoInstance(){
		assertNotNull(vehicleDao);
	}
	
	@Test
	public void shouldSaveDomasticVehicleWithTableForClassMapping(){
		//Given
		DomasticVehicle domasticVehicle = getDomasticVehicleForTesting();
		
		//When
		DomasticVehicle savedVehicle = vehicleDao.save(domasticVehicle);
		
		//Then
		assertNotNull(savedVehicle);
		assertNotNull(savedVehicle.getVehicleId());
		assertEquals(domasticVehicle.getNoOfPassengers(), savedVehicle.getNoOfPassengers());
	
		
	}
	
	private DomasticVehicle getDomasticVehicleForTesting(){
		DomasticVehicle domasticVehicle = new DomasticVehicle();
		domasticVehicle.setName("Car");
		domasticVehicle.setManufacturer("Honda");
		domasticVehicle.setNoOfPassengers(4);
		return domasticVehicle;
	
	}
	
	@Test
	public void shouldSaveCommercialVehicleWithTableForClassMapping(){
		//Given
		CommercialVehicle commercialVehicle = getCommercialForTesting();
		
		//When
		CommercialVehicle savedVehicle = vehicleDao.save(commercialVehicle);
		
		//Then
		assertNotNull(savedVehicle);
		assertNotNull(savedVehicle.getVehicleId());
		assertEquals(commercialVehicle.getMaxCapacity(), savedVehicle.getMaxCapacity());
	
		
	}
	
	private CommercialVehicle getCommercialForTesting(){
		CommercialVehicle commercialVehicle = new CommercialVehicle();
		commercialVehicle.setName("Commercial");
		commercialVehicle.setManufacturer("TopGun");
		commercialVehicle.setMaxCapacity(10100);
		return commercialVehicle;
	
	}
	
	
	
}
