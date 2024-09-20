package com.MainApp;

import java.io.IOException;

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
@WebServlet("/updatenote")
public class Launch6 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String note = req.getParameter("note");
		String oname = req.getParameter("oldnote");
		
		System.out.println(name);
		System.out.println(note);
		System.out.println(oname);
		
	}

}
