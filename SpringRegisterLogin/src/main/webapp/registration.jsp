<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Regsitration Form</title>
</head>
<body>
<form action="register" method="post">
<pre>
<h1> Registration Form</h1>
Username <input type="text" name="userName"/><br>
Password <input type="password" name="password"/><br>
<input type="submit" value="Register"/>
</pre>
</form>
${msg}
</body>
</html>