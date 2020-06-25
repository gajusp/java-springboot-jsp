<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>The following Product added Successfully:</h2>

<table>
	<tr>
		<td> Product Id: </td>
		<td> <%=request.getAttribute("productId") %>  </td>
		
	</tr>
	<tr>
		<td> Product Name: </td>
		<td> <%=request.getAttribute("productName") %> </td>
	</tr>
	<tr>
		<td> Price: </td>
		<td> <%=request.getAttribute("price") %> </td>
	</tr>
</table>
</body>
</html>