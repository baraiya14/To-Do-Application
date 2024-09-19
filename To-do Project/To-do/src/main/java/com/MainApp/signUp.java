package com.MainApp;

import java.io.IOException;
import java.security.Provider.Service;
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
@WebServlet("/signUp")
public class signUp extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String name = req.getParameter("uname");
		String password = req.getParameter("upass");
		String email = req.getParameter("umail");

		Connection con =ConnectionFactory.getCon();
		userDao udao = new userDao();
		 
		HttpSession s = req.getSession();
		
		
		String res=udao.signUp( name, password, email,con);
		if(res.equals("added"))
		{
			s.setAttribute("msg","Account Created Successfully");
			resp.sendRedirect("login.jsp");
		}
		else
		{
			s.setAttribute("msg","Failed");
			resp.sendRedirect("signUp.html");
		}
	}
	}

