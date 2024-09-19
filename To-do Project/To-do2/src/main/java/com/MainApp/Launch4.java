package com.MainApp;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;


import com.ConnectionFactory.ConnectionFactory;
import com.Dao.userDao;
import com.Entity.UserData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addnote")
public class Launch4 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String note = req.getParameter("note");
		String name = req.getParameter("uname");
		
		
		Connection con = ConnectionFactory.getCon();
		userDao uDao = new userDao();
		
		uDao.addNote(name, note, con);
		
		
		ArrayList<UserData> al = uDao.getNotes(name, con);
		HttpSession s = req.getSession();
		
		s.setAttribute("notes", al);
		resp.sendRedirect("home.jsp");
		
	}

}
