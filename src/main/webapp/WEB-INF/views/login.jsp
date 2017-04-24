<!-- @Author:--Kunal-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
<link rel="stylesheet" href="./css/style.css" type="text/css"></link>
</head>
<body onload='document.loginForm.username.focus();'
	style="background: gray;">

	<h1 align="center">Spring Security Login Form (Database
		Authentication)</h1>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="login-box" align="center">

		<h3>Login with Username and Password</h3>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm'
			action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table border="20" style="background: white;">
				<tr>
					<td>User Id:</td>
					<td><input type='text' name='username' size="100" ></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' size="100"/></td>
				</tr>
				<tr align="center">
					<td colspan='2'><input name="submit" type="submit"
						value="submit" style="width: 100"/></td>
				</tr>
			</table>



			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

		</form>
	</div>

</body>
</html>