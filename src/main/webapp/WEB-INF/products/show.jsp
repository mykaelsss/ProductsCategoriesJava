<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Show Product</title>
</head>
<body class="p-4">
	<div>	
		<h1>
			<c:out value="${product.name}"/>
		</h1>
		<a href="/">Home</a>
	</div>
	<hr/>
	<div>	
		<h4>Categories:</h4>
		<ul>
			<c:forEach var="category" items="${assignedCategories }">
				<li>
					<c:out value="${category.name }"/>
				</li>
			</c:forEach>
		</ul>
	</div>
	<hr/>
<form action="/products/${id}" method="post">
	<h4>Add Category:</h4>				
	<select name="categoryId" id="categoryId" class="input">
	    <c:forEach var="category" items="${unassignedCategories}">
	    	<option value="${category.id}">${category.name}</option>
	    </c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add"/>
</form>
</body>
</html>