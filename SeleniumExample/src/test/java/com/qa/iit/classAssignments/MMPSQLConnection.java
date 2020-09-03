package com.qa.iit.classAssignments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MMPSQLConnection {
	
	private String url = "jdbc:mysql://localhost:3306/sys";
	private String driverName = "com.mysql.cj.jdbc.Driver";
	private String SQLUserName = "root";
	private String SQLPassword = "root";
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	int rows;
	int cols;
	
	@Test
	public void SQLConnection() throws SQLException{
		
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url, SQLUserName, SQLPassword);
		}
		catch(ClassNotFoundException e){
			System.out.println("Class Not Found Exception: "+e.getMessage());
		}
		createStatement();
		getSQLData();
	}
	public void createStatement(){
		
		try{
			String sqlStatement = "Select * from walesdb.medicalrelationshipdata ";
			stmt = con.prepareStatement(sqlStatement, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			//int result = stmt.executeUpdate("Insert into walesdb.medicalrelationshipdata values (462379048, 'ria1','Aetna','PPP')");
			rs = stmt.executeQuery(sqlStatement);
			rs.last();
			rows = rs.getRow();
			ResultSetMetaData rsmd = rs.getMetaData();
			cols = rsmd.getColumnCount();
			System.out.println("Rows: "+rows+"----------"+"Columns: "+cols);
			
		}
		
		catch(SQLException e){
			System.out.println("SQLException: "+e.getMessage());
		}
		
	}
	public void getSQLData() throws SQLException{
		
		String[][] data = new String[rows][cols];
		int i = 0;
		rs.beforeFirst();
		while(rs.next()){
			for (int j=0;j<cols; j++){
				data[i][j]= rs.getString(j+1);
				System.out.println("Values:  "+data[i][j]);
			}
			i++;
		}
		
	}

}
