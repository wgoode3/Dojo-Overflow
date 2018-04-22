<!DOCTYPE html>
<html>
<head>
	<title>Dojo Overflow</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div class="container">
	
		<h1>Dojo Overflow</h1>
		
		<p><a href="/"><button>Return to dashboard</button></a></p>
		
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
		
		<p>Don't yet have an account? <a href="/signup">Sign up</a></p>
	
	</div>
	
</body>
</html>
			