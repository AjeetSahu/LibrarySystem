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
                        <a href="#">Profile</a>
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
                    <a href="#">Dashboard</a>
                </li>
                <li>
                    <a href="#">Search Book</a>
                </li>
                <li>
                    <a href="#">Add Book</a>
                </li>
                <li>
                    <a href="#">Delete Book</a>
                </li>
                <li>
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="#">Sign Out</a>
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 style="text-align:center">Search Book Here</h3>
                    </div>
                    <div class="panel-body">
                        <form action='/LibrarySystem/searchBookDetail' method="post" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Search Book By ISBN: </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData">
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <button type="button" class="btn btn-primary" id="getData">Search Book</button>
                            </div>
                        </form>
                        
                    </div>
                    
                 </div>
                 </div>
                 <div class="row">
                 <div id="tab" hidden="true">
                 
          		<div class="col-md-6">
                    <label for="ex1">Author: </label>
		  			<input class="form-control" type="text" id="author" name="author" disabled/>
                </div>
          		<div class="col-md-6">
                    <label for="ex1">Title: </label>
		  			<input class="form-control" type="text" id="title" name="title" disabled/>
                </div> <br>
          		<div class="col-md-6">
                    <label for="ex1">Call Number: </label>
		  			<input class="form-control" type="text" id="callNumber" name="CallNumber" disabled/>
                </div>
          		<div class="col-md-6">
                    <label for="ex1">Publisher: </label>
		  			<input class="form-control" type="text" id="publisher" name="publisher" disabled/>
                </div> <br>
          		<div class="col-md-6">
                    <label for="ex1">Year Of Publication: </label>
		  			<input class="form-control" type="text" id="yearOfPublication" name="yearOfPublication" disabled/>
                </div>
          		<div class="col-md-6">
                    <label for="ex1">Cover Image: </label>
		  			<input class="form-control" type="text" id="coverImage" name="coverImage" disabled/>
                </div> <br>
          		<div class="col-md-6">
                    <label for="ex1">Location: </label>
		  			<input class="form-control" type="text" id="location" name="location" disabled/>
                </div>
          		<div class="col-md-6">
                    <label for="ex1">Number Of Copies: </label>
		  			<input class="form-control" type="text" id="numberOfCopies" name="numberOfCopies" disabled/>
                </div> <br>
         		</div>
         		<div class="col-md-1"></div>
           </div>
           </div>  
           <div class="col-md-1"></div>          
       </div>
       <div class="row"> 
       		<div class="col-md-2"></div>
       		<div class="col-md-7">
             <form id="form1" hidden=true;>
	            <div class="row">
		            <div style="padding-left:365px;">
		            	<input type="button" class="btn btn-primary" onclick="editEnable();"  value="Update">
		            	<input type="submit" class="btn btn-primary" value="Delete">
		            </div>
		            
	            </div>
            </form>
            <div style="padding-left:365px;" id="saveUpdateEnable" hidden=true>
            	<input type="button" class="btn btn-primary"  value="Save Update" >
            </div>
         </div>
         <div class="col-md-1"></div>
         </div>
                		
	
                </div>
            </div>
        </div>  
	</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
	$("#getData").click(function(){
			var isbnVal = document.getElementById('isbn').value;
			alert("isbnVal: "+isbnVal);
			var url = "https://www.googleapis.com/books/v1/volumes?q=isbn:8179923274";
			alert(url)
	        $.get(url, function(data, status){
	            alert("Data: " + JSON.stringify(data, null, 2) + "\nStatus: " + status);
				document.getElementById("getData").value = data;
				//alert("getData: "+document.getElementById("getData").value);
				document.getElementById("tab").hidden=false;
				document.getElementById("form1").hidden=false;
				document.getElementById("saveUpdateEnable").hidden=true;
				document.getElementById("author").value = data.items[0].volumeInfo.authors.toString();
				document.getElementById("title").value = data.items[0].volumeInfo.title;
				document.getElementById("publisher").value = data.items[0].volumeInfo.publisher;
				document.getElementById("location").value = data.items[0].volumeInfo.publisher;
				document.getElementById("yearOfPublication").value = data.items[0].volumeInfo.publishedDate;
				document.getElementById("coverImage").value = data.items[0].volumeInfo.imageLinks.thumbnail;
	        });
	    });
	
	</script>
	<script type="text/javascript">
		function editEnable(){
			alert("inside editEnable");
			document.getElementById("location").disabled = false;
			document.getElementById("numberOfCopies").disabled = false;
			document.getElementById("form1").hidden=true;
			document.getElementById("saveUpdateEnable").hidden=false;
		}
	</script>
</html>