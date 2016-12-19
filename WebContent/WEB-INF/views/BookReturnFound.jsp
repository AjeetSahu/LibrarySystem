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
        <div class="col-md-2">
		

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/patronHome">Home</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/patronSearchBook">Search Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/">Already Issued Books</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/">Issue Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/">Return Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/patronProfile">Profile</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/welcome">Signout</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

    </div>
    <!-- /#wrapper -->
</div>
           <div class="col-md-5"  style="padding-top:120px;">
     	   		<img style="height:360px; width:400px;"alt="book-cover-image" src="https://images-na.ssl-images-amazon.com/images/I/51Dcweva%2BnL._SX323_BO1,204,203,200_.jpg">       
           </div>
            
			<div class="col-md-5">
			<label>Allocated Time: "${appTime}"</label>
            	 <form action="/LibrarySystem/checkout/return" method="post">
		            <div style="padding-top:120px;">
		            	<h3><mark>ISBN :</mark> <label>${book.isbn}</label></h3><br>
		            	<h3><mark>Author :</mark> <label>${book.author}</label></h3><br>
		            	<h3><mark>Title :</mark> <label>${book.title}</label></h3><br>
	            	 	<h3><mark>Publisher :</mark> <label>${book.publisher.publisher}</label></h3><br>
	            	 	<h3><mark>Year Of Publication :</mark> <label>${book.publisher.yearOfPublication}</label></h3><br>
	            	 	<input type="hidden" name="isbn" id="isbn" value="${book.isbn}" hidden=true>
	            	 	<input style="alighn:center" type="submit" value="Return Book" class="btn btn-primary btn-lg">
	                 </div>
				</form>
			</div>
            
           </div>  
                     
       </div>
       
       <
	</body>
</html>