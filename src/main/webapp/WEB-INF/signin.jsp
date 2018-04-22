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
	
	<p>${errors}</p>
	
	<form action="/session" method="post">
		<div>
			Email Address: <input type="text" name="email" placeholder="Email Address">
		</div>
		<div>
			Password: <input type="text" name="password" placeholder="Password">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit">Sign in</button>
	</form>
	
</body>
</html>
			