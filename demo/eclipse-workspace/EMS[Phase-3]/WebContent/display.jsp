<!DOCTYPE html>
<html lang="en">
<head>
  <title>EMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>


<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">EMS</a>
    </div>
    <ul class="nav navbar-nav">
    <li ><a  href="add.jsp">Add Employee</a></li>
    <li ><a  href="modify.jsp">Modify Employee</a></li>
    <li ><a  href="remove.jsp">Remove Employee</a></li>
    <li ><a  href="search.jsp">Search Employee</a></li>
	<li class="active"><a  href="#">Display All Employees</a></li>
	
	
	
	
	
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
 
	 <%@ page import="com.flp.ems.service.*" %>
		 <%@ page import="java.util.*" %>

	
	<div>
      <h3>Display All Employee</h3>
    
     <table class="table">
    <thead>
      <tr>
        <th>Kin Id</th>
        <th>Email Id</th>
        <th>Name</th>
        <th>Role</th>
        <th>Department</th>
        <th>Project</th>
      </tr>
    </thead>
    <tbody>
      
      <%
	  	HashMap<String, String> emp[];
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		emp=e.getAllEmployee();
		
		
		for(HashMap<String,String> hm:emp){
		
      %>
      <tr>
        <td><%=hm.get("kinId")%></td>
        <td><%=hm.get("emailId") %></td>
      <td><%=hm.get("name") %>  </td>
      <td><%=hm.get("role") %></td>
      <td><%=hm.get("dept") %></td>
      <td><%=hm.get("project") %></td>
      
      </tr>
      <%
		}  
      %> 
       
       </tbody>
  </table>
    
    
    
    </div>
	
  </div>
</div>

</body>
</html>

