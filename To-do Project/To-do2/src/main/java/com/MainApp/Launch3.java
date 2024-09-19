package com.MainApp;

import java.io.IOException;
import java.sql.Connection;


import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class Launch3 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession s = req.getSession();
		s.removeAttribute("check");
		s.removeAttribute("msg");
		resp.sendRedirect("login.jsp");
		
	}

}
