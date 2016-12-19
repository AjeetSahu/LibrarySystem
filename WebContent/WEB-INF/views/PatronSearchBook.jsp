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
		
            <div class="col-md-7"  style="padding-top:120px;">
           <div class="row">
            <div class="col-md-1"></div>
            <label>Allocated Time: "${appTime}"</label><br>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 style="text-align:center">Search Book Here</h3>
                    </div>
                    <div class="panel-body">
                        <form id="myForm" action='/LibrarySystem/book/' onsubmit="func();" method="get" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Search Book By ISBN: </label>
							  		<input class="form-control" type="text" id="isbn" name="isbn" placeholder="Enter ISBN here" required />
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <input type="submit" class="btn btn-primary btn-lg" value="Search Book">
                            </div>
                           <!--  <div id="submitBtn" hidden="true">
                            	<input type="submit" class="btn btn-primary btn-lg" value="Submit">
                            </div> -->
                        </form>
                        
                    </div>
                    
                 </div>
                 </div>
                 <%--<div class="row">
                 <div id="tab" hidden=true>
                 <c:forEach var="entry" items="${book}">
					Name:  ${entry.author} <br/>
					Value: ${entry.value} <br/>
					</c:forEach>
                  <table class="table" border=2px id="tab1">
             <thead>
             	<th>Author</th>
             	<th>Title</th>
             	<th>Call Number</th>
             	<th>Publisher</th>
             	<th>Year of Publication</th>
             	<th>Cover Image</th>
             </thead>
             <tr>
             	
             </tr>
          		</table>
          		<button id="issueBook" class="btn btn-primary btn-lg">Issue</button>
          		<input type="submit" class="btn btn-danger btn-lg" value="Checkout">
         		</div>
         		<div class="col-md-1"></div>
           </div> --%>
           </div>  
           <div class="col-md-1"></div>          
       </div>
       
       </div>
       
       <script>
       	function func(){
       		document.getElementById('myForm').action = "/LibrarySystem/book/"+document.getElementById('isbn').value;
       		//alert(document.getElementById('myForm').action);
       	}
       </script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
	$("#issueBook").click(function(){
		var url = "/LibrarySystem/book/json/"+document.getElementById('isbn').value;
			
			//alert(document.getElementById("isbn"));
			//alert(url);
	        $.get(url, function(data, status){
	            //alert("hello");
				//alert(data);
				
				console.log(data);
				
				document.getElementById("tab").hidden=false;
				//var paramOne =<c:out value="${test}" />
				//alert("${test}");
			/*var table = document.getElementById("tab1");
			    var row = table.insertRow(-1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    var cell5 = row.insertCell(4);
			    var cell6 = row.insertCell(5);
	    
	    
	    
	    cell1.innerHTML = data.items[0].volumeInfo.authors.toString();
	    cell2.innerHTML = data.items[0].volumeInfo.title;
	    cell3.innerHTML = data.items[0].volumeInfo.publisher;
	    cell4.innerHTML = data.items[0].volumeInfo.publisher;
	    cell5.innerHTML = data.items[0].volumeInfo.publishedDate;
	    cell6.innerHTML = data.items[0].volumeInfo.imageLinks.thumbnail;
	    
	    document.getElementById("isbn").value = isbnVal;
	    document.getElementById("author").value = data.items[0].volumeInfo.authors.toString();
	    document.getElementById("title").value = data.items[0].volumeInfo.title;
	    document.getElementById("publisher").value = data.items[0].volumeInfo.publisher;
	    document.getElementById("yearOfPublication").value = data.items[0].volumeInfo.publishedDate;
	    document.getElementById("file").value = data.items[0].volumeInfo.imageLinks.thumbnail; */
	    
	        });
	    });
	
	</script>
	</body>
</html>