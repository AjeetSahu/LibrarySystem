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
                        <a href="<%=request.getContextPath() %>/libraryHome">Home</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/libraryProfile">Profile</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/logout">Signout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>
    </div>
        <div class="row">
        <div class="col-md-3">
		

     <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Start Bootstrap
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/libraryHome">Dashboard</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/newBook">Search Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/addNewBookManually">Add Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/deleteSearch">Delete Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/libraryProfile">Profile</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/welcome">Sign Out</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

    </div>
    <!-- /#wrapper -->
</div>
		  
                     
       </div>
       <div class="row"> 
       		<div class="col-md-3"></div>
	       		<div class="col-md-6" style="padding-top:110px;">
	             <form action="/LibrarySystem/newBook" method="post" enctype="multipart/form-data"> 
			  <label for="ex1">ISBN: </label>
			  <input class="form-control" type="text" name="isbn" >
				<br>
			  <label for="ex1">Author: </label>
			  <input class="form-control" type="text" name="author" >
				<br>
			  <label for="ex1">Title: </label>
			  <input class="form-control" type="text" name="title" >
			  <br>
			  <label for="ex1">Publisher: </label>
			  <input class="form-control" type="text" name="publisher" >
			  <br>
			  <label for="ex1">Phone Number: </label>
			  <input class="form-control" type="text" name="phoneNumber" >
			  <br>
			  <label for="ex1">Year Of Publication: </label>
			  <input class="form-control" type="text" name="yearOfPublication" >
			  <br>
			  <label for="ex1">Location: </label>
			  <input class="form-control" type="text" name="location" >
			  <br>
			  <label for="ex1">Number Of Copies: </label>
			  <input class="form-control" type="text" name="numberOfCopies" >
			  <br>
			  <label for="ex1">Keywords </label>
			  <input class="form-control" type="text" name="keywords" >
			  <br>
			  <label for="ex1">Cover Image </label>
			  <input class="form-control" type="file" name="file" value="Upload" >
		<br>
		
		<div style="padding-left:300px;">
			<input class="btn btn-primary btn-lg" type="submit" name="submit" value="  Register  ">
		</div>
		</form>
	        </div>
         <div class="col-md-1"></div>
         </div>
                		
	
                </div>
	</body>
</html>