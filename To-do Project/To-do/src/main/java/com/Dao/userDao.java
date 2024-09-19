package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.Entity.Info;
import com.Entity.*;

public class userDao {
	
	String result="";

	public String signUp(String name, String password, String email, Connection con)
	{
		try
		{
			String sql = "insert into userdata values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			
			int row = ps.executeUpdate();
			if(row==1)
			{
				result="added";
				
				String sql1 = "Create table "+name+"Data(note varchar(255),AddDate varchar(255),MDate varchar(10))";
				con.prepareStatement(sql1).execute();

			}
			else
			{
				result="failed";
			}
		}
			catch (Exception e) 
		    {
				result="failed";
				System.out.println(e);
			}
			finally 
			{	
				return result;
			}
	}
	
	public String loginUser(String name, String password, Connection con)
	{
		try
		{
			String sql="select * from userdata where name=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if(count==1)
			{
				result="exists";
			}
			else
			{
				result="not exists";
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			return result;
		}
			
		}
		
	public String addDetails(int id, String name, int fees, Connection con)
	{
		try
		{
			String sql = "insert into info values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, fees);
			
			int row = ps.executeUpdate();
			if(row==1)
			{
				result="added";
			}
			else
			{
				result="failed";
			}
		}
			catch (Exception e) 
		    {
				result="failed";
				System.out.println(e);
			}
			finally 
			{
				return result;
			}
	}

	public ArrayList<Info> getAllInfo(Connection con)
		{
			ArrayList<Info> all = new ArrayList<Info>();
			try
			{
				String sql = "select * from Info";
				
				Statement st = con.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next())
				{
					Info i = new Info();
					
					i.setId(rs.getInt("id"));
					i.setName(rs.getString(2));
					i.setFees(rs.getInt("fees"));
					
					all.add(i);
				}
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
			finally {
				return all;
			}
		}
		
		public ArrayList<User> getAllUserdata(Connection con)
		{
			ArrayList<User> al = new ArrayList<User>();
			try
			{
				String sql = "select * from userdata";
				
				Statement st = con.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while(rs.next())
				{
					User u = new User();
					
					u.setName(rs.getString("name"));
					u.setPassword(rs.getString("password"));
					
					al.add(u);
				}
				
			}
			catch (Exception e) {
				System.out.println(e);
			}
			finally {
				return al;
			}
		}
		
		public String editInfo(int id,String name,int fees, Connection con)
		{
			try
			{
				String sql = "UPDATE info Set name=?,fees=? Where id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				
				ps.setInt(3,id);
				ps.setString(1,name);
				ps.setInt(2,fees);
				
				int row = ps.executeUpdate();
				if(row==1)
				{
					result="updated";
				}
				else
				{
					result="failed";
				}
			}
			catch (Exception e) {
				result="failed";
				System.out.println(e);
			}
			finally {
				return result;
			}
		}
		

		public String delInfo(int id, Connection con)
		{
			try
			{
				String sql = "delete from info where id=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				
				
				int row = ps.executeUpdate();
				if(row==1)
				{
					result="deleted";
				}
				else
				{
					result="failed";
				}
			}
			catch (Exception e) {
				result="failed";
				System.out.println(e);
			}
			finally {
				return result;
			}
		}
		
	
	}

 