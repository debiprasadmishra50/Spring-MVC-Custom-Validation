<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Validation</title>
</head>
<body>
	<h1>Hello! Welcome to Spring MVC Validation API App</h1> <hr><br>
	
	Customer Name : ${customer.firstName} ${customer.lastName} <br><br>
	
	Free Passes : ${customer.freePasses} <br><br>
	
	Postal Code : ${customer.postalCode} <br><br>
	
	Course Code : ${customer.courseCode} <br><br>
</body>
</html>