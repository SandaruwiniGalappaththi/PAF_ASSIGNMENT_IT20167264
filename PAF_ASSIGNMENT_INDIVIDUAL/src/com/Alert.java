package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Alert {
			//A common method to connect to the DB
			private Connection connect()
					 {
							Connection con = null;
					 try
					 {
						 	Class.forName("com.mysql.cj.jdbc.Driver");
		
						 	//database connection
						 	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powercut", "root", "sandaru@1S");
					 }
					 catch (Exception e){	
						 	e.printStackTrace();}
					    	return con;
					 }
	
	
	

	public String checkVerification(String accountNo, String email) {
		String output = "",mail="",acc="";
		Boolean accountOk = false,mailOk = false;
		
		 try
		 {
			 	Connection con = connect();
			 	if (con == null)
		 {
			 		return "error while connection to database"; 
			 		}
			 	
			 	 String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  
			        //Compile regular expression to get the pattern  
			        Pattern pattern = Pattern.compile(regex);  
			        Matcher matcher = pattern.matcher(email);  
			        //if email format is incorrect 
			        if(matcher.matches()== false) {
			        	output =  "<html><head>"
	                            + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
	                            + "</head><body>"
	                            + "<div class='card'><h4 class='text-center'style='color:red;'>E-mail address is not in correct format</h4></div>"
	                            + "</body></html>";
				 		return output;
			        }
			 	
			 // TODO Auto-generated method stub
				String query = "select * from consumerinfo where accountNo='" + accountNo + "'";
		 		Statement stmt = con.createStatement();
		 		ResultSet rs = stmt.executeQuery(query);
		 		// iterate through the rows in the result set
		 			while (rs.next())
		{
		 	 acc = rs.getString("accountNo");//set account Number
		 	 mail = rs.getString("email");//set email

		 	if(acc.equals(accountNo)) {//if account number is valid one
		 		accountOk = true;
		 		
		 	}
		 	
		 	if(mail.equals(email)) {//if email address matches with account number
		 		mailOk = true;
		 		
		 	}
		 	
		 	if(mailOk== true && accountOk ==true) {//mail and account matched set power cut alert
		 		output =  "<html><head>"
                        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
                        + "</head><body>"
                        + "<div class='card'><h4 class='text-center'style='color:green;'>Alert set successfully</h4></div>"
                        + "</body></html>";
		 	// create a prepared statement
				 String query1 = "UPDATE consumerinfo SET alertSet=? WHERE accountNo=?";//update alertSet column in consumerinfo table
				 PreparedStatement preparedStmt = con.prepareStatement(query1);
				 // binding values
				 preparedStmt.setBoolean(1, mailOk);
				 preparedStmt.setString(2, acc);
				 // execute the statement
				 preparedStmt.execute();
				 con.close();
		 		
		 		return output;
				
			}else if(mailOk == false) {//if email not match with account number
				output = "<html><head>"
                        + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
                        + "</head><body>"
                        + "<div class='card'><h4 class='text-center'style='color:red;'>E-mail address mismatch</h4></div>"
                        + "</body></html>";
				return output;
				
			} 
		}	
		 
		 			
		 if(accountOk == false) {//if account number is invalid
			   output = "<html><head>"
                       + "<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC' crossorigin='anonymous'>"
                       + "</head><body>"
                       + "<div class='card'><h4 class='text-center'style='color:red;'>Account number mismatch</h4></div>"
                       + "</body></html>";
			   return output;
		}
		 			
		 			
	}catch(Exception e) {
		
		return " ";
	}
	return "ERROR";
}
	
	
		
	
	
	
}
