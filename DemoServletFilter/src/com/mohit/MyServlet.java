package com.mohit;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addStudent")
public class MyServlet extends HttpServlet {

	protected void doGet(jakarta.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter out = response.getWriter();
		 String name = request.getParameter("name");
		 int roll = Integer.parseInt(request.getParameter("roll"));
		 		 
		 out.println(name);
		 out.println(roll);
	}


}
