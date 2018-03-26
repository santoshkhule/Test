<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- application css files  -->
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/app.css">

<!-- application js files  -->
<script src="js/angular/angular.min.js"></script>
<script src="js/angular/angular-route.js"></script>
<script src="js/jquery/jquery.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/app.js"></script>

<title>Inter Glob App</title>
</head>
<body ng-app="interGlobApp">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
  			<div class="navbar-header">
    			<a class="navbar-brand" href="#">InterGlob</a>
  			</div>
  			<ul class="nav navbar-nav">
    			<li class="active"><a href="#!/task">Home</a></li>    
    			<li><a href="#">Test</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<div ng-view></div>	
	</div>
</body>
</html>