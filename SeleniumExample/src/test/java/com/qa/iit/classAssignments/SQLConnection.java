package com.qa.iit.classAssignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/sys";
	//private static String driverName = "com.mysql.jdbc.Driver";
	private static String driverName = "com.mysql.cj.jdbc.Driver";
	private static String userName = "root";
	private static String password = "root";
	private static Connection con;

	public static void main(String[] args) {
		
		try{
			Class.forName(driverName);
			try{
				con = DriverManager.getConnection(url, userName, password);
				Statement stmt = con.prepareStatement("Select * from walesdb.patientinfo ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				//int result = stmt.executeUpdate("insert into walesdb.patientInfo values ('Radha', 15)");
				ResultSet rs = stmt.executeQuery("Select * from walesdb.patientinfo");
				rs.last();
				int rows = rs.getRow();
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				
				System.out.println("No. of rows is : "+rows+" No of columns is : "+cols);
				
				String inputArray[][] = new String [rows][cols];
				int i = 0;
				rs.beforeFirst();
				while(rs.next()){
					for (int j=0; j<cols; j++){
						inputArray[i][j]= rs.getString(j+1);
						System.out.println("values "+ inputArray[i][j] );
					}
				    i++;	
				}
				
				
			}
			catch (SQLException e){
				System.out.println(e.getMessage());
			}
		}
		catch (ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
	
		
		
		

	}

}
