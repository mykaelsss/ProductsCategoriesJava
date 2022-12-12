<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<main class="p-4">
		<div class="d-flex justify-content-between align-items-end">
			<h1>New Category</h1>
			<a href="/">Home</a>
		</div>
		<form:form action="/categories/new" method="post" modelAttribute="category" class="form w-25">
			<div>
				<form:errors path="name"/>
			</div>
 			<div>		
				<form:label path="name">Name: </form:label>
				<form:input path="name" class="form-control"/>
			</div> 
			<input type="submit" value="Submit" class="btn btn-primary mt-2" />
		</form:form>
	</main>
</body>
</html>