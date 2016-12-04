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
        <div class="row" style="padding-top:120px;">
            <div class="col-md-6 col-md-offset-2" style="position:fixed;">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 style="text-align:center">Login Here</h3>
                    </div>
                    <div class="panel-body">
                        <form action='/searchBookDetail' method="post" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
							  		<input class="form-control" type="email" id="email" name="email" placeholder="Enter Email here" required />
                            		<br><br>
							  		<input class="form-control" type="password" id="pwd" name="pwd" placeholder="Enter Password here" required />
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <button type="submit" class="btn btn-primary" >Login</button>
                            </div>
                            <div class="pull-right">
                            <a href="#">New User? Register Here</a>
                            </div>
                        </form>
                        
                    </div>
                    
                 </div>
                 
           </div>            
       </div>
	</div>
	</body>
	
</html>