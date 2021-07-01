<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registered</title>
</head>
<body>
The student is registered: ${student.firstName} ${student.lastName} from ${student.country}
<br><br>
Favorite Language: ${student.favLang}
<br><br>
Operating Systems: 
<ul>
	<c:forEach var="temp" items="${student.os}"> 
		<li> ${temp}</li>
	</c:forEach>
</ul>
</body>
</html>