<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>Group 23: User</title>
</head>
<body>
	
	    <div class="container" id="registration-form">
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
                        <a href="#">Home1</a>
                    </li>
                    <li>
                        <a href="#">Profile</a>
                    </li>
                    <li>
                        <a href="#">Signout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        
    </nav>
    </div>
        <div class="row" style="padding-top:200px">
        <div class="col-md-3">
		<div class="nav-side-menu" style="margin-left:0px;">
	    <div class="brand">Brand Logo</div>
	    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        	<div class="menu-list" >
  
            <ul id="menu-content" class="menu-content collapse out">
                <li>
                  <a href="#">
                  <i class="fa fa-dashboard fa-lg"></i> Dashboard
                  </a>
                </li>

				<li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Search Book
                  </a>
                  </li>
                  
                  <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Issue Book
                  </a>
                  </li>
                  
                  <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Return Book
                  </a>
                  </li>
                  
                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Manage Book <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <a href="" style="color:white"><li>Add Book</li></a>
                  <a href="" style="color:white"><li>Update Book</li></a>
                  <a href="" style="color:white"><li>Delete Book</li></a>
                </ul>
				
				<li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Profile
                  </a>
                  </li>
                  
                 <li>
                  <a href="#">
                  <i class="fa fa-user fa-lg"></i> Sign Out
                  </a>
                  </li>

            </ul>
     </div>
</div>
</div>
            <div class="col-md-6 col-md-offset-1">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        
                        <h3 style="text-align:center">Search Book Here</h3>
                    </div>
                    <div class="panel-body">
                       
                        <form id='form1' action='/login' class="form-horizontal">
                            
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Search Book By ISBN: </label>
							  		<input class="form-control" type="text" name="search" placeholder="Enter ISBN here" required />
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <button  class="btn btn-primary">Search Book</button>
                            </div>
                            
                        </form>
                    </div>
                    
                    </div>
                </div>
            </div>
        </div>  
	</body>
</html>