<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>명소 리스트</title>
<style>
.contents {
	display: inline-block;
}

#search {
	margin-left: 10px;
	width: 100%;
	float: left;
}

#content {
	display: inline;
	width: 70%;
	float: right;
}
img {
	width:200px;
}

#bottons {
	
}
</style>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />


	<!-- left sidebar -->
	<section class="container">
	
	<div id="search" class="col-md-2">
		<h3>명소검색</h3>
		
		<ul class="media-list">

			<li class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
				<b>요금유무</b>
					<p>
					<input type="checkbox" name="fee" value="y">Yes
					</p>
					<p>
						<input type="checkbox" name="fee" value="n">No
					</p>
				</div>
			</li>
			<li class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
				<b>주차여부</b>
				<p>
					<input type="checkbox" name="parking" value="y">Yes
					</p>
					<p>
						<input type="checkbox" name="parking" value="n">No
					</p>
				</div>
			</li>

			<li class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
				<b>유모차 여부</b>
				<p>
					<input type="checkbox" name="baby" value="y">Yes
					</p>
					<p>
						<input type="checkbox" name="baby" value="n">No
					</p>
				</div>
			</li>

			<li class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
				<b>애완동물 가능 여부</b>
				<p>
					<input type="checkbox" name="pet" value="y">Yes
					</p>
					<p>
						<input type="checkbox" name="pet" value="n">No
					</p>
				</div>
			</li>

			<li class="media">
				<div class="media-left">
					
				</div>
				<div class="media-body">
				<b>화장실 유무</b>
				<p>
					<input type="checkbox" name="toilet" value="y">Yes
					</p>
					<p>
						<input type="checkbox" name="toilet" value="n">No
					</p>
				</div>
			</li>
		</ul>
	</div>
	
	
	
	<!-- Content -->
	
	<div id="content" class="col-md-8">
		<h2 id="contentTitle">명소 리스트</h2>


		<div class="media">
			<div class="media-left media-middle">
				<a href="#"> <img class="media-object"
					src="./resources/images/img_1.jpg" alt="명소임ㅇㅇ아무튼명소">
				</a>
			</div>
			<div class="media-body">
				<h4 class="media-heading">명소제목이 들어갈 공간</h4>
				명소 설명이 들어가야 할 공간으로써 api 에서 따와야하는디...
			</div>
		</div>



		<div id="buttons">
			<button class="btn btn-primary btn-xs">메인페이지</button>
			
		</div>
	</div>
	
	


</section>




	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />

</body>
</html>