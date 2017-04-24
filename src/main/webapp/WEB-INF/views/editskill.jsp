<!-- @Author:--Dnyaneshwar Rajput -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
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
<title>Add Skill</title>

</head>
<body style="background-color: #FAEBD7;">




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
			<h2><p align="center"><b>Update New Skill</b></p></h2>
			<hr>
			</br>
			</br>
			</br>
	
		
<form:form action="editsave" method='POST' style="text-align: center;" class="form-horizontal">
    
    
    <div class="form-group" >
     
      <label class="control-label col-sm-2">Update Skill</label>
      <div class="col-sm-4">
    	
        <form:input type='text' class="form-control" path='skillName' placeholder="Enter Skill Name"/></br> </br>
        <input type="submit" value="Save" class="btn btn-success btn-lg"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="managerHome" class="btn btn-info btn-lg">HOME</a>
      </div>
    </div>
  				</form:form>


  
</body>
</html>
