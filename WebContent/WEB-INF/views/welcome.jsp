<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>themeinthebox.com</title>
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
                        <ul id="nav" class="nav navbar-nav">
                            <li class="scroll"><a href="#home" data-section="#home">Home</a></li>
                            <li class="scroll"><a href="#about" data-section="#about">About</a></li>
                            <li class="scroll"><a href="#services" data-section="#services">Services</a></li>
                            <li class="scroll"><a href="#portfolio" data-section="#portfolio">Portfolio</a></li>
                            <li class="scroll"><a href="#contact-area" data-section="#contact-area">Contact</a></li>
                            <a href="<%=request.getContextPath() %>/registration">SignUp</a>
                            <a href="<%=request.getContextPath() %>/login">LogIn</a>
                        </ul>
                    </div>
                </nav>
                <!-- /main nav -->
                
            </div>
        </header>

    <section id="main-slider">
        <div class="owl-carousel">
            <div class="item" style="background-image: url(https://i.ytimg.com/vi/hDWbxhiSQ20/maxresdefault.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="carousel-content text-center">
                                    <h2>I have always imagined that Paradise will be a kind of library <span>Color</span>.</h2>
                                    <p>Any book that helps a child to form a habit of reading, to make reading one of his deep and continuing needs, is good for him.</p>
                                    <a class="btn btn-primary btn-lg" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
            <div class="item" style="background-image: url(https://images7.alphacoders.com/697/697523.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="carousel-content text-center">

                                    <h2>OUR MAIN GOAL IS CONTINUOUSLY SATISFY OUR <span>Clients</span></h2>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et  dolore magna incididunt ut labore aliqua. </p>
                                    <a class="btn btn-primary btn-lg" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
            <div class="item" style="background-image: url(http://blog.hdwallsource.com/wp-content/uploads/2016/03/girl-in-library-wallpaper-44311-45430-hd-wallpapers.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="carousel-content text-center">
                                    <h2>Accessible design is good design. Only with <span>Color</span>.</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et  dolore magna incididunt ut labore aliqua. </p>
                                    <a class="btn btn-primary btn-lg" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
            
        </div><!--/.owl-carousel-->
    </section><!--/#main-slider-->

    <section id="about">
        <div class="container">

            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">WELCOME TO OUR COMPANY</h2>
                <p class="text-center wow fadeInDown">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">
                

                <div class="col-sm-6 wow fadeInRight">
                    <h3 class="column-title">A Little More About Us</h3>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>

                    <p>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>

                    <a class="btn btn-primary" href="#">Discover Us</a>

                </div>
                <div class="col-sm-6 wow fadeInLeft">
                    <img class="img-responsive" src="https://static.pexels.com/photos/8700/wall-animal-dog-pet.jpg" alt="">
                </div>
            </div>
        </div>
    </section><!--/#about-->

    <section id="services" >
        <div class="container">

            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Our Services</h2>
                <p class="text-center wow fadeInDown">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="row">
                <div class="features">
                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-bicycle"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="100ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-cubes"></i>
                            </div>
                            <h3 class="features-title font-alt">SEO Services</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="200ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-connectdevelop"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="300ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa  fa-diamond"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="400ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-user-secret"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="500ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-key"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="600ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-laptop"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-3 col-lg-3 wow fadeInUp" data-wow-duration="300ms" data-wow-delay="700ms">
                        <div class="features-item">
                            <div class="features-icon">
                                <i class="fa fa-paw"></i>
                            </div>
                            <h3 class="features-title font-alt">Optimised for speed</h3>
                            Careful attention to detail and clean, well structured code ensures a smooth user experience for all your visitors.
                        </div>
                    </div>

                </div>
            </div><!--/.row-->    
        </div><!--/.container-->
    </section><!--/#services-->

    <section id="portfolio">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown">Our Works</h2>
                <p class="text-center wow fadeInDown">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut <br> et dolore magna aliqua. Ut enim ad minim veniam</p>
            </div>

            <div class="text-center">
                <ul class="portfolio-filter">
                    <li><a class="active" href="#" data-filter="*">All Works</a></li>
                    <li><a href="#" data-filter=".animation">Animation</a></li>
                    <li><a href="#" data-filter=".Business">Business</a></li>
                    <li><a href="#" data-filter=".art">Art</a></li>
                </ul><!--/#portfolio-filter-->
            </div>

            <div class="portfolio-items">
                <div class="portfolio-item animation">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 1</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">
                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->


                <div class="portfolio-item Business art">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 2</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpgg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">
                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->

                <div class="portfolio-item animation">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 3</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">

                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->

                <div class="portfolio-item Business">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 5</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">

                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->

                <div class="portfolio-item animation art">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 7</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">

                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->

                <div class="portfolio-item Business">
                    <div class="portfolio-item-inner">
                        <img class="img-responsive" src="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" alt="">
                        <div class="portfolio-info">
                            <h3>Portfolio Item 8</h3>
                            <a class="preview" href="http://www.planwallpaper.com/static/images/stunning-images-of-the-space.jpg" rel="prettyPhoto">
                                <img src="images/portfolio/expand.png" alt="">

                            </a>
                        </div>
                    </div>
                </div><!--/.portfolio-item-->
            </div>
        </div><!--/.container-->
    </section><!--/#portfolio-->

    <section id="contact-area">
        <div class="container">
            <div class="row">
                <div class="section-header">
                    <h2 class="section-title text-center wow fadeInDown animated" style="visibility: visible;">Send Message</h2>
                    <p class="text-center wow fadeInDown animated" style="visibility: visible;">Drop a line to us. Your word is most important to us.</p>
                </div>
                <form id="main-contact-form" name="contact-form" method="post" action="#">
                    <div class="col-lg-6 animated animate-from-left" style="opacity: 1; left: 0px;">

                        <div class="form-group">
                                <label for="name">Your Name (Required)</label>
                                <input id="name" type="text" name="name" class="form-control" placeholder="Name" required>
                            </div>
                        <div class="form-group">
                                <label for="email">Email Address</label>
                                <input type="email" id="email" name="email" class="form-control" placeholder="Email" required>
                            </div>
                        <div class="form-group">
                            <label for="subject">Subject</label>
                            <input type="text" id="subject" name="subject" class="form-control" placeholder="Subject" required>
                        </div>

                    </div>
                    <div class="col-lg-6 animated animate-from-right" style="opacity: 1; right: 0px;">
                        <div class="form-group">
                            <label for="message">Your Message</label>
                            <textarea name="message" id="message" class="form-control" rows="8" placeholder="Message" required></textarea>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="text-center">

                          <button type="submit" class="btn btn-primary btn-lg btn-send-msg">Send Message</button>

                    </div>

                </form>

            </div>
        </div>
    </section><!--/#bottom-->

    <footer id="footer">
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