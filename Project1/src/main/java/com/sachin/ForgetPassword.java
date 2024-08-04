package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Forget")
public class ForgetPassword extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Name = req.getParameter("name");
		String UserId = req.getParameter("userid");
		PrintWriter out = resp.getWriter();
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
		PreparedStatement ps = con.prepareStatement("select * from Users_Details where Name= '"+Name+"' and Email='"+UserId+"'");
		ResultSet rs = ps.executeQuery();
		 if(rs.next()){		
			 resp.setContentType("text/html");
			 out.println("<span><h2 style='color:green';'text-align:center'>Your Password Hint is :-   "+rs.getString("Hint")+" </h2>");
				 RequestDispatcher rd=req.getRequestDispatcher("LoginForm.html");
				 rd.include(req, resp);
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
