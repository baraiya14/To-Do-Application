package com.MainApp;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;


import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
import com.Entity.Info;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addDetails")
public class launch1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String id  =  req.getParameter("uid");
		String name = req.getParameter("uname");
		String fees = req.getParameter("ufees");
		
		System.out.println(id+name+fees);
		
		Connection con = ConnectionFactory.getCon();
		userDao iDao = new userDao();
		
		String res=iDao.addDetails(Integer.valueOf(id), name, Integer.valueOf(fees), con);
		
		ArrayList<Info> al=iDao.getAllInfo(con);
		
		//HttpSession s = req.getSession();
		
		if(res.equals("added"))
		{
			//s.setAttribute("alinfo", al);
			resp.sendRedirect("home.jsp");
		}
		else
		{
			resp.sendRedirect("addDetails.html");
		}
	}
	
}
