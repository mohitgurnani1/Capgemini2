<!DOCTYPE html>
<html lang="en">
<head>
  <title>EMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>  
var request;  
function sendInfo()  
{  
//alert('Hi');	
var v=document.addEmp.dept.value;  
var url="project?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('project').innerHTML=val;  
}  
}  
  
</script>  




</head>
<body>

		 <%@ page import="com.flp.ems.service.*" %>
		 <%@ page import="java.util.*" %>
			
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
    <li class="active"><a  href="#">Add Employee</a></li>
    <li><a  href="modify.jsp">Modify Employee</a></li>
    <li><a  href="remove.jsp">Remove Employee</a></li>
    <li><a  href="search.jsp">Search Employee</a></li>
	<li><a  href="display.jsp">Display All Employees</a></li>
	
	
	
	</ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<div class="container">

<br>
<br>
<br>

    <div>
      
	  <br>
	  <br>
	  <h4>Enter your information</h4>
		
		<div class="row">
		<div class="col-md-6">
		<form name="addEmp" action="addServlet" method="post">
		  <div class="form-group">
			<label for="name">Name:</label>
			<input type="text" class="form-control" id="name" name="name">
		  </div>
		  <div class="form-group">
			<label for="phoneNo">Phone no:</label>
			<input type="text" class="form-control" id="phoneNo" name="phoneNo">
		  </div>
		  <div class="form-group">
			<label for="address">Address:</label>
			<input type="text" class="form-control" id="address" name="address">
		  </div>
		<div class="form-group">
			<label for="dob">Date of Birth:</label>
			<input type=date class="form-control" id="dob" name="dob">
		  </div>
		  		 
		 <div class="form-group">
			<label for="doj">Date of Joining:</label>
			<input type=date class="form-control" id="doj" name="doj">
		  </div>
		  </div>
		  <div class="col-md-6">
			  <div class="form-group">
						<label for="dept">Select Department:</label>
						<select class="form-control" id="dept" name="dept" onclick="sendInfo()">
   
				<%	EmployeeServiceImpl e=new EmployeeServiceImpl();
						HashMap<String,String> deptlist=e.getDepartmentList();
						Set set=deptlist.entrySet();
					
						for(Object dept:set)
						{
						Map.Entry<String, String> m=(Map.Entry<String, String>)dept;
						 
					%>  
					 <option value="<%=(String)m.getKey()%>"><%=(String)m.getValue()%></option>
					<%
						}
					%>
			
			</select>
			</div>
			
			 <div class="form-group">
						<label for="project">Select Projects:</label>
					  <select multiple class="form-control" id="project" name="project">
								 
					 
					  </select>
				</div>	  
			
			 <div class="form-group">
					<label for="role">Select Role:</label>
	<select class="form-control" id="role" name="role">
   				 
					 <%
	HashMap roleslist=e.getRolesList();
	
		Set set3=roleslist.entrySet();
		for(Object role:set3)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)role;
	

%>
					 
								 <option value="<%=(String)m.getKey()%>"><%=(String)m.getValue()%></option>
			
									

<%
		}
	
%>
</select>
			</div>


			
		  </div>
		 </div>
		 <center>
		  <button type="submit" class="btn btn-default">Submit</button>
		</center>
		<br>
		
		</form>
		<br>
		<br>
	
	</div>
    
	
	
	
  </div>
</div>

</body>
</html>

