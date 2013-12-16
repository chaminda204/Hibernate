package com.chaminda.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaminda.hibernate.inheritance.jointtable.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
