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
@WebServlet("/delInfo")
public class Launch3 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		
		
		System.out.println(id);
		
		Connection con = ConnectionFactory.getCon();
		userDao iDao = new userDao();
		
		
		String res = iDao.delInfo(Integer.valueOf(id), con);
		HttpSession s = req.getSession();
		
		ArrayList<Info> al = iDao.getAllInfo(con);
		
		
		if(res.equals("deleted"))
		{
			s.setAttribute("alinfo", al);
			resp.sendRedirect("home.jsp");
		}
	}
}







