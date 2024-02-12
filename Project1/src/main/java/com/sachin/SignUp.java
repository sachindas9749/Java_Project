package com.sachin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name = req.getParameter("name");
		String Email = req.getParameter("email");
		String Pass = req.getParameter("confirmpass");
		String Hint = req.getParameter("hint");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			PreparedStatement ps = con.prepareStatement("insert into Users_Details values(?,?,?,?)");
			ps.setString(1,Name);
			ps.setString(2, Email);
			ps.setString(3,Pass);
			ps.setString(4, Hint);
			int i= ps.executeUpdate();
			if(i>0) {
				RequestDispatcher rd = req.getRequestDispatcher("LoginForm.html");
				rd.forward(req, resp);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}
