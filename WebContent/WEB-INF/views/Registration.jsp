<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<spring:url value="/resources/temp.css" var="temp" />
		<link href="${temp}" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script src="http://code.jquery.com/jquery-1.10.2.js"
			type="text/javascript"></script>
		<style type="text/css">
		@import "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css";
		@import "https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css";
		</style>
		<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title></title>
	</head>
	<body>
	    <div class="container">
        	<div class="row">
        	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
            	<h4 style="color:white; padding-top:6px; padding-left:20px;">Library Management System</h4>
            	
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Home</a>
                    </li>
                    <li>
                        <a href="#">SignIn</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>
    </div>
    </div>
    <div class="container" style="padding-top:120px">
       <div class="row"> 
       		<div class="col-md-3"></div>
	       		<div class="col-md-7">
	             
			  <label for="ex1">UNIVERSITYID: </label>
			  <input class="form-control" type="text" name="id" >
				<br>
			  <label for="ex1">Firstname: </label>
			  <input class="form-control" type="text" name="firstname" >
				<br>
			  <label for="ex1">Lastname: </label>
			  <input class="form-control" type="text" name="lastname" >
			  <br>
			  <label for="ex1">Email: </label>
			  <input class="form-control" type="text" name="title" >
			<br>
			  <label for="ex1">PASSWORD: </label>
			  <input class="form-control" type="text" name="title" >
		<br>
		
		
		<div style="padding-left:300px;">
			<input class="btn btn-primary btn-lg" type="submit" name="submit" value="  Register  ">
		</div>
	        </div>
         <div class="col-md-1"></div>
         </div>
                		
	
                </div> 
	</body>
</html>