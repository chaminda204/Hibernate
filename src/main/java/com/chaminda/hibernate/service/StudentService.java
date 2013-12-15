package com.chaminda.hibernate.service;


public interface StudentService<Student> {

	Student saveOrUpdate(Student student);
}
