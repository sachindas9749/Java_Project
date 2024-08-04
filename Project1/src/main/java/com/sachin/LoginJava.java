package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Login")
public class LoginJava extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String UserId = req.getParameter("userid");
		String Userpass= req.getParameter("userpass");
		PrintWriter out = resp.getWriter();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		PreparedStatement ps = con.prepareStatement("select * from Users_Details where Email= '"+UserId+"' and Password='"+Userpass+"'");
		ResultSet rs = ps.executeQuery();
		 if(rs.next()){
				 out.print("Login successfull");
				 System.out.println("Login successfull");
			 }
		 else {
			 out.print("UserId didn't match");
			 System.out.println("UserId didn't match");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

