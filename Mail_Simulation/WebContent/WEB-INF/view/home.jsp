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
<h1>Welcome To The Home Page ${ sdto.getUserName() }</h1>
<h4>${m }<br></h4>
<h4>${msg }<br></h4>
<h4>${msg1 }<br></h4>
<a href="compose">Compose</a>
<a href="inbox">Inbox</a>
<a href="sent">Sent</a>
<a href="draft">Draft</a>
<a href="change">ChangePassword</a>
<a href="deleteMail">DeletedMail</a>
<a href="logout">LogOut</a>
</center>
</body>
</html>