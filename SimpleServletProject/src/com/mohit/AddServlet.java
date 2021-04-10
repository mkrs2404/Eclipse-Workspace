package com.mohit;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
//		req.setAttribute("k", k);
		
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
//		res.sendRedirect("square?k="+k);
		
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("square");
		
		Cookie cookie = new Cookie("k", String.valueOf(k));
		res.addCookie(cookie);
		res.sendRedirect("square");
		
		
		
	}
}
