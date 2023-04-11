package com.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//@Repository is a Spring annotation that marks a class as a repository or data access object (DAO). 
//It is typically used to indicate that the class will handle database operations such as CRUD (Create, Read, Update, Delete) operations.
@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//create table user 
	
	public int createTable() {

		String query="CREATE TABLE IF NOT EXISTS User(id int primary key,name varchar(200),age int,city varchar(200));";
		int update=this.jdbcTemplate.update(query);
		return update;
	}
	
	//inserting user to t he database
	
	  public int insertUser(Integer id,String name,Integer age,String city) {
	  String query="insert into user(id,name,age,city) values(?,?,?,?)"; 
	  int insert=this.jdbcTemplate.update(query,new Object[]{id,name,age,city}); 
	  return insert; 
	  }
	 
	  //updating user age in the database
	  
	public int updateUser(Integer id,Integer age) {
		String query = "update user set age = ? where id = ?"; 
		int update =this.jdbcTemplate.update(query, age, id); 
		return update;	
	}
	
	//deleting user from the database
	
	public int deleteUser(String city)
	{
		String query="delete from user where city = ?";
		int del=this.jdbcTemplate.update(query,city);
		return del;
	}
	
	

}
