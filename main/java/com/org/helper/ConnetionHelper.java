package com.org.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnetionHelper 
{
public static Connection GetConObj()
{
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
		return con;
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return null;
	
}
}
