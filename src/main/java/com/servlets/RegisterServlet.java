package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.snaputil.Validations;

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String mail = req.getParameter("mail");
		String mobile = req.getParameter("mob");
		String gender = req.getParameter("gender");
		String password = req.getParameter("pwd");
		if(mail==null || mail.isEmpty()){
			System.out.println("Invalid mail entered");
		}
		// validation of mobile
		boolean isValidMobile = Validations.isValid(mobile);
		if (!isValidMobile) {
			//System.out.println("entered perfect validation proceed!!sorry for interuption");
		 	req.setAttribute("error", "Invalid mobile number entered!!!");
			req.getRequestDispatcher("registration.jsp").forward(req, resp);
			return;
		}
		boolean isValidMail=Validations.isValidMail(mail);
        if(!isValidMail){
        	req.setAttribute("error", "Invalid email entered!!!");
			req.getRequestDispatcher("registration.jsp").forward(req, resp);
			return;
        }
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("Driver class loaded");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DileepG", "sa",
					"sa@123");
			System.out.println("connection retrived");
			PreparedStatement pstmt = conn
					.prepareStatement("insert into snapchat(username,email,gender,password,mobile) values(?,?,?,?,?)");
			pstmt.setString(1, uname);
			pstmt.setString(2, mail);
			pstmt.setString(3, gender);
			pstmt.setString(4, password);
			pstmt.setString(5, mobile);
			int result = pstmt.executeUpdate();
			System.out.println(result + "inserted");
		} catch (SQLServerException sse) {
			sse.printStackTrace();
			System.out.println("handled by sqlserverexception");
			req.setAttribute("error", "Already registered--please enter valid username");
			req.getRequestDispatcher("registration.jsp").forward(req, resp);
			return;
		} catch (Exception se) {
			se.printStackTrace();
		}
		System.out.println(uname + "---" + mail + "---" + gender + "---" + password + "---" + mobile);
		req.getRequestDispatcher("Login.jsp").forward(req, resp);
	}

}
