<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<center>
<h1>Search Page</h1>
<h3 style="text-align:center"> 
<a href="addproduct">Add Product</a>|
<a href="search">Search Products</a>|
<a href="viewproducts">View Products</a>|
<a href="logout">Logout</a></h3>
<hr>
<h3>
<form action="searchdata" method="post">
<input type="search" name="search" placeholder="Search..">
<input type="submit" value="Search">

</form>
</h3>
</center>
</body>
</html>