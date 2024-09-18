package com.ibm.jdbc_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudentcontroller {
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
			//execute query
			String deleteStudentQuery= "delete from student where id=123";
					int a = statement.executeUpdate(deleteStudentQuery);
					if(a!=0) {
						System.out.println("Data deleted");
					}else {
						System.out.println("given id is not found");
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


