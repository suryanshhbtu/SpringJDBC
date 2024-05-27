package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entity.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;


	@Override
	public int insert(Student std) {
		String query = "insert into student(id, name, city) values (?, ?, ?)";
		return this.jdbcTemplate.update(query, std.getId(), std.getName(), std.getCity());
	}

	@Override
	public int change(Student std) {
		String query = "Update Student set name = ?, city = ? where id = ?";
		return this.jdbcTemplate.update(query, std.getName(), std.getCity(), std.getId());
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
