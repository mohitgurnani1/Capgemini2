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
    <li><a  href="modify.jsp">Modify Employee</a></li>
    <li><a  href="remove.jsp">Remove Employee</a></li>
    <li class="active"><a  href="#">Search Employee</a></li>
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
      <h3>Search Employee</h3>
    
    <div class="row">
    <div class="col-md-2"></div>
    
 <div class="col-md-8">   
    	<form  method="post"  action="searchServlet">
		  
		  <div class="form-group">
			<label for="kin">kin Id:</label>
			<input type="text" class="form-control" id="kin" name="kinId">
		  </div>
		  
		  <p><small>OR/AND</small></p>
		  
		  <div class="form-group">
			<label for="emailId">Email Id:</label>
			<input type="email" class="form-control" id="emailId" name="emailId">
		  </div>
		  
		  <p><small>OR/AND</small></p>
		  
		  <div class="form-group">
			<label for="name">Name:</label>
			<input type="text" class="form-control" id="name" name="name">
		  </div>
		  
		  
		  <div class="form-group">
			<input type="submit" class="form-control" id="submit" value="Search">
		  </div>
		  
		</form>
	
	
	
	
	
	
	
	
	
	
	
	
	</div>
	
    </div>
    
    
    
    </div>
	
	
	
  </div>
</div>

</body>
</html>

