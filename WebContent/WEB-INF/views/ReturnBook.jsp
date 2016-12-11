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
                        <h3 style="text-align:center">Issue Book </h3>
                    </div>
                    <div class="panel-body">
                        <form action='/LibrarySystem/searchBookDetail' method="post" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Issue Book By ISBN: </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData1">
                            	</div>
							</div>
							<!-- <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1"> </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData2">
                            	</div>
							</div>
							<div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1"> </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData3">
                            	</div>
							</div>
							<div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1"> </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData4">
                            	</div>
							</div>
							                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1"> </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData5">
                            	</div>
							</div>
							<div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1"> </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
							  		<input type="hidden" name="isbnData" id="isbnData6">
                            	</div>
							</div>
                                                        <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <label for="ex1"> </label>
                                    <input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
                                    <input type="hidden" name="isbnData" id="isbnData7">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <label for="ex1"> </label>
                                    <input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
                                    <input type="hidden" name="isbnData" id="isbnData8">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <label for="ex1"> </label>
                                    <input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
                                    <input type="hidden" name="isbnData" id="isbnData9">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                                    <label for="ex1"> </label>
                                    <input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
                                    <input type="hidden" name="isbnData" id="isbnData10">
                                </div>
                            </div> -->
							<br>
                            <div style="padding-left:40%">
                                <button type="button" class="btn btn-primary" id="returnBooks">Return Book</button>
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
	<script type="text/javascript">
		function editEnable(){
			alert("inside editEnable");
			document.getElementById("location").disabled = false;
			document.getElementById("numberOfCopies").disabled = false;
			document.getElementById("form1").hidden=true;
			document.getElementById("saveUpdateEnable").hidden=false;
		}
	</script>
	
	    <script type="text/javascript">
        $(document).ready(function() {
    	$("#returnBooks").click(function() {
        var idurl="";
        idurl += "&users[]="  + document.getElementById("isbnData1").value;
        for(var i=1; i<=10; i++){
            idurl += "&users[]="  + document.getElementById("isbnData" + i).value;
        }

        alert(idurl);
   		 });
		});

    </script>
	
	
</html>