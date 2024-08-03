package com.sathya.user.register;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		UserDao dao=new UserDao();
		List<UserInfo>listOfusers=dao.getAllUsers();
		
		request.setAttribute("listOfusers", listOfusers);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		
	}
	

}
