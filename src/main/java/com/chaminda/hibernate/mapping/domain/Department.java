package com.chaminda.hibernate.mapping.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;
	
	private String drpartmentName;
	
	@OneToMany(mappedBy="academicDepartment")
	private Set<Student> students = new HashSet<Student>();

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDrpartmentName() {
		return drpartmentName;
	}

	public void setDrpartmentName(String drpartmentName) {
		this.drpartmentName = drpartmentName;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
