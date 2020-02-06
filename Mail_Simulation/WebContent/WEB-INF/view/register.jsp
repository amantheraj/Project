<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Welcome To The Registration Page</h1>
<h4>${m }</h4><br>
<form action="register" method="post">
<pre>
  User Name       :<input type="text" name="userName"><br>
    Email         :<input type="email" name="email" required="required"><br>
Security Question :What is Your Nick Name?<br>
 Security Answer  :<input type="text" name="seqanswer"><br>
  Password        :<input type="password" name="password"><br>
                 <input type="submit" value="Register">
</pre>
</form>
</center>
</body>
</html>