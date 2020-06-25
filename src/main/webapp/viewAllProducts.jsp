<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.demo.beans.*, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Products</title>
</head>
<body>
	<h2>List of All Products</h2>
	<table>
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Price</th>
		<%
			List<Product> allProductsList = (List<Product>) request.getAttribute("allProductsList");
			for (Product product : allProductsList) {
		%>
		<tr>
			<td><%=product.getProductId()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getPrice()%></td>
			<td><a href="deleteProduct?productId=<%=product.getProductId()%>">X</a></td>
			<td><a href="updateProductForm?productId=<%=product.getProductId()%>">Update</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>