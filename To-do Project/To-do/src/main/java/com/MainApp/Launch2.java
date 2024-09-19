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
@WebServlet("/Dashboard")
public class Launch2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Connection con = ConnectionFactory.getCon();
		userDao iDao = new userDao();
		
		ArrayList<Info> al = iDao.getAllInfo(con);
		
		//HttpSession s = req.getSession();
		
		//s.setAttribute("alinfo", al);
		resp.sendRedirect("home.jsp");
		
	}

}








