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
<title>LIST OF PENDING APPROVAL</title>
</head>
<body style="background-color: #FAEBD7;">
	<hr>
<TABLE BORDER="0" cellpadding="" CELLSPACING="2">
   <TR align="left">
    <td>Total Pending Approvals = </td>
    <TD WIDTH="220" HEIGHT="80" BACKGROUND="<%=request.getContextPath()%>/css/new.png"
     VALIGN="middle" > 
     <b><FONT SIZE="+3" COLOR="White"><label> &nbsp &nbsp ${pendingApprovalsCount} </label></FONT></b></TD>
   </TR>
 </TABLE> 
  
  
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



	<p align="center">
		<font size="4" align="center"><b>LIST OF PENDING APPROVAL</b></font>
	</p>
	<hr>
	<div align="center" class="container">
		<table border="5" class="table table-hover">
			<tr class="danger" align="center">
				<th>Approval Id</th>
				<th>Employee Id</th>
				<th>Name</th>
				<!-- <th>Skill Id</th> -->
				<th>Skill Name</th>
				<th>Employee rating</th>
				<th>Comments</th>
				<th colspan='2'>Action</th>
			</tr>
			<c:forEach var="empSkills"
				items="${employeeSkillsPendingForApprovals}">
				<tr class="success">
					<td>${empSkills.approvalId}</td>
					<td>${empSkills.empId}</td>
					<td>${empSkills.empName}</td>
					<%-- <td>${empSkills.skillId}</td> --%>
					<td>${empSkills.skillName}</td>
					<td>${empSkills.employeeRating}</td>
					<td><input type="text" width=20></td>


					<td><a href="approveSkillrating?id=${empSkills.approvalId}">Approve</a></td>
					<td><a href="rejectSkillrating?id=${empSkills.approvalId}">Reject</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<hr>
	<p align="center">
		<font size="4"><b>LIST OF APPROVED SKILLS</b></font>
	</p>
	<hr>
	<div align="center" class="container">
		<table border="5" class="table table-hover">
			<tr class="danger" align="center">
					<th>Approval Id</th>
				<th>Employee Id</th>
				<th>Name</th>
				<!-- <th>Skill Id</th> -->
				<th>Skill Name</th>
				<th>Employee rating</th>
				<th>Comments</th>
				<!-- <th colspan='2'>Action</th> -->
			</tr>
			<c:forEach var="empSkills"
				items="${employeeSkillsApprovedForApprovals}">
				<tr style="color: #228B22">
					<td>${empSkills.approvalId}</td>
					<td>${empSkills.empId}</td>
					<td>${empSkills.empName}</td>
					<%-- <td>${empSkills.skillId}</td> --%>
					<td>${empSkills.skillName}</td>
					<td>${empSkills.employeeRating}</td>
					<td><input type="text" width=20></td>


					<%-- <td><a href="approveSkillrating?id=${empSkills.empId}">Approve</a></td>
					<td><a href="rejectSkillrating?id=${empSkills.empId}">Reject</a></td> --%>

				</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<hr>
	<p align="center">
		<font size="4"><b>LIST OF REJECTED SKILLS</b></font>
	</p>
	<hr>
	<div align="center" class="container">
		<table border="5" class="table table-hover">
			<tr class="danger" align="center">
				<th>Employee Id</th>
				<th>Name</th>
				<!-- <th>Skill Id</th> -->
				<th>Skill Name</th>
				<th>Employee rating</th>
				<th>Comments</th>
				<th colspan='2'>Action</th>
			</tr>
			<c:forEach var="empSkills"
				items="${employeeSkillsRejectedForApprovals}">
				<tr style="color: #FF4500">

					<td>${empSkills.empId}</td>
					<td>${empSkills.empName}</td>
					<%-- <td>${empSkills.skillId}</td> --%>
					<td>${empSkills.skillName}</td>
					<td>${empSkills.employeeRating}</td>
					<td><input type="text" width=20></td>


					<td><a href="approveSkillrating?id=${empSkills.approvalId}">Approve</a></td>


				</tr>
			</c:forEach>
		</table>

	</div>
	<font size='5'>
		<center>
			<b><a href="managerHome" class="btn btn-info" btn-lg">HOME</a></b>
		</center>
	</font>>
</body>
</html>