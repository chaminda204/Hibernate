package com.chaminda.hibernate.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.chaminda.hibernate.mapping.domain.Address;
import com.chaminda.hibernate.mapping.domain.Department;
import com.chaminda.hibernate.mapping.domain.Student;
import com.chaminda.hibernate.mapping.domain.Subject;
import com.chaminda.hibernate.mapping.domain.University;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springBeans/applicationContext.xml" })
public class StudentServiceTest {

	@Autowired
	StudentService<Student> studentService;

	@Test
	public void shouldInitialiseSucessfully() {
		Assert.assertNotNull(studentService);
	}

	@Test
	public void shouldSucessfullySaveGivenValidObject() {
		// Given
		Student student = getStudentForTesting();

		// When
		Student savedStudent = studentService.saveOrUpdate(student);

		// Then
		assertNotNull(savedStudent);
		assertNotNull(savedStudent.getStudentId());
		assertEquals(student.getName(), savedStudent.getName());
	}

	private Student getStudentForTesting() {
		Student student = new Student();
		student.setName("Chaminda");
		student.setEmail("chaminda@email.com");
		return student;
	}

	@Test
	public void shouldSucessfullySaveEmbededAddress() {
		// Given
		Student student = getStudentForTesting();
		Address address = new Address();
		address.setStreetAddress("3 Street address");
		address.setPostCode(6155);
		student.setAddress(address);

		// When
		Student savedStudent = studentService.saveOrUpdate(student);

		// Then
		assertNotNull(savedStudent.getAddress());
	}

	@Test
	public void shouldSucessfullySaveOneToOneRelationship() {
		// Given
		Student student = getStudentForTesting();
		University university = new University();
		university.setUniversityName("Brunel");
		student.setUniversity(university);

		// When
		Student savedStudent = studentService.saveOrUpdate(student);

		// Then
		assertNotNull(savedStudent.getUniversity());
		assertEquals(student.getUniversity().getUniversityName(), savedStudent.getUniversity().getUniversityName());
	}

	@Test
	public void shouldSucessfullySaveManyToManyRelationship() {
		// Given
		Student student = getStudentForTesting();
		Subject maths = new Subject();
		maths.setSubjectName("Maths");
		student.getSubjects().add(maths);

		Subject english = new Subject();
		english.setSubjectName("English");
		student.getSubjects().add(english);

		// When
		Student savedStudent = studentService.saveOrUpdate(student);

		// Then
		assertTrue(!savedStudent.getSubjects().isEmpty());
		assertEquals(student.getSubjects().size(), savedStudent.getSubjects().size());
	}

	@Test
	public void shouldSucessfullySaveOneToManyRelationship() {
		// Given
		Student student = getStudentForTesting();
		Department department = new Department();
		department.setDrpartmentName("Computing");
		student.setAcademicDepartment(department);

		// When
		Student savedStudent = studentService.saveOrUpdate(student);

		// Then
		assertNotNull(savedStudent.getAcademicDepartment());
		assertEquals(student.getAcademicDepartment().getDrpartmentName(), savedStudent.getAcademicDepartment()
				.getDrpartmentName());
		assertNotNull(student.getAcademicDepartment().getDepartmentId());
	}
}
