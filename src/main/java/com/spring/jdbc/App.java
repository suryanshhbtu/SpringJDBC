package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);
        
        //query
        String query = "insert into student(id, name, city) values (?, ?, ?)";
        //fire
        
        int res = template.update(query, 4, "Shivam", "Pakistan");
        System.out.println(res);
        
    }
}
