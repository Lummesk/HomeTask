package ua.com.sourceit.subtask4;

import java.sql.*;

public class DatabaseConnection 
{ 
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost/dev?user=root&password=root";

	   public static Connection getConnection() throws SQLException, ReflectiveOperationException
	   {
		   System.out.println("Connecting to database...");
			  Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(CONNECTION_STRING);
			
		  return conn;
	   }

}
