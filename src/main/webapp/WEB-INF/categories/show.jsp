<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Show Category</title>
</head>
<body class="p-4">
	<div>	
		<h1>
			<c:out value="${category.name}"/>
		</h1>
		<a href="/">Home</a>
	</div>
	<hr/>
	<div>	
		<h4>Products:</h4>
		<ul>
			<c:forEach var="product" items="${assignedProducts }">
				<li>
					<c:out value="${product.name }"/>
				</li>
			</c:forEach>
		</ul>
	</div>
	<hr/>
 <form action="/categories/${id}" method="post">
	<h4>Add Product:</h4>				
	<select name="productId" id="productId" class="input">
	    <c:forEach var="product" items="${unassignedProducts}">
	    	<option value="${product.id}">
	    		  <c:out value="${product.name}"/>
	    	</option>
	    </c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add"/>
</form> 
</body>
</html>