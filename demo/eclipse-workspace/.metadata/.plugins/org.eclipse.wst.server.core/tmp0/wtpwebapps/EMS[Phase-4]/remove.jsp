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

function isVerify(){
	if (confirm('Are you sure you want to delete this employee?')) {
	    return true;
	} else {
	    return false;
	}	
}


</script>

</head>
<body>

	 <%@ page import="com.flp.ems.service.*" %>
		 <%@ page import="java.util.*" %>
	<%@ page import="org.springframework.web.context.WebApplicationContext"   %>
		<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
		
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
   <li ><a  href="add.jsp">Add Employee</a></li>
    <li><a  href="modify.jsp">Modify Employee</a></li>
    <li class="active"><a  href="#">Remove Employee</a></li>
    <li ><a  href="search.jsp">Search Employee</a></li>
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
	  <div class="row">
		<div class="col-md-4">
			<h4>Search an Employee</h4>
			
			<h4>by</h4>
			<form method="post" action="removeServlet"  onsubmit="return isVerify()">

						<div class="radio">
							<label><input type="radio" name="remove" value="kinId">kin Id</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="remove" value="name">name</label>
						</div>	
						<div class="radio">
							<label><input type="radio" name="remove" value="emailId">email Id</label>
						</div>
		  <div class="form-group">
			<input type="text" class="form-control" id="name" placeholder="Value" name="valueOfKey">
		  </div>
		  
		  
		  
		  
			
		</div>
		</div>
		<p>OR</p>
		<div class="row">
		<div class="col-md-8">
			
			
			<div class="form-group">
      <label for="sel1">Select an Employee from Summary :</label>
      <p>Kind ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	EMAIL ID	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	NAME	&nbsp;&nbsp;&nbsp;&nbsp;	ROLE		&nbsp;&nbsp;&nbsp;&nbsp;	DEPARTMENT		&nbsp;	&nbsp;&nbsp;&nbsp;	PROJECT</p>
      <select class="form-control" id="sel1" name="emailId">
        <% 
        HashMap<String, String> emp[];
		WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		EmployeeServiceImpl e=applicationContext.getBean("service",EmployeeServiceImpl.class);
	emp=e.getAllEmployee();
		
	
		for(HashMap<String,String> hm:emp){

       %>
        <option value='<%= hm.get("emailId")%>'><%= hm.get("kinId")%>&nbsp;&nbsp;&nbsp;<%=hm.get("emailId")%>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=hm.get("name")%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=hm.get("role")%>&nbsp;&nbsp;&nbsp;&nbsp;<%=hm.get("dept")%>&nbsp;&nbsp;&nbsp;&nbsp;<%=hm.get("project") %></option>

<%		}
 %>        
      </select>
      <br>
    </div>
			
			
			
			
		</div>
		
	  </div>
	  <div class="form-group">
			<input type="submit" class="form-control" value="Remove" id="submit">
		  </div>
		  
		</form>
	
	  
	  
    </div>
    
	
  </div>
</div>

</body>
</html>

