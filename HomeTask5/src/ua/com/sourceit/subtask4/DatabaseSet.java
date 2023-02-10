package ua.com.sourceit.subtask4;

import java.sql.*;
import java.util.HashMap;
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
        System.out.println("Новий товар додано успішно");
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
			pstmt = conn.prepareStatement("INSERT INTO orders ()VALUES ()");
			pstmt.executeUpdate();
			System.out.println("Нове замовлення створено");
			pstmt = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			resultSet = pstmt.executeQuery();
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
			System.out.println("Дані усішно додані до нового замовлення");
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
	public static void createOrderFromToday() throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
		 Map<Integer, Integer> order = new HashMap<>();
		 PreparedStatement stmt = null;
		 try (conn)
		 {
		           stmt = conn.prepareStatement(
		              "SELECT product_id, order_id, quantity FROM Products_in_Order " +
		              "WHERE order_id IN (SELECT order_id FROM Orders WHERE date = CURRENT_DATE)"); 
		           {
		         ResultSet rs = stmt.executeQuery();
		         while (rs.next()) 
		         {
		            order.put(rs.getInt("product_id"), 1);
		         }
		         DatabaseSet.setOrder(order);
		         
              
            rs.close();
            stmt.close();
            conn.close();
               }
            }

        catch (SQLException se)
        {
            se.printStackTrace();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } finally
        {
            try 
            {
                if (stmt != null) 
                {
                    stmt.close();
                }
            } 
            catch (SQLException se2)
            {
            }
            try 
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }
        }
        
    }
	public static void deleteOrdersByProductCount(int productCount) throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
		try 
		{
			PreparedStatement statement1 = conn.prepareStatement("DELETE FROM Products_in_Order WHERE quantity = ?");
			statement1.setInt(1, productCount);

			int deletedRows1 = statement1.executeUpdate();
			
			PreparedStatement statement2 = conn.prepareStatement("DELETE FROM Orders WHERE order_id NOT IN (SELECT order_id FROM Products_in_Order)");

			int deletedRows2 = statement2.executeUpdate();
			
			System.out.println("Кількість видалених замовлень: " + (deletedRows1 + deletedRows2));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
