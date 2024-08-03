package com.sathya.user.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		UserDao dao=new UserDao();
		UserInfo userInfo=dao.findByEmail(email);
		
		request.setAttribute("userinfo", userInfo);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("searchresult.jsp");
		dispatcher.forward(request, response);
	}

}
