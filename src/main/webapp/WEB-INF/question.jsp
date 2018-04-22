<!DOCTYPE html>
<html>
<head>
	<title>Dojo Overflow</title>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>     
	<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div class="container">
		<h1>Dojo Overflow</h1>
	
		<c:if test="${user != null}">
			<p>Welcome back: ${user.getUsername()}! <a href="/logout"><button>Sign out</button></a></p>
		</c:if>
		<c:if test="${user == null}">
			<p><a href="/signin">Sign in</a> | <a href="/signup">Sign up</a></p>
		</c:if>
		
		<p><a href="/"><button>Return to dashboard</button></a></p>
		
		<h3>
			${question.getUser().getUsername()} asked on: 
			<fmt:formatDate pattern = "MMMM dd',' yyyy 'at' h:mm:ss a" value ="${question.createdAt}"/>
		</h3>
		
		<h3>${question.question}</h3>
		
		
		<p>
			Tags: <c:forEach items="${question.getTags()}" var="tag" varStatus="loop">
				<span class="box">${tag.subject}</span>
			</c:forEach>
		</p>
		
		<fieldset class="col">
			<legend>Answers</legend>
			<c:if test="${question.getAnswers().size() == 0}"><p>There are no answers yet</p></c:if>
			<ol>
			<c:forEach items="${question.getAnswers()}" var="answer">
				<li class="answer">
					<p>${answer.getUser().getUsername()} answered on: 
						<fmt:formatDate pattern = "MMMM dd',' yyyy 'at' h:mm:ss a" value ="${answer.createdAt}"/>
					</p>
					<p><pre>${answer.answer}</pre></p>
				</li>
			</c:forEach>
			</ol>
		</fieldset>
		
		<fieldset class="col">
			<legend>Your Answer</legend>
			<form action="/answer/${question.id}" method="post">
				<p>
					<span style="display:block;">Answer:</span>
					<textarea name="answer" rows=6 cols=60></textarea>
				</p>
				
				<p>${error}</p>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
				<button type="submit">Submit Answer</button>
			</form>
		</fieldset>
	</div>
	
</body>
</html>