package ua.com.sourceit.subtask4;

import java.sql.*;

public class CreateTable
{
	public static void createTable() throws SQLException, ReflectiveOperationException 
	{
		Connection conn =  DatabaseConnection.getConnection();
		Statement stmt = null;
	try(conn)
	{

        System.out.println("Creating table in given database");
        stmt = conn.createStatement();
        String sql = "CREATE TABLE Products(product_id INT PRIMARY KEY AUTO_INCREMENT UNIQUE, name VARCHAR(100) not NULL UNIQUE, description VARCHAR(255), price INT)"; 
        stmt.executeUpdate(sql);
        
        sql = "CREATE TABLE Orders (order_id INT PRIMARY KEY AUTO_INCREMENT UNIQUE, date DATE DEFAULT (CURRENT_DATE)"; 
        stmt.executeUpdate(sql);
        
        sql = "CREATE TABLE Products_in_Order (id INT INT PRIMARY KEY AUTO_INCREMENT UNIQUE, product_id INT not NULL, order_id INT not NULL, quantity INT NOT NULL, FOREIGN KEY (product_id) REFERENCES products(product_id),FOREIGN KEY (order_id) REFERENCES order(order_id) )"; 
        stmt.executeUpdate(sql);
        
        

        stmt.close();
        conn.close();
     } 
	catch (SQLException se)
	{
        se.printStackTrace();
     } 
	catch (Exception e) 
	{
        e.printStackTrace();
     } 
	finally 
	{
        try 
        {
           if (stmt != null)
              stmt.close();
        } 
        catch (SQLException se2)
        {
        }
        try 
        {
           if (conn != null)
              conn.close();
        }
        catch (SQLException se)
        {
           se.printStackTrace();
        }
     }
	}
}
