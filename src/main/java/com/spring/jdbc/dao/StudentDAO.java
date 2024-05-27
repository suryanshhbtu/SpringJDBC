package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

public interface StudentDAO {
	int insert(Student std);
	int change(Student std);
	int delete(int stdId);
	Student getStudent(int stdId);

}
