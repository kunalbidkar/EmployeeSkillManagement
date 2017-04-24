<!-- @Author:--Dnyaneshwar Rajput -->

<!DOCTYPE>
<html>
<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/includes.jsp"%>
<%-- 	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> --%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"
	charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>

<title>Employee Sign up</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css" type="text/css"></link>

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
<body style="background-color: #f6c870;">
	<!-- logout employee -->


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
		<P><b>Welcome : ${pageContext.request.userPrincipal.name}</b></P>
		<h2 align="right">
			<a href="javascript:formSubmit()" class="btn btn-danger" btn-lg"> Logout</a>
		</h2>
	</c:if>	
						<h1>Sign Up</h1>
												<hr>
  
  <form:form action="addEmployee" method='POST'
							modelAttribute='employee' class="form-horizontal">
    
    
    <div class="form-group">
      <form:input type="hidden" path="employeeId" id="empId" />
      <label class="control-label col-sm-2">First Name</label>
      <div class="col-sm-5">
        <form:input type='text' class="form-control" path='employeeFirstName' placeholder="Enter First Name"/>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Last Name:</label>
      <div class="col-sm-5">          
        <form:input type='text' path='employeeLastName' class="form-control" placeholder="Enter Last Name"/>
       </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Email</label>
      <div class="col-sm-5">          
        <form:input type='text' path='employeeEmail' class="form-control" placeholder="Enter Email"/>
       </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Mobile Number</label>
      <div class="col-sm-5">          
        <form:input type='number'  path='employeeMobNo' class="form-control" placeholder="Enter Mobile Number"/>
       </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Address</label>
      <div class="col-sm-5">          
        <form:input type='text' path='employeeAddress' class="form-control" placeholder="Enter Address"/>
       </div>
    </div>
    
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <label class="control-label col-sm-2">Gender</label>
        <div class="radio">
          <label><form:radiobutton path="employeeGender" value="Male"  checked="true" />Male</label>
          <label><form:radiobutton path="employeeGender" value="Female" />Female</label>
		</div>
      </div>
    </div>
    
    
    <div class="form-group">
      <label class="control-label col-sm-2">Date of Birth</label>
      <div class="col-sm-2">          
        <form:input type="date"  path='employeeDOB' placeholder="yyyy-mm-dd" class="form-control"/>
       </div>
    </div>
    
   
	<div class="form-group">
      <label class="control-label col-sm-2">Date of Joining</label>
      <div class="col-sm-2">          
        <form:input type="date"   path='employeeDOJ' placeholder="yyyy-mm-dd" class="form-control"/>
       </div>
    </div>							

    
       <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <label class="control-label col-sm-2">Status</label>
        <div class="radio">
          <label><form:radiobutton path="employeeStatus" value="Active" checked="true"/>Active</label>
          <label><form:radiobutton path="employeeStatus" value="Inactive" />Inactive</label>
		</div>
      </div>
    </div>
    
    
    
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <label class="control-label col-sm-2">Employee Role</label>
        <div class="radio">
          <label><form:radiobutton path="employeeRole" value="ROLE_EMPLOYEE" checked="true" />Employee</label>
          <label><form:radiobutton path="employeeRole" value="ROLE_MANAGER" />Manager</label>
          <label><form:radiobutton path="employeeRole" value="ROLE_ADMIN" />Admin</label>
		</div>
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2">Select Manager</label>
      <div class="col-sm-5">
      <form:select path="managerId" var="role" class="form-control">
       
        <c:forEach items="${listManagers}" var="manager">
        <option value="${manager.employeeId}">${manager.employeeFirstName} ${manager.employeeLastName}</option>
        
        </c:forEach>
      	</form:select>
      </div>
      </div>
    </br>
     <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success btn-lg">Submit</button>
        <button type="submit" class="btn btn-warning btn-lg">Reset</button>
        <a href="listEmployee" class="btn btn-info btn-lg">Back To Home</a>
      </div>
    </div>
   
 
 
 </form:form>
 

</body>
</html>