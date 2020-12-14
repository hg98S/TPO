<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>TPO</title>
<meta charset="UTF-8">
</head>
<body>
	<!-- 헤더 시작 -->
	<jsp:include page="/include/includeHeader.jsp"></jsp:include>
	<!-- 헤더 끝 -->
	
	<!-- 메인 내용 시작 -->
	<div class="gtco-section">
		<div class="gtco-container">
		<!-- 지도가 표시되는 곳 -->
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2>ISSUE</h2>
					<p>쿨럭.. 나 코로나 아니야..</p>
				</div>
			</div>
			<div class="row">
				<!-- 시도별 지도 -->
				<div class="urban col-lg-6 col-md-4 col-sm-6" style="margin-left: -100px;">
					<div id="ubanMap">
						<jsp:include page="common/urbanMap.jsp"></jsp:include>
					</div>
				</div>
				<!-- 행정구역별 지도(서울) -->
				<div class="city col-lg-6 col-md-4 col-sm-6">
					<div id="city_seoul">
						<jsp:include page="common/seoul.jsp"></jsp:include>
					</div>
				</div>
				<!-- 명소가 표시되는 곳 -->	
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<br>
						<h2>Most Popular Attraction</h2>
						<p>여기가 9시 되면 배가 끊긴다며?</p>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_1.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_1.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>New York, USA</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_2.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_2.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>Seoul, South Korea</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_3.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_3.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>Paris, France</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>
				</div>
				<hr>
				<!-- 숙소가 표시되는 곳 -->
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
						<h2>Most Popular Room</h2>
						<p>손만 잡고 잘래?</p>
					</div>
				</div>
				<div class="row">

					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_4.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_4.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>Sydney, Australia</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_5.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_5.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>Greece, Europe</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>

					<div class="col-lg-4 col-md-4 col-sm-6">
						<a href="resources/images/img_6.jpg"
							class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="resources/images/img_6.jpg" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
								<h2>Spain, Europe</h2>
								<p>Far far away, behind the word mountains, far from the
									countries Vokalia..</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>

				</div>
			</div>
		</div>
		</div>
	<!-- 메인 내용 끝 -->
	
	<!-- 푸터 시작 -->
	<jsp:include page="/include/includeFooter.jsp"></jsp:include>
	<!-- 푸터 끝 -->
	
	<!-- script -->
	<script>
		
	</script>
</body>
</html>
