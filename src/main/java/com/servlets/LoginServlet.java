package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username=req.getParameter("uname1");
	String password=req.getParameter("pwd");
	//jdbc starts
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Driver class loaded");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DileepG",
				"sa", "sa@123");
		System.out.println("connection retrived");
		PreparedStatement pstmt = conn.prepareStatement("select *from snapchat where username=? and password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs=pstmt.executeQuery();	
		
		//if rs is having data that should be forwded to Homepage
		if(rs.next()) {
			req.setAttribute("user", username);
			req.getRequestDispatcher("homepage.jsp").forward(req, resp);
		} else {
			req.setAttribute("invalid", "Invalid Credentials!!!!!Please check your credentials otherwise your system will hang!!");
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		}
		
		System.out.println("Successfully login User!!");
	} catch(Exception e) {
		e.printStackTrace();
		System.out.println("inside catch block");
	}

	
	}
	
}
