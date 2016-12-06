<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>LibraryManagement</title>
	<!-- core CSS -->
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrap" />
		<link href="${bootstrap}" rel="stylesheet">
    
    <spring:url value="/resources/css/font-awesome.min.css" var="font" />
		<link href="${font}" rel="stylesheet">
    
    <spring:url value="/resources/css/animate.min.css" var="animate" />
		<link href="${animate}" rel="stylesheet">
    
     <spring:url value="/resources/css/owl.carousel.css" var="carousel" />
		<link href="${carousel}" rel="stylesheet">
    
    <spring:url value="/resources/css/owl.transitions.css" var="transition" />
		<link href="${transition}" rel="stylesheet">
    
    <spring:url value="/resources/css/prettyPhoto.css" var="prettyPhoto" />
		<link href="${prettyPhoto}" rel="stylesheet">
    
    <spring:url value="/resources/css/main.css" var="main" />
		<link href="${main}" rel="stylesheet">
    
    <spring:url value="/resources/css/responsive.css" var="responsive" />
		<link href="${responsive}" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body id="home" class="homepage">


    <header id="top-header" class="navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <!-- responsive nav button -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- /responsive nav button -->
                    
                    <!-- logo -->
                    <!-- <div class="navbar-brand">
                        <a class="smooth-scroll" data-section="#home" href="#home" >
                            <img src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        </a>
                    </div> -->
                    <!-- /logo -->
                </div>

                <!-- main nav -->
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                    <div class="main-menu">
                    	<a href="<%=request.getContextPath() %>/welcome">Home</a>
                    </div>
                </nav>
                <!-- /main nav -->
                
            </div>
        </header>
	<div class="row" style="padding-top:120px; padding-bottom:50px">
		<div class="col-md-3"></div>
		<div class="col-md-7">
			<div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 style="text-align:center">Activate Your Account</h3>
                    </div>
                    <div class="panel-body">
                        <form action='/LibrarySystem/activate' method="post" class="form-horizontal">
                            <div class="row">
                            	<div class="col-md-1"></div>
                            	<div class="col-md-10">
                            		<label for="ex1">Enter Activation Record: </label>
							  		<input class="form-control" type="text" id="activate" name="activate" placeholder="Enter activation code here" required />
							  		<input type="hidden" name="email" id="email" value="${email}">
                            	</div>
							</div>
							<br>
                            <div style="padding-left:40%">
                                <button type="submit" class="btn btn-primary" id="getData">Activate Me</button>
                            </div>
                        </form>
                        
                    </div>
                    
                 </div>
		</div>
	</div>
    <footer id="footer" class="pull-bottom">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <p class="text-center">
                        @2017 Library Management System
                    </p>
                </div>
            </div>
        </div>
    </footer><!--/#footer-->
	<spring:url value="/resources/js/jquery.js" var="jqueryJs" />
	<script src="${jqueryJs}"></script>
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrap" />
	<script src="${bootstrap}"></script>
    <!-- <script src="js/jquery.js"></script> -->
    <!-- <script src="js/bootstrap.min.js"></script> -->
    <spring:url value="/resources/js/owl.carousel.min.js" var="carousel" />
	<script src="${carousel}"></script>
    <!-- <script src="js/owl.carousel.min.js"></script> -->
    <spring:url value="/resources/js/mousescroll.js" var="mousescroll" />
	<script src="${mousescroll}"></script>
    <!-- <script src="js/mousescroll.js"></script> -->
    <spring:url value="/resources/js/jquery.prettyPhoto.js" var="prettyPhoto" />
	<script src="${prettyPhoto}"></script>
    <!-- <script src="js/jquery.prettyPhoto.js"></script> -->
    <spring:url value="/resources/js/jquery.isotope.min.js" var="isotope" />
	<script src="${isotope}"></script>
    <!-- <script src="js/jquery.isotope.min.js"></script> -->
    <spring:url value="/resources/js/jquery.inview.min.js" var="inview" />
	<script src="${inview}"></script>
    <!-- <script src="js/jquery.inview.min.js"></script> -->
    <spring:url value="/resources/js/wow.min.js" var="wow" />
	<script src="${wow}"></script>
    <!-- <script src="js/wow.min.js"></script> -->
    <spring:url value="/resources/js/main.js" var="main" />
	<script src="${main}"></script>
    <!-- <script src="js/main.js"></script> -->
</body>
</html>