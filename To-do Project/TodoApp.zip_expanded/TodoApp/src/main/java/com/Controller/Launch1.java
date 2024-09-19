package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;
@WebServlet("/signup")
public class Launch1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		String email = req.getParameter("uemail");
		String dob = req.getParameter("udob");
		
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		
		String res=uDao.sigupUser(name, pass, email, dob, con);
		
		HttpSession s = req.getSession();
		if(res.equals("inserted"))
		{
			s.setAttribute("msg", "Account created Successfuly");
			resp.sendRedirect("login.jsp");
		}
		else
		{
			s.setAttribute("msg", "Failed");
			resp.sendRedirect("signup.jsp");
		}
	}

}
