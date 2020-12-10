<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Traveler &mdash; Free Website Template, Free HTML5
	Template by FreeHTML5.co</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Free HTML5 Website Template by FreeHTML5.co" />
<meta name="keywords"
	content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
<meta name="author" content="FreeHTML5.co" />

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700"
	rel="stylesheet">

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Themify Icons-->
<link rel="stylesheet" href="css/themify-icons.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
   <script src="js/respond.min.js"></script>
   <![endif]-->
        <style>
            
            .sectionmain{
                
            }
                
            .main-side{
                width: 25%; height: 100%; float: left;
            }
            
            .main-right{
                width: 75%; height: 100%; float: left;
            }
            
            .search{
                background-color: Lightgray; padding-left: 6%; padding-top: 6%; width: 100%; padding-bottom: 3%;
                
                
            }
             .price-search{
                padding-left: 10%; padding-top: 6%; background-color: Lightgray; margin-top: 20px; width: 100%; height: 260px;
                                               
            }
            .name-search{
                padding-left: 10%; padding-top: 6%; background-color: Lightgray; width: 100%; float: left;

            }   
            
            .sortarea{
                background-color: Lightgray; width: 90%; margin-left: 5%; height: 60px; float: left; margin-bottom: 100px;
            }
            
            .restInfo-area{
                margin-top: 11.5%; width: 100%; height: 100%;
            }
            
            .restInfo{
                margin-top: 2%; margin-left: 5%; height: 260px; width: 90%;
                
            }
            
             .search-list{
                margin-top: 10%; margin-left: 1%; width: 100%; margin-bottom: 6%;
            }
            
            .location{
                margin-top: 5%; margin-bottom: 7%; background-color: white; width: 99%; height: 35px;
            }
            

            .sleep{
                width: 40px; margin-top: -50%; margin-left: 4%; margin-bottom: 7%; height: 0%; background-color: white;
            }
            
            
            .total{
                width: 100%; height: 95%; background-color: white; margin-top: 7%; padding-top: 8%;
                
            }
            
            .total-amount{   
                width: 38%; height: 100%; background-color: lightgray; margin-top: -5.5%; margin-bottom: -1%; padding-left: 6%;
                
            }
            
            .price{
                width: 150px;
            }
            
            .fonts{
                padding-top: 11%; float: right;
            }
            
            
        </style>
        
        
   </head>
   <body>
    
      
   <div class="gtco-loader"></div>
   
        <div id="page"></div>



	<!-- <div class="page-inner"> -->
<jsp:include page="/include/includeHeader.jsp" />
	<!--헤더 끝-->
	<!--section시작-->
	 <section class="gtco-container sectionmain" role="contentinfo" style="margin-top:920px;">
        <div class="section-container">
            <div class="section-main">
                <div class="main-side" style=" width: 25%; height: 100%; float: left;">
                    <div class="well well-lg search" style="background-color:#eeeeee; padding-left: 6%; padding-top: 6%; width: 100%; padding-bottom: 3%;">
                        <h3><b id="rs">숙소검색</b></h3>
                        <div class="search-list">
                            <b>목적지</b>
                             <input type="text" class="well well-sm location" style="margin-top: 5%; margin-bottom: 7%; background-color: white; width: 99%; height: 35px;">
                        </div>
                        <div class="search-list">
                            <b>숙박기간</b>
                            <input type="text" class="well well-sm sleep" style="width: 40px; margin-top: -50%; margin-left: 4%; margin-bottom: 7%; height: 0%; background-color: white;">
                            <b>박</b>
                            <input type="text" class="well well-sm sleep" style="width: 40px; margin-top: -50%; margin-left: 4%; margin-bottom: 7%; height: 0%; background-color: white;">
                            <b>일</b>
                           
                        </div>
                        <div>
                            <b>객실 및 인원</b>
                            <div class="well well-sm total" style=" width: 100%; height: 95%; background-color: white; margin-top: 7%; padding-top: 8%;">
                                <div class="well well-sm total-amount" style="background-color:#09c6ab; color: white; width: 38%; height: 100%; margin-top: -5.5%; margin-bottom: -1%; padding-left: 6%;">
                                    <b>객실수</b><br>
                                   <b>성인</b><br>
                                    <b>어린이</b><br>
                                </div>
                            </div>
                        </div>
                        <div class="search-list" style="margin-top: 10%; margin-left: 1%; width: 100%; margin-bottom: 6%;">
                            <button type="submit" class="btn btn-primary btn-sm" style="width: 220px; background-color:#09c6ab ">
                                검색
                            </button>
                        </div>
                    </div>
                    <div class="well well-lg search price-search" style="background-color:#eeeeee; padding-left: 10%; padding-top: 6%; margin-top: 20px; width: 100%; height: 260px;">
                        <h3><b id="rs">가격</b></h3>
                         <div class="search-list">
                            <b>최저금액</b>
                             <input type="text" class="well well-sm location price" style="width: 150px; background-color: white;">&nbsp; <div class="fonts" style="padding-top: 11%; float: right;"><b>원 부터</b></div>
                            <b>최저금액</b>
                             <input type="text" class="well well-sm location price" style="width: 150px; background-color: white;">&nbsp;<div class="fonts" style="padding-top: 11%; float: right;"><b>원 까지</b></div>
                        </div>
                    </div>
                    <div class="well well-lg search name-search" style="background-color: #eeeeee; padding-left: 10%; padding-top: 6%; width: 100%; float: left;">
                        <h3><b id="rs">숙소명</b></h3>
                             <input type="text" class="well location price" style="width: 210px; background-color: white;">&nbsp;
                        <button type="submit" class="btn btn-primary btn-xs" style="width: 100px; margin-left: 50%;">
                                검색
                        </button></div>
                    </div>
                </div>
                <div class="main-right" style="width: 75%; height: 100%; float: left;">
                    <div class="well well-lg search sortarea" style="background-color: #eeeeee; width: 90%; margin-left: 5%; height: 60px; float: left; margin-bottom: 100px;">
                    </div>
                    <div class=" restInfo-area" style=" margin-top: 11.5%; width: 100%; height: 100%;">
                    <div class="well well-lg search restInfo" style="background-color: #eeeeee;  margin-top: 2%; margin-left: 5%; height: 260px; width: 90%; "></div>                   
                    <div class="well well-lg search restInfo" style="background-color: #eeeeee;  margin-top: 2%; margin-left: 5%; height: 260px; width: 90%;"></div> 
                    <div class="well well-lg search restInfo" style="background-color: #eeeeee; margin-top: 2%; margin-left: 5%; height: 260px; width: 90%;"></div> 
                    </div>
                </div>
            </div>
    </section>
	<!--section 끝-->
<jsp:include page="/include/includeFooter.jsp" />
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Datepicker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

</body>
</html>
