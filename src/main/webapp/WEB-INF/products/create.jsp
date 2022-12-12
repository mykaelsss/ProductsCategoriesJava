<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<main class="p-4">
		<div class="d-flex justify-content-between align-items-end">
			<h1>New Product</h1>
			<a href="/">Home</a>
		</div>
		<form:form action="/products/new" method="post" modelAttribute="product" class="form w-25">
			<div>
				<form:errors path="name"/>
				<form:errors path="description"/>
				<form:errors path="price"/>
			</div>
 			<div>		
				<form:label path="name">Name: </form:label>
				<form:input path="name" class="form-control"/>
			</div> 
			<div>		
				<form:label path="description">Description: </form:label>
				<form:textarea path="description" class="form-control"/>
			</div> 
			<div>		
				<form:label path="price">Price: </form:label>
				<form:input type="number" path="price" step="any" class="form-control"/>
			</div> 
			<input type="submit" value="Submit" class="btn btn-primary mt-2" />
		</form:form>
	</main>
</body>
</html>