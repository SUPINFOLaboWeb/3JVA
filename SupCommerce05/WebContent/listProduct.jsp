<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Product list</title>
	</head>
	<body>
	<%@ include file="/header.jsp" %> 
	<h1>Product list</h1>
	
	<% for(SupProduct product : SupProductDao.getAllProducts()) { %>
		<h2><%= product.getName() %></h2>
		<p>
			<%= product.getContent() %> <br />
			<%= product.getPrice() %> euros <br />
			<a href="showProduct.jsp?id=<%= product.getId() %>">show details</a>
			
			<form action= "<%= application.getContextPath() %>/auth/removeProduct" method="POST">
				<input name="id" type="hidden" value="<%= product.getId() %>" />
				
				<input type="submit" value="Remove this" />
			</form>
		</p>
	<% } %>
	
	 <%@ include file="/footer.jsp" %> 
	</body>
</html>