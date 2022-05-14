package com;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Item {

	
	public Connection connect()
	{
		Connection con = null;

		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test123", "root", "sandaru@1S");
			 
			 //For testing
			 System.out.print("Successfully connected");
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	
		 return con;
	}
	
	
	public String insertItem(String code, String name, String desc)
	{   
		String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
			{
					 System.out.println("no conn");
	 return "Error while connecting to the database";
	 }
				// create a prepared statement
				System.out.println("awa");
				String query = "insert into items(itemID,itemCode,itemName,itemDesc)values(?, ?, ?, ?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				// binding values
				preparedStmt.setInt(1, 0);
				preparedStmt.setString(2, code);
				preparedStmt.setString(3, name);
				preparedStmt.setString(4, desc);
				 
				//execute the statement
				preparedStmt.execute();
				con.close();
				String newItems = readItems();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newItems + "\"}";
		 }
				 catch (Exception e)
		{
				 output = "{\"status\":\"error\", \"data\":\"Error while inserting the item.\"}";
				 System.err.println(e.getMessage());
		 }
				 return output;
			 } 

	
	
	
	public String readItems()
	{
		String output = "";
			try
			{
				Connection con = connect();
				if (con == null)
			{
	 return "Error while connecting to the database for reading.";
	 }
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Item Code</th>"
						+ "<th>Item Description</th>"
						+ "<th>Update</th><th>Remove</th></tr>";
				String query = "select * from items";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				// iterate through the rows in the result set
				while (rs.next())
	 {
	 String itemID = Integer.toString(rs.getInt("itemID"));
	 String itemCode = rs.getString("itemCode");
	 String itemName = rs.getString("itemName");
	 String itemDesc = rs.getString("itemDesc");
	 // Add into the html table
	 output += "<tr><td><input id='hidItemIDUpdate'name='hidItemIDUpdate'type='hidden' value='" + itemID + "'>"+ itemCode + "</td>"; 

	 	output += "<td>" + itemName + "</td>";
	 	output += "<td>" + itemDesc + "</td>";
	 	// buttons
	
	 	output += "<td><input name='btnUpdate' type='button' value='Update' "
	 			+ "class='btnUpdate btn btn-secondary' data-itemid='" + itemID + "'></td>"
	 			+ "<td><input name='btnRemove' type='button' value='Remove' "
	 			+ "class='btnRemove btn btn-danger' data-itemid='" + itemID + "'></td></tr>";
	 			 } 
				con.close();
	 	// Complete the html table
	 	output += "</table>";
	
				
			}catch (Exception e)
			
	 {
				output = "Error while reading the items.";
				System.err.println(e.getMessage());
	 }
	return output;
	}
	public String updateItem(String ID, String code, String name, String desc)
	
	 {
		
		String output = "";
	 try
	 {
		 Connection con = connect();
		 if (con == null)
	 {
	 return "Error while connecting to the database for updating."; }
		 
		 // create a prepared statement
		 int v = Integer.parseInt(ID);
		 String query = "UPDATE items SET itemCode=?,itemName=?,itemDesc=? WHERE itemID=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 	// binding values
		 preparedStmt.setString(1, code);
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, desc);
		 preparedStmt.setInt(4, Integer.parseInt(ID));
				// execute the statement
			    preparedStmt.execute();
				con.close();
				String newItems = readItems();
				 output = "{\"status\":\"success\", \"data\": \"" +
				 newItems + "\"}";
			 }
				 catch (Exception e)
		     {
				 output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
				 System.err.println(e.getMessage());
			 }
				 return output;
			 } 


	

public String deleteItem(String itemID)
{
	String output = "";
	try
	{
		Connection con = connect();
		if (con == null)
	{
 return "Error while connecting to the database for deleting.";
 }
			// create a prepared statement
			String query = "delete from items where itemID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(itemID));

			// execute the statement
			preparedStmt.execute();
			con.close();
			String newItems = readItems();
			 output = "{\"status\":\"success\", \"data\": \"" +
			 newItems + "\"}";
			 }
			 catch (Exception e)
			 {
			 output = "{\"status\":\"error\", \"data\":\"Error while updating the item.\"}";
			 System.err.println(e.getMessage());
			 }
			 return output;
			 } 

/*	
public String getData(int itemID) {

	String output = "";
	try
	{
		Connection con = connect();
		if (con == null)
	{
return "Error while connecting to the database for reading.";
}
		// Prepare the html table to be displayed
		output = "<table border='1'><tr><th>Item Code</th>"
				+ "<th>Item Name</th>"
				+ "<th>Item Description</th>"
				+ "<th>Update</th><th>Remove</th></tr>";
	
		String query = "select * from items where itemID =itemID";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);


		// iterate through the rows in the result set
		
		// iterate through the rows in the result set
		if(rs.next()) {


String itemCode = rs.getString("itemCode");
String itemName = rs.getString("itemName");
String itemDesc = rs.getString("itemDesc");
	
	output += "<tr><td>" + itemCode + "</td>";
	output += "<td>" + itemName + "</td>";
	output += "<td>" + itemDesc + "</td>";
	// buttons
	output += "<td><form method='post' action='updateitems.jsp'><a href='updateitems.jsp'><input name='btnUpdate' "
			+ " type='submit' value='Update'></a><input name='itemID1' type='hidden'value='" + itemID + "'>" + "</form></td>"
			+ "<td><form method='post' action='items.jsp'>"
			+ "<input name='btnRemove' "
			+ " type='submit' value='Remove'>"
			+ "<input name='itemID' type='hidden' "
			+ " value='" + itemID + "'>" + "</form></td></tr>";
		}
		con.close();
	// Complete the html table
	output += "</table>";
}
	catch (Exception e)
{
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
}
return output;
	
	}*/
	
}
