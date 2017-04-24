<!-- @Author:--Dnyaneshwar & Madhav-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<%@ include file="includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee Skill</title>
</head>
<body>

 <div class="col-lg-1"
  style="text-align: center; background-color: #ededed; padding: 20px; margin-top: 180px; margin-left: 500px; width: 500px; height: 200px; border: 2px solid black">
  <form:form action="updateEmpSkill" method="post" 
   style="text-align:center;">
   
  <form:input type="hidden" class="input_text"
									path="empId" id="empId" value="${emp.empId}" />

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