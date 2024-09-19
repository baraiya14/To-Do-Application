package com.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;
import com.Entity.UserData;
@WebServlet("/login")
public class Launch2 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		
		String res=uDao.loginUser(name, pass, con);
		
		ArrayList<UserData> al=uDao.getNotes(name, con);
		
		HttpSession s = req.getSession();
		if(res.equals("exists"))
		{
			s.setAttribute("notes", al);
			s.setAttribute("check", name);
			resp.sendRedirect("home.jsp");
		}
		else
		{
			s.setAttribute("msg", "Failed");
			resp.sendRedirect("login.jsp");
		}
	}

}
