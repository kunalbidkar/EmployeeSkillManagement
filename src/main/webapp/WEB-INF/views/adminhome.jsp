<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
tr.something {
  td {
    width: 10px;
  }
}
</style>
<title>Admin Home Page</title>
</head>
<body style="background-color: #f6c870;">
<hr>

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
		
			<b>Logged in by: ${pageContext.request.userPrincipal.name}</b>
			<h1><p align="center"><b>WELCOME ADMIN</b></p>
			<p align="right">
				<a href="javascript:formSubmit()" class="btn btn-danger" btn-lg"> Logout</a>
			</p>
		
	</c:if>
	<hr>
	<center><a href="newEmployee" class="btn btn-default btn-lg">Add New Employee</a></center>
	<br>
	<p align="center" ><font size="5"><b>EMPLOYEE LIST</b></font></p></h1> 
	
		<form action="admin/listEmployee" method="get">
			
		
			<div align="center" class="container">
			<table border="5" class="table table-hover">
				<tr class="danger" align="center"  class="something">
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
					<th>Manager Name</th>
					<td colspan='2'>Action</td>
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
						<td>${fn:substring(employee.employeeRole,5,20)}</td>
						<td>${employee.managerName}</td> 

						<td><a href="editEmployee?id=${employee.employeeId}">Edit</a></td>
						<td><a href="deleteEmployee?id=${employee.employeeId}">Delete</a></td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
 	<div align="center">
		<form action="listInactiveEmployee">
			<br><br><br><input type="submit" class="btn btn-default btn-lg" value="View Inactive Employees">
		</form>
	</div> 
	<c:if test="${!empty listInactiveEmp}">
		
		<br>
		<br>
		<p align="center"><font size="6"><b>LIST OF INACTIVE EMPLOYEE</b></font></p>
		<div align="center" class="container">
		<table border="5" class="table table-hover">

					<tr class="danger" align="center">
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
						<th>Manager Name</th>
						<td>Action</td>
					</tr>
					<c:forEach var="employee" items="${listInactiveEmp}">
						<tr class="info">

							<td>${employee.employeeFirstName}</td>
							<td>${employee.employeeLastName}</td>
							<td>${employee.employeeEmail}</td>
							<td>${employee.employeeMobNo}</td>
							<td>${employee.employeeAddress}</td>
							<td>${employee.employeeGender}</td>
							<td>${employee.employeeDOB}</td>
							<td>${employee.employeeDOJ}</td>
							<td>${employee.employeeStatus}</td>
							<td>${fn:substring(employee.employeeRole,5,20)}</td>
							<td>${employee.managerName}</td> 

							<td><a href="editEmployee?id=${employee.employeeId}">Edit</a></td>
							

						</tr>
					</c:forEach>
				</table>
			</div>
			
			</c:if>
			
</body>
</html>