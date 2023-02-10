package ua.com.sourceit.subtask4;

import java.sql.*;
import java.util.Map;

public class DatabaseSet 
{
	
	public static void setProduct(String name, String description, int price) throws SQLException, ReflectiveOperationException
	{ 
		Connection conn =  DatabaseConnection.getConnection();
    	PreparedStatement pstmt = null;
		try (conn)
		{pstmt = conn.prepareStatement("INSERT INTO Products (name, description, price) VALUES (?, ?, ?)");
        pstmt.setString(1, name);
        pstmt.setString(2, description);
        pstmt.setInt(3, price);
        pstmt.executeUpdate();
        System.out.println("Data has been inserted into the Products successfully.");
     } 
		catch (SQLException ex) 
		{
          ex.printStackTrace();
        } finally {
        try 
        {
           if (pstmt != null) 
           {
              pstmt.close();
           }
           if (conn != null) 
           {
              conn.close();
           }
        } 
        catch (SQLException ex) 
        {
           ex.printStackTrace();
        }
     }
            
     }
	
	
	public static void setOrder(Map<Integer, Integer> order) throws SQLException, ReflectiveOperationException
	{ 
		Connection conn =  DatabaseConnection.getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet resultSet = null;
    	int order_id = 0;
		try (conn)
		{
			pstmt = conn.prepareStatement("INSERT INTO orders (order_id, date)VALUES (?, ?)");
			
        pstmt.executeUpdate();
        resultSet = pstmt.executeQuery("SELECT LAST_INSERT_ID()");
        if (resultSet.next())
        {
        
            order_id = resultSet.getInt(1);
        }
        for (Map.Entry<Integer, Integer>  o: order.entrySet()) {
        pstmt = conn.prepareStatement("INSERT INTO Products_in_Order (order_id, product_id, quantity) VALUES (?, ?, ?)");
        pstmt.setInt(1, order_id);
        pstmt.setInt(2, o.getKey());
        pstmt.setInt(3, o.getValue());
        pstmt.executeUpdate();
		}
		}
        catch (SQLException ex) 
		{
          ex.printStackTrace();
        } finally {
        try 
        {
           if (pstmt != null) 
           {
              pstmt.close();
           }
           if (conn != null) 
           {
              conn.close();
           }
        } 
        catch (SQLException ex) 
        {
           ex.printStackTrace();
        }
     }
            
     }

}
