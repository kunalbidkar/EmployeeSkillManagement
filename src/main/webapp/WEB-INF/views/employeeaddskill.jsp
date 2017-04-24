<!-- @Author:--Dnyaneshwar  & Madhav-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ include file="includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
			
			<a href="employeeHome" class="btn btn-primary btn-lg">HOME</a>
		
		</h2>
	</c:if>
	<h1>Add Skill & Rating</h1>
	<hr>

 <div class="col-lg-1"
  style="text-align: center; background-color: #ededed; padding: 20px; margin-top: 180px; margin-left: 500px; width: 500px; height: 200px; border: 2px solid black">
  <form:form action="addEmpSkill" method="post" modelAttribute="employeeskills"
   style="text-align:center;">
   
  

   <div class="form-group">
    <label for="Skill_Name">Name of your skill:</label>
    <form:select path="skillId" var="skillList">
				<c:forEach items="${skillList}" var="skillList">
					<option value="${skillList.skillId}">${skillList.skillName}
					</option>
				</c:forEach>
			</form:select>
   </div>
   <div class="form-group">

    <hr>
    <label for="Skill_Rating">Your Rating for the above skill:</label> <input
     type="number" class="form-control" path='employeeRating' name="employeeRating" min="1" max="10">
   </div>
   <input type="submit" class="button" value="Submit" />
   
  </form:form>
 </div>
 
</body>
</html>