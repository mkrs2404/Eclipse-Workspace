package com.mohit.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showMyPage() {
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}
	
	/*
	 * // @RequestMapping("/processFormV2") // public String
	 * toUpperCase(HttpServletRequest request, Model model) { // // String name =
	 * request.getParameter("studentName"); // String result = "Yo! " +
	 * name.toUpperCase(); // model.addAttribute("message", result); // return
	 * "process-form"; // }
	 */	
	
	// Instead of passing HttpServletRequest request, we can directly get the request parameters
	@RequestMapping("/processFormV2")
	public String toUpperCase(@RequestParam("studentName") String name, Model model) {
		
		String result = "Yo! " + name.toUpperCase();
		model.addAttribute("message", result);
		return "process-form";
	}
}
