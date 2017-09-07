package com.arif;
import java.sql.*;
public class Driver {
	//uploaded in github
	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost/hms";
		String user = "root";
		String pass = "password";
		
		try{
			//1. Get Connection to Database 
			Connection con = DriverManager.getConnection(URL, user, pass);
			
			//2. SQL Statement  
			Statement statement = con.createStatement();
			
			//3. Executing SQL Query and getting into result set.
			ResultSet res = statement.executeQuery("SELECT * FROM Booking");
			
			//4. Processing results 
			while(res.next()){
				System.out.println(res.getString("checkin") + " " + res.getString("checkout") + " " + res.getString("num_of_guests"));
			}
			
		}
		catch(Exception e){
			e.getMessage();
		}


	}

}
