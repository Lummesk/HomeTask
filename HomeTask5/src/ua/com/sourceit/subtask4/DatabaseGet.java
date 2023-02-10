package ua.com.sourceit.subtask4;

import java.sql.*;




public class DatabaseGet 
{
	public static void getAllOrders () throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        int currentID = 0;
        try (conn)
        {
  
            statement = conn.createStatement();

           
            resultSet = statement.executeQuery("SELECT Orders.order_id, Orders.date, Products.product_id, Products.name, Products.description, Products.price, Products_in_Order.quantity "
            		+ "FROM Orders "
            		+ "JOIN Products_in_Order ON Orders.order_id = Products_in_Order.order_id "
            		+ "JOIN Products ON Products_in_Order.product_id = Products.product_id");

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                Date date = resultSet.getDate("date");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("name");
                String description = resultSet.getString("description");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                if (orderId != currentID)
                {
                System.out.println("Замовлення №: " + orderId);
                System.out.println("Дата: " + date);
                }
                System.out.println("ID Товару: " + productId);
                System.out.println("Товар: " + productName);
                System.out.println("Опис: " + description);
                System.out.println("Ціна: " + price);
                System.out.println("Кількість: " + quantity);
                System.out.println();
                
                currentID = orderId;
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void getBySum(int sum) throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
        Statement stmt = null;
        try (conn)
        {
            stmt = conn.createStatement();
            String sql = "SELECT o.order_id, SUM(p.price * po.quantity) as order_sum " +
                         "FROM Products p " +
                         "JOIN Products_in_Order po ON po.product_id = p.product_id " +
                         "JOIN Orders o ON o.order_id = po.order_id " +
                         "GROUP BY o.order_id " +
                         "HAVING order_sum <= " + sum;
            ResultSet rs = stmt.executeQuery(sql);
            System.out.printf("Номери заказів з сумою менше %d: \n", sum);
            while (rs.next()) 
            {
                int order_id = rs.getInt("order_id");
               
                System.out.println(order_id);
            }
            System.out.println();
            rs.close();
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
	public static void getByProductId(int productId) throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
        Statement stmt = null;
        int orderId = 0;
        try (conn)
        {
            stmt = conn.createStatement();
            String query = "SELECT order_id FROM Products_in_Order WHERE product_id = ?";
            try (PreparedStatement statement = conn.prepareStatement(query))
            {
              statement.setInt(1, productId);
              try (ResultSet rs = statement.executeQuery()) 
              { 
            	  System.out.printf("Номери замовлень у яких є ID товару %d: \n", productId);
                while (rs.next()) 
                {
                  orderId = rs.getInt("order_id");
                  System.out.println(orderId);
                }
            
            System.out.println();
              
            rs.close();
            stmt.close();
            conn.close();
              }
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
        
	public static void checkWithoutProduct(int productId) throws SQLException, ReflectiveOperationException
	{
		Connection conn =  DatabaseConnection.getConnection();
		PreparedStatement stmt = null;
        int order_id = 0;
        try (conn)
        {
        	stmt = conn.prepareStatement ("SELECT order_id FROM Orders " +
                    "WHERE date = CURRENT_DATE AND order_id NOT IN " +
                    "(SELECT order_id FROM Products_in_Order WHERE product_id = ?)");
        	
               stmt.setInt(1, productId);

               ResultSet rs = stmt.executeQuery();
               System.out.printf("Номери замовлень в яких немає товару з ID %d: \n", productId);
               while (rs.next())
            {
                order_id = rs.getInt("order_id");
               
                System.out.println(order_id);
            }
            System.out.println();
            rs.close();
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


}