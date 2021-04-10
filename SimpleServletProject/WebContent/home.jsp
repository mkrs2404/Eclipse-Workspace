<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>

	<c:out value = "Hello World"/>
<%-- <% 
		String url = "jdbc:mysql://localhost:3306/mydb";
		String userName = "root";
		String pwd = "root";
		String query = "Select * from student where roll=101";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,userName,pwd);
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		rs.next();

%>

	Roll No. : <%= rs.getString(1) %> <br>
	Name : <%= rs.getString(2) %> <br>
	Marks: <%= rs.getString(3) %> <br> --%>
</body>
</html>