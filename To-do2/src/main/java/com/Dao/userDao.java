package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

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
	
	public String addNote(String name, String note, Connection con) {
		try {
			String sql = "insert into "+name+"Data values(?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			
			String date=LocalDate.now().toString();
			ps.setString(1, note);
			ps.setString(2, date);
			ps.setString(3, "not updated");
			
			
			int row = ps.executeUpdate();
			if (row == 1) {
				result = "inserted";
				
				
			} else {
				result = "failed";
			}

		} catch (Exception e) {
			result = "failed";
			System.out.println(e);
		} finally {
			return result;
		}
	}

	
	public ArrayList<UserData> getNotes(String name, Connection con)
	{
		ArrayList<UserData> al = new ArrayList<UserData>();
		try
		{
			String sql = "select * from "+name+"Data";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				UserData u = new UserData();
				u.setNote(rs.getString(1));
				u.setAddDate(rs.getString(2));
				u.setmDate(rs.getString(3));
				
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
	
	
	public void deleteNote(String note, String name, Connection con)
	{
		try
		{
			String sql = "delete from "+name+"Data where note=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, note);
			ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
	
	

 