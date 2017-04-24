<!-- @Author:--Dnyaneshwar & Madhav-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Employee home</title>
</head>
<body style="background-color: #8FBC8F;">
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
		<h1>
			<b>Welcome : ${pageContext.request.userPrincipal.name}</b>
		</h1>
		<h2 align="right">
			<a href="javascript:formSubmit()" class="btn btn-danger btn-lg">
				Logout</a>
		</h2>
	</c:if>
	<div align="center"><h1><b>Employee Skills</b></h1></div>
	<hr>
	<hr>
	<br>
		<div align="center">
		
		<div class="container">
				<table border="5" class="table table-hover">
					<tr class="danger">
					
						<th>Employee Number</th>
						<th>Skill Name</th>
						<th>Rating</th>
						<th>Status</th>
						<th>Action</th>
						
					</tr>
					<c:forEach var="employee" items="${listEmpskills}">
						<tr class="success">

							<td>${employee.empId}</td>
							<td>${employee.skillName}</td>
							<td>${employee.employeeRating}</td>
							<td>${employee.status}</td>
							

							<td><a href="editEmpSkill?id=${employee.empId}&sid=${employee.skillId}&approvalId=${employee.approvalId}">Edit</a></td> 
							

						</tr>
					</c:forEach>
				</table>
			</div>
			<div align="center">
		</div>
		</table>
		<br> <br>
		<div align="center">
		<a href="employeeHome" class="btn btn-primary btn-lg">HOME</a>
		</div>
	</div>


</body>
</html>