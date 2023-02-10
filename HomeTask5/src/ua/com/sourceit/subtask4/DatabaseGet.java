package ua.com.sourceit.subtask4;

import java.sql.*;




public class DatabaseGet 
{
	public static void getOrders () throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
		Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Orders");
            
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
       
        while (resultSet.next()) 
        {
            int orderId = resultSet.getInt("order_id");
            int orderSum = resultSet.getInt("order_sum");
            String orderDate = resultSet.getString("order_date");
            
            System.out.println("Order ID: " + orderId + ", Order sum: " + orderSum + ", Order date: " + orderDate);
        }
        try 
        {
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
	}

}
