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
    <li class="active"><a  href="#">Modify Employee</a></li>
    <li ><a  href="remove.jsp">Remove Employee</a></li>
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
	  <h4>Enter email id of employee to be modified:</h4>
		<form  method="post"  action="modifyServlet">
		  <div class="form-group">
			<label for="emailId">Email Id:</label>
			<input type="email" class="form-control" id="emailId" name="email">
		  </div>
		  <div class="form-group">
			<input type="submit" class="form-control" id="submit">
		  </div>
		  
		</form>
		
		</div>
	</div>
	
	
	
	
	</div>
  

  </div>
</div>

</body>
</html>

