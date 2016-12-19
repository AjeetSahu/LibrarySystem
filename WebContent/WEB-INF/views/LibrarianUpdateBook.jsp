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
                        <a href="<%=request.getContextPath() %>/logout">SignOut</a>
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
                    <a href="<%=request.getContextPath() %>/newBook">Add Book - Google API</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/addNewBookManually">Add Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/deleteSearch">Delete Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/updateBook">Search/Update Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/logout">Signout</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

    </div>
    <!-- /#wrapper -->
</div>
		
            <div class="col-md-7"  style="padding-top:120px;">
            <div class="row">
            <div class="col-md-1"></div>
            <label>Allocated Time: "${appTime}"</label>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 style="text-align:center">Search Book To Update</h3>
                    </div>
                    <div class="panel-body">
                        <form id="myForm" action="" onsubmit="setUrl()" method="get" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Update Book By ISBN: </label>
							  		<input class="form-control" type="text" id="book" name="book" placeholder="Enter ISBN to update Book" required />
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <input type="submit" class="btn btn-primary" value="Get Book Details">
                            </div>
                        </form>
                        
                    </div>
                    
                 </div>
                 </div>
           </div>  
           <div class="col-md-1"></div>          
       </div>
       
      </div>
         
	</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
		function setUrl(){
			var url = "/LibrarySystem/book/update/"+document.getElementById("book").value;
			//alert(url);
			document.getElementById('myForm').action = url;
		}
	</script>
</html>