package com.tap.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static Connection con=null;
private static String url="jdbc:mysql://localhost:3306/student_management_system";
private static String username="root";
private static String password="rootlqs123";
public static Connection getConnection()
{
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,username,password);
}
catch(Exception e)
{
	e.printStackTrace();
}
return con;
}
}
