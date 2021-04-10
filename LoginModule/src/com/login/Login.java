package com.login;

import java.io.IOException;

import com.login.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginDao dao = new LoginDao(); 

	protected void doPost(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if(dao.check(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("uname",uname);
			response.sendRedirect("welcome.jsp");
		}
		else
			response.sendRedirect("login.jsp");
	}


}
