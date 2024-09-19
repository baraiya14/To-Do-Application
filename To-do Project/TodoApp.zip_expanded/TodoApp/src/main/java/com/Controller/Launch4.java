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
@WebServlet("/addnote")
public class Launch4 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String note = req.getParameter("note");
		String name = req.getParameter("uname");
		
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		
		uDao.addNote(name, note, con);
		
		
		ArrayList<UserData> al = uDao.getNotes(name, con);
		HttpSession s = req.getSession();
		
		s.setAttribute("notes", al);
		resp.sendRedirect("home.jsp");
		
	}

}
