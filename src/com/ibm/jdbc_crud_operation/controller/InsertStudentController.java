package com.ibm.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudentController {
	
	public static void main(String[] args) {
		Connection connection =null;
		
		try {
			// Step 1 :- Load/Register Driver
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2 :- Create Connection 
			
			String url = "jdbc:mysql://localhost:3306/jdbc-e3";
			String username = "root";
			String pass = "root"; 
			
			 connection =DriverManager.getConnection(url, username, pass);
			
			System.out.println(connection);
			//step 3 create statement
			Statement statement =connection.createStatement();
			
			//step 4 execute query
			String insertStudentQuery = "insert into student (id, name, email,dob,phone) values(421,'vinay','vinay123@gmail.com','20-09-2004',9856056789)";
					statement.execute(insertStudentQuery);
					
			System.out.println("Data Stored");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} 
			catch (SQLException e) 
			{
			
				e.printStackTrace();
			}
		}
		
	}

}
