package com.chaminda.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaminda.hibernate.inheritance.singletable.Person;
@Repository
public interface PersonDao extends JpaRepository<Person, Long>{

}

