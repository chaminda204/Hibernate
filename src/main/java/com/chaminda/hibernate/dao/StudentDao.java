package com.chaminda.hibernate.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chaminda.hibernate.mapping.domain.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{


}
