package com.mohit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/square")
public class SqrServlet extends HttpServlet{

public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
//	int k = Integer.parseInt(req.getParameter("k"));
	
//	int k = req.getAttribute("k");
	
//	HttpSession session = req.getSession();
//	int k = (int) session.getAttribute("k");
	
	int k = 0;
	Cookie[] cookies = req.getCookies();
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("k"))
			k = Integer.parseInt(cookie.getValue());
	}
	PrintWriter writer = res.getWriter();
	writer.println("Result is " + k*k);
	
//	ServletContext ctx = getServletContext();
//	String str = ctx.getInitParameter("name");
//	writer.println(str);
//	
//	ServletConfig cfg = getServletConfig();
//	String str1 = cfg.getInitParameter("name");
//	writer.println(str1);
	}
}
