package com.chaminda.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.chaminda.hibernate.dao.StudentDao;
import com.chaminda.hibernate.mapping.domain.Student;

@Component("studentService")
public class StudentServiceImpl implements StudentService<Student>{

	@Autowired
	StudentDao studentDao ;
	
	@Override
	public Student saveOrUpdate(Student student) {
		Student saved = studentDao.save(student);
		return saved;
	}

}
