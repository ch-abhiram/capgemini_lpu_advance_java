package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpCRUD {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/office";
		String un = "postgres";
		String pwd = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			Statement smt = connect.createStatement();
			
			String sqlCreate = "insert into employee values(101,'hari',2000000),(102,'ravi',12000000),(103,'sammy',1000000)";
//			smt.execute(sqlCreate);
			
			String sqlUpdate = "update employee set name = 'abhi' where name = 'hari'";
			String sqlDelete = "delete from employee where id = 103";
//			smt.execute(sqlUpdate);
//			smt.execute(sqlDelete);
			String sql = "select * from employee";
			
			ResultSet res = smt.executeQuery(sql);
			while(res.next()) {
				System.out.println();
			}
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
