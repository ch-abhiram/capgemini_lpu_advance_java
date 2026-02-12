package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StepstoConnectDataBase {
	public static void main(String[] args) {
		//Load the driver class
		
		String url = "jdbc:postgresql://localhost:5432/school";
		String un = "postgres";
		String pwd = "root";
		try {
			Class.forName("org.postgresql.Driver");
		//To establish Connection
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			String sql = "insert into student values(102,'miller','miller@gmail.com','male')";
			String sqlU = "update student set stu_name = 'abhi' where stu_name = 'miller'";
			String sqlD = "delete from student where id = 102";
			//create statement
			Statement stmt  = connect.createStatement();
			//execute query
//			stmt.execute(sql);
//			stmt.execute(sqlU);
			stmt.execute(sqlD);
			
			connect.close();
			System.out.println("data inserted");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
