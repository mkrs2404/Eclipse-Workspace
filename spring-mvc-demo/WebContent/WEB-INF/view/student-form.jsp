<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
		
		First Name: <form:input path="firstName" />
		<br><br>
		
		Last Name: <form:input path="lastName" />
		<br><br>
		
		Country: 
		<%-- <form:select path="country">
				
				<form:option value="BRA" label="Brazil"/>
				<form:option value="FRA" label="France"/> 
				<form:option value="IND" label="India"/> 
				<form:option value="GER" label="Germany"/>  
				
		</form:select> --%>
		
		<form:select path="country">
				
				<form:options items="${student.countryOptions }"/>  
				
		</form:select>
		
		<br><br>
		
		Favourite Language:
		Java <form:radiobutton path="favLang" value="Java"/>
		C# <form:radiobutton path="favLang" value="C#"/>
		PHP <form:radiobutton path="favLang" value="PHP"/>
		Ruby <form:radiobutton path="favLang" value="Ruby"/>
		
		<br><br>
		
		Operating Systems:
		Linux <form:checkbox path="os" value="Linux"/>
		Mac OS <form:checkbox path="os" value="Mac OS"/>
		Windows <form:checkbox path="os" value="Windows"/>
		
		<br><br>
		
		<input type="submit" value="Submit" />
		
	</form:form>	
</body>
</html>