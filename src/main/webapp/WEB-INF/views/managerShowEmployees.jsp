<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"
	charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
hr {
	display: block;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 3px;
}
</style>
<title>View Employee Asign to Manager</title>
<hr>
</head>

<body style="background-color: #FAEBD7;">
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			<b>Logged in by: ${pageContext.request.userPrincipal.name}</b>
			<p align="right">
				<a href="javascript:formSubmit()" class="btn btn-danger" btn-lg"> Logout</a>
			</p>
		</h2>
	</c:if>

	<div align="center">
		<form action="admin/listEmployee" method="get">
			<h1>
				<b>LIST OF EMPLOYEES ASSIGNED</b>
			</h1>
			<hr>
			</br></br>
			<div class="container">
				<table border="5" class="table table-hover">
					<tr class="danger">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Mobile Number</th>
						<th>Address</th>
						<th>Gender</th>
						<th>Birth Date</th>
						<th>Joining Date</th>
						<th>Status</th>
						<th>Role</th>

					</tr>
					<c:forEach var="employee" items="${listEmp}">
						<tr class="success">

							<td>${employee.employeeFirstName}</td>
							<td>${employee.employeeLastName}</td>
							<td>${employee.employeeEmail}</td>
							<td>${employee.employeeMobNo}</td>
							<td>${employee.employeeAddress}</td>
							<td>${employee.employeeGender}</td>
							<td>${employee.employeeDOB}</td>
							<td>${employee.employeeDOJ}</td>
							<td>${employee.employeeStatus}</td>
							<td>${employee.employeeRole}</td>



						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
	<center><b><a href="managerHome" class="btn btn-info btn-lg">HOME</a></b></center>
</body>
</html>