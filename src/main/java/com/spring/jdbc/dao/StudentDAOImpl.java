package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	
	@Override
	public int delete(int stdId) {

		String query = "delete from Student where id = ?";
		return this.jdbcTemplate.update(query, stdId);
	}
	
	@Override
	public Student getStudent(int stdId) {
		String query = "Select * from student where id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student std =  (Student) this.jdbcTemplate.queryForObject(query, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student std = new Student();
				std.setId(rs.getInt(1));
				std.setName(rs.getString(2));
				std.setCity(rs.getString(3));
				return std;
			}
			
		}, stdId);
		return std;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



}
