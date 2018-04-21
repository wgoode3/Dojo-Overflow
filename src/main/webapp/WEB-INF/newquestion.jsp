<!DOCTYPE html>
<html>
<head>
	<title>Dojo Overflow</title>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<link type="text/css" rel="stylesheet" href="/css/style.css">
</head>
<body>

	<div class="container">
		<h1>Dojo Overflow</h1>
		
		<fieldset class="col">
			<legend>New Question</legend>
			<form action="/question" method="post" style="display:inline;">
				<p>
					<span style="display:block;">Question:</span>
					<textarea name="question" rows=8 cols=60></textarea>
				</p>
				<p>
					<span style="display:block;">Tags:</span>
					<textarea name="tags0" rows=1 cols=60></textarea>
				</p>
				<button type="submit">Submit Question</button>
			</form>
			<a href="/"><button>Cancel</button></a>
		</fieldset>
		
		<ul class="col" data-errors="hide">
			<li>The question must be 12 characters or longer!</li>
			<li>There must be at least one valid tag!</li>
			<li>Tags must be 2 characters or more and separated by spaces!</li>
		</ul>
		
	</div>
	
	<script type="text/javascript" src="/js/script.js"></script>
	
</body>
</html>