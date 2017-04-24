<!-- @Author:--Dnyaneshwar & Bimal-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
	function viewMyEmployee() {
		document.getElementById('f1').action = "/Employee_Managemnt/manager/viewMyEmployee";
		document.getElementById('f1').submit();
		//alert("viewEmployeeSkills");
	};

	function viewPendingApprovals() {

		document.getElementById('f1').action = "/Employee_Managemnt/manager/managePendingApprovals";
		/* alert("viewPendingApprovals"); */
		document.getElementById('f1').submit();
		//alert("viewPendingApprovals");
	};

	function viewEmployeeSkills() {
		document.getElementById('f1').action = "/Employee_Managemnt/manager/viewEmployeeSkills";
		document.getElementById('f1').submit();
		//alert("viewEmployeeSkills");
	};
</script>
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
<title>Manager home</title>
</head>
<body style="background-color: #FAEBD7;">
	<hr>
	<%-- <TABLE BORDER="0" cellpadding="" CELLSPACING="2">
		<TR align="left">
			<td>Total Pending Approvals =</td>
			<TD WIDTH="220" HEIGHT="80"
				BACKGROUND="<%=request.getContextPath()%>/css/new.png"
				VALIGN="middle"><b><FONT SIZE="+3" COLOR="White"><label>
							&nbsp &nbsp ${pendingApprovalsCount} </label></FONT></b></TD>
		</TR>
	</TABLE> --%>
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
			<a href="javascript:formSubmit()" class="btn btn-danger"btn-lg">
				Logout</a>
		</h2>
	</c:if>

	<h1 align="center">
		<b>Manager home</b>
	</h1>
	<hr>
	</br>
	</br>
	</br>
	</br>
	</br>
	<h3>
		<center>
			<form id="f1">
				<div style="width: 100%">
					<button type="submit" style="width: 20%; color: green;"
						class="btn btn-default btn-lg" onclick="viewMyEmployee()">View
						Employee assigned to me</button>
					</br> </br> </br>
					<button type="submit" style="width: 20%; color: green;"
						class="btn btn-default btn-lg" onclick="viewPendingApprovals()">View
						Pending Approvals</button>
					</br> </br> </br>
					<button type="submit" style="width: 20%; color: green;"
						class="btn btn-default btn-lg">
						View Employee Skills
						<!-- onclick="viewEmployeeSkills()" -->
					</button>
					</br> </br> </br> <a href="viewskill" style="width: 20%; color: green;"
						class="btn btn-default btn-lg">Skill Updation</a>
				</div>
			</form>
		</center>
	</h3>
	</div>



</body>
</html>