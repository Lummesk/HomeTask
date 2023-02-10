package ua.com.sourceit.subtask4;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


public class SubTask4 
{
	
	public static void main(String[] args) throws SQLException, ReflectiveOperationException 
	{
		
//		CreateTable.createTable();
//		DatabaseSet.setProduct("Ковбаса", "Свіжа та смачна", 5);
//		DatabaseSet.setProduct("Хліб", "Щойно з печі", 2);
//		DatabaseSet.setProduct("Молоко", "3% жирів, незбиране", 3);
//		Map<Integer, Integer> order1 = new HashMap<>(); // key = product, value = quantity
//        order1.put(1, 3); 
//        order1.put(3, 2);
//        DatabaseSet.setOrder(order1);
//        Map<Integer, Integer> order2 = new HashMap<>();
//        order2.put(2, 1);
//        order2.put(2, 3);
//        DatabaseSet.setOrder(order2);
		DatabaseGet.getAllOrders();
		DatabaseGet.getBySum(200);
	}

}
