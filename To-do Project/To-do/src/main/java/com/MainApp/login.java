package com.MainApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
import com.Entity.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("Username");
		String password= req.getParameter("password");
		
		System.out.println(name+password);
		
		Connection con = ConnectionFactory.getCon();
		userDao iDao = new userDao();
		

		HttpSession s = req.getSession();
		ArrayList<User> al = iDao.getAllUserdata(con);
		ArrayList<Info> all = iDao.getAllInfo(con);
		

// Debugging Statement for ArrayList
	/*	 if (al1 != null) {
	            System.out.println("Data retrieved from database: " + al.size() + " records.");
	            s.setAttribute("alinfo", al);
	        } else {
	            System.out.println("No data retrieved from database.");
	        }
	    */
		
		 
		
		String res = iDao.loginUser(name, password,con);
		if(res.equals("exists"))
		{
			String url ="home.jsp?check="+name;
			s.setAttribute("check", name);
			s.setAttribute("all", all);
			resp.sendRedirect(url);
		}
		else
		{
			resp.sendRedirect("login.jsp");
		}
	
	}
}
