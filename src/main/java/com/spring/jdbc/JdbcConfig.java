package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.cj.jdbc.Driver;
import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.dao.StudentDAOImpl;

@Configuration
public class JdbcConfig {

//	<bean class="org.springframework.jdbc.datasource.DriverManagerDataSource" name="ds">
//	 <property name="driverClassName" value=""/>
//	 <property name="url" value=""/>
//	<property name="username" value="root"/>
//	 <property name="password" value="1234"/>
//	</bean>
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource temp = new DriverManagerDataSource();
		temp.setDriverClassName("com.mysql.cj.jdbc.Driver");
		temp.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		temp.setUsername("root");
		temp.setPassword("1234");
		return temp;
	}
	
//	<bean class="org.springframework.jdbc.core.JdbcTemplate" name="jdbcTemplate">
//		<property name="dataSource">
//			<ref bean="ds"/>
//		</property>
//	</bean>
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}
//	<bean class="com.spring.jdbc.dao.StudentDAOImpl" name="studentDAO">
//		<property name="jdbcTemplate">
//			<ref bean="jdbcTemplate"/>
//		</property>
//	</bean>
	@Bean("studentDAO")
	public StudentDAO getStudentDAO() {
		StudentDAOImpl studentDAO = new StudentDAOImpl();
		studentDAO.setJdbcTemplate(getJdbcTemplate());
		return studentDAO;
	}
}
