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
@WebServlet("/editInfo")
public class launch4 extends HttpServlet{
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			
			String id  =  req.getParameter("uid");
			String name = req.getParameter("uname");
			String fees = req.getParameter("ufees");
			
			Connection con = ConnectionFactory.getCon();
			userDao iDao = new userDao();
			
			String res=iDao.editInfo(Integer.valueOf(id), name, Integer.valueOf(fees),con);
			
			HttpSession s = req.getSession();
			
			ArrayList<Info> al = iDao.getAllInfo(con);
			
			if(res.equals("updated"))
			{
				s.setAttribute("alinfo", al);
				resp.sendRedirect("home.jsp");
			}
			else 
			{
				resp.sendRedirect("home.jsp");
			}
		}
		
	
}
