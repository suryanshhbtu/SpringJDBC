package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entity.Student;

public interface StudentDAO {
	int insert(Student std);
	int change(Student std);
	int delete(int stdId);
	Student getStudent(int stdId);
	List<Student> getAllStudent();

}
