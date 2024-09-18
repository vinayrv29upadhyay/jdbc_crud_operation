package com.ibm.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayStudentController {
	
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
			
			String DisplayStudentQuery= "select * from student";
			ResultSet set = statement.executeQuery(DisplayStudentQuery);
			while(set.next()) {
				int id= set.getInt("id");
				String name=set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");
				Object dob = set.getObject("dob");
				
				System.out.println("id is"+id);
				System.out.println("name is"+name);
				System.out.println(" email is"+email);
				System.out.println("phone is"+phone);
				System.out.println("dob is "+dob);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
}
		