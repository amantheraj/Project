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
<h1>Compose mail</h1>
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
<form action="composedraftData" method="post">
<pre>
from:${adto.getFromId() }<br><br>
     to:<input type="email" name="to" value="${adto.getToId()}"required="required"><br>
    sub:<input type="text" name="sub" value="${adto.getSubject() }"><br>
Message:<input type="text" name="body" value="${adto.getMessage() }"><br>
     <input type="submit" value="sent"><br>
</pre>
</form>
</center>
</body>
</html>