<!DOCTYPE html>
<html>
<head>
	<title>Dojo Overflow</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
</head>
<body>
	
	<h1>Dojo Overflow</h1>
	
	<form action="/user" method="post">
		<div>
			First Name: <input type="text" name="firstName" placeholder="First Name">
			Last Name: <input type="text" name="lastName" placeholder="Last Name">
		</div>
		<div>
			Email Address: <input type="text" name="email" placeholder="Email Address">
			Username: <input type="text" name="username" placeholder="Username">
		</div>
		<div>
			Password: <input type="password" name="password" placeholder="Password">
			Confirm Password: <input type="password" name="passwordConfirmation" placeholder="Confirm Password">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">Sign up</button>
	</form>
	
	<!-- Validation errors are flashed here -->
	<p>${errors.get("firstName")}</p>
	<p>${errors.get("lastName")}</p>
	<p>${errors.get("email")}</p>
	<p>${errors.get("username")}</p>
	<p>${errors.get("password")}</p>
	<p>${errors.get("passwordConfirmation")}</p>
	
</body>
</html>