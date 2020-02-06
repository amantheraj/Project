<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome to Home Page ${dto.getUsername() }</h1>

<h3>${msg1 }</h3>
${msg }
${dto1 }
<hr>
<h3 style="text-align:center"> 
<a href="addproduct">Add Product</a>|
<a href="search">Search Products</a>|
<a href="viewproducts">View Products</a>|
<a href="logout">Logout</a></h3>
</center>
</body>
</html>