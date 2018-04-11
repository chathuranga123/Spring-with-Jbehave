<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<title>Login</title>
	</head>
	<body>

	<div class="w3-row">

	<div style="margin-top: 150px;margin-left: 30%;margin-right: 30%" >
	
		<div class="w3-container w3-blue">
		  <h2>Login Form</h2>
		</div>
		<form:form id="loginForm" class="w3-container" method="post" action="login.htm" modelAttribute="loginInputBean">
			<form:label path="userName">Enter your user-name</form:label>
			<form:input class="w3-input"  id="userName" name="userName" path="userName" /><br>
			
			<form:label path="password">Please enter your password</form:label>
			<form:password class="w3-input"  id="password" name="password" path="password" /><br>
			
			<input class="w3-button w3-black" type="submit" value="Submit" />
		</form:form>
		</div>

		</div>

</body>
</html> 