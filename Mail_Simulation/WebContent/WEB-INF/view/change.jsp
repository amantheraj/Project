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
<h1>Change Password</h1>
<div align="center">
<a href="inbox">Inbox</a>
<a href="sent">Sent</a>
<a href="draft">Draft</a>
<a href="compose">Compose</a>
<a href="change">ChangePassword</a>
<a href="deleteMail">DeletedMail</a>
<a href="logout">LogOut</a>
</div>
<hr>
<form action="chang" method="post">
<pre>
New Password      :<input type="password" name="password"><br>
Confirm Password  :<input type="password" name="cpassword"><br>
                   <input type="submit" value="submit">
                   <h4> ${msg } </h4>
</pre>
</form>
</center>
</body>
</html>