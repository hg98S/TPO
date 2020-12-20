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
<title>이것은 명소 상세 정보다 이말이야!</title>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />

<div id="content" class="col-md-8">
		<h2 id="contentTitle">명소 정보</h2>


		<div class="media">
			<div class="media-left media-middle">
				<a href="#"> <img class="media-object"
					src="${sight.sPicture}" alt="명소임ㅇㅇ아무튼명소">
				</a>
			</div>
			<div class="media-body">
				<h4 class="media-heading"><c:out value="${sight.sName }"/></h4>
				value="${sight.sIntroduce }"
			</div>
		</div>
		<div id="buttons">
			<button class="btn btn-primary btn-xs">메인페이지</button>
			
		</div>
	</div>
		
		



		<div id="buttons">
			<button class="btn btn-primary btn-xs">메인페이지</button>
			
		</div>
	</div>
	


	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />
</body>
</html>