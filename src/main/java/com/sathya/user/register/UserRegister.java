package com.sathya.user.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		UserDao dao=new UserDao();
		int result=dao.SaveUser(username, password, email, mobile);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("registerstatus.jsp");
				dispatcher.forward(request, response);
		
		PrintWriter writer=response.getWriter();
		writer.println("data inserted successfully njoy pandagoww!!....");
	}

}

