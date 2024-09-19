package com.ConnectionFactory;

import java.sql.Connection;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ConnectionFactory {
	
	public static Connection con;
	
	public static Connection getCon()
	{
		try
		{
			MysqlDataSource ds =new MysqlDataSource();
			ds.setUrl("jdbc:mysql://localhost:3306/app");
			ds.setUser("root");
			ds.setPassword("");
			
			con=ds.getConnection();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			return con;
		}
	}

}
