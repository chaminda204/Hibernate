package com.chaminda.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaminda.hibernate.Inheritance.tableforclass.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long>{

}
