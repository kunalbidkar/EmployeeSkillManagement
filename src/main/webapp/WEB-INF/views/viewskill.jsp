<!-- @Author:--Dnyaneshwar-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"
	import="com.xp.employee.model.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>Skill List</title>
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
</head>
<body style="background-color: #FAEBD7;">
			</br>
			</br>
			</br>
			<h2><p align="center">Available Skills</p></h2>
			<hr>
			</br>
			</br>
			</br>
	<div align="center">
		<div class="container">
		<table border="5" class="table table-hover">
			
				<tr class="danger">
					<th>Skill Id</th>
					<th>Skill Name</th>
					<th>Edit Skill</th>
					<th>Delete Skill</th>

				</tr>
			

			
				<c:forEach items="${skillList}" var="skillList1">
					<tr class="success">
						<td><c:out value="${skillList1.skillId}" /></td>
						<td><c:out value="${skillList1.skillName}" /></td>

						<td><a href="editTemp?id=${skillList1.skillId}">Edit</a></td>
						<td><a href="deleteskill?id=${skillList1.skillId}">Delete</a></td>
					</tr>
				</c:forEach>
		
		</table>
	</div>
    </div>
	
		
	
	<center>
			<a href="addskill" class="btn btn-success btn-lg">Add Skill</a>
			<a href="managerHome" class="btn btn-info btn-lg">HOME</a>
	</center>
</body>


</html>
