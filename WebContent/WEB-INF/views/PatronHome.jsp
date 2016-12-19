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
                        <a href="<%=request.getContextPath() %>/patronHome">Home</a>
                    </li>
                    <li>
	                    <a href="<%=request.getContextPath() %>/cartCheckout">
	                        Check Cart: <span class="badge"></span>
	                    </a>
                	</li>
                    <li>
                        <a href="<%=request.getContextPath() %>/logout">Signout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
    </nav>
    	<div>
    		Welcome ${userName}
    	</div>
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
                    <a href="<%=request.getContextPath() %>/patronSearchBook">Issue Book</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath() %>/patronReturnSearch">Return Book</a>
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
		  
                     
       
	       		<div class="col-md-7">
	             <form id="form1" style="padding-top:100px;">
		            <div class="row" >
                        
                        <div class="col-md-6">
                        	
			  				<input class="form-control" type="text" id="title" name="title" value="${pattern}" placeholder="Enter Title Here" onchange="append();" required />
                        </div>
                        <div class="col-md-2">
                            <a id="link" href="<%=request.getContextPath() %>/searchBookByTitle/"><input type="button" class="btn btn-primary" value="Search Book" name="search" id="search"></a>
                        </div>    
					</div><br><br>
					</form>
					
							<div id="tab" class="table-responsive">
						        <table class="table table-striped">
						            <thead>
						            <tr>
						                <th>ISBN</th>
						                <th>Author</th>
						                <th>Title</th>
						                <th>Available Count</th>
						                <th>#</th>
						            </tr>
						            </thead>
						            <tbody>
							<c:forEach var="book" items="${books}">
							<tr>
								<td>${book.isbn}</td>
								<td>${book.author}</td>
								<td>${book.title}</td>
								<td>${book.availableCopies}</td>
								<c:choose> 
								  <c:when test="${book.availableCopies == 0}">
								  	<td><a href="<%=request.getContextPath() %>/requestBook/${book.isbn}"><button class="btn btn-danger btn-sm">Waitlist</button></a></td>
								  </c:when>
								  <c:otherwise>
								 	<td><a href="<%=request.getContextPath() %>/addToCart/${book.isbn}"><span class="glyphicon glyphicon-shopping-cart"></span></a></td>   
								  </c:otherwise>
								</c:choose>
							</tr>
							</c:forEach>
							</tbody>
				        </table>
				    </div>
				    </div>
				    <div class="col-md-2" style="padding-top:120px;">
				    <label>Allocated Time: "${appTime}"</label>
				    <form action="/LibrarySystem/setDateTime" onsubmit="getValue();" method = "post">
					    <input type="datetime-local" name="time" id="time">
					    <input type="hidden" name="appTime" id="appTime">
					    <input type="submit" value="Set Time" class="btn btn-danger">
				    </form>
				    </div>
				</div>
         
      </div>
      <script>
      function getValue(){
    	 // alert("here");
      	var d = document.getElementById("time").value;
        var time = (d+":00").replace("T", " ");
        document.getElementById("appTime").value = time; 
      }
      
      function append() {
          var link = document.getElementById('link');
          var text = document.getElementById('title');
          link.href = link.href + text.value;
          //document.getElementById("tab").hidden=false;
          /* link.text = text.value; */
      }
	</script>
	</body>
</html>