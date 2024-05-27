package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDAO;
import com.spring.jdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        StudentDAO studentDAO = context.getBean("studentDAO", StudentDAO.class);
        Student std = new Student(6, "Shivam", "Meerut");
        int res = studentDAO.delete(4);
        System.out.println("Data Changed in "+res+" rows.");
        
    }
}
