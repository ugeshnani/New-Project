package com.demo.dao;

import java.sql.*;

public class fileUpload {
	  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mydb";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";


	public Object getData() throws ClassNotFoundException, SQLException {

			
			Connection con = null;
			Statement stmt = null;
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",USER,PASS); 
			
			stmt = con.createStatement(); 
			String sql= "Select * from employee";
			ResultSet rs= stmt.executeQuery(sql);
			System.out.println("printing ResultSetMetaData");
			ResultSetMetaData rsmd=rs.getMetaData();   //ResultSetMetaData 
			System.out.println("Column count"+rsmd.getColumnCount());
			System.out.println("Type of 2nd column"+rsmd.getColumnTypeName(2));
			DatabaseMetaData dbmd=con.getMetaData(); 
			
			return rs;
			

}
}
