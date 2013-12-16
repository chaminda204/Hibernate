package com.chaminda.hibernate.Inheritance.jointtable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaminda.hibernate.common.AbstractTest;
import com.chaminda.hibernate.dao.EmployeeDao;
import com.chaminda.hibernate.inheritance.jointtable.PermanentEmployee;
import com.chaminda.hibernate.inheritance.jointtable.TempEmployee;

public class JointTableInheritanceMappingTest extends AbstractTest {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void shouldInjectDepandancy() {
		assertNotNull(employeeDao);
	}

	@Test
	public void shouldSucessfullySavePermanentEmployeeWithJointTableMapping() {
		// Given
		PermanentEmployee permanentEmployee = getPermanentEmployeeForTesting();

		// When
		PermanentEmployee permEmpSaved = employeeDao.save(permanentEmployee);

		// Then - Please check the database table to verify this
		assertNotNull(permEmpSaved);
		assertNotNull(permEmpSaved.getEmployeeId());
		assertEquals(permanentEmployee.getAnnualSalary(), permEmpSaved.getAnnualSalary());
	}

	private PermanentEmployee getPermanentEmployeeForTesting() {
		PermanentEmployee permEmployee = new PermanentEmployee();
		permEmployee.setEmployeeName("Perm Employee");
		permEmployee.setPermanantSpecificVal("Perm Specific Val");
		permEmployee.setAnnualSalary(100000.00);
		return permEmployee;

	}

	@Test
	public void shouldSucessfullySaveTempEmployeeWithJointTableMapping() {
		// Given
		TempEmployee tempEmployee = getTempEmployeeForTesting();

		// When
		TempEmployee tempEmpSaved = employeeDao.save(tempEmployee);

		// Then - Please check the database table to verify this
		assertNotNull(tempEmpSaved);
		assertNotNull(tempEmpSaved.getEmployeeId());
		assertEquals(tempEmpSaved.getHourlyRate(), tempEmpSaved.getHourlyRate());
	}

	private TempEmployee getTempEmployeeForTesting() {
		TempEmployee tempEmployee = new TempEmployee();
		tempEmployee.setEmployeeName("Temp Employee");
		tempEmployee.setTempSpecificVal("Temp Specific Val");
		tempEmployee.setHourlyRate(85.00);
		return tempEmployee;
	}

}
