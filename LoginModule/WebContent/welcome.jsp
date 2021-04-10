<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if(session.getAttribute("uname") == null){
			response.sendRedirect("login.jsp");
		}
	%>

	Welcome ${uname}
	<br><br>
	<a href = videos.jsp> Videos</a>
	<br><br>
	<form action="Logout">
		<input type = "Submit" value = "Logout">
	</form>
</body>
</html>