<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=39e18fbed61f7ff631c9562c6207cdf1&libraries=services"></script>
<title>이것은 명소 상세 정보다 이말이야!</title>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />

	<!-- content -->
	<div id="content" class="col-md-8">
		<h2 id="contentTitle">명소 정보</h2>


		<div class="media">
			<div class="media-left media-middle">
				<a href="#"> <img class="media-object" src="${sight.sPicture}"  alt="명소임ㅇㅇ아무튼명소">
				</a>
			</div>
			<div class="media-body">
				<h4 class="media-heading">
					<c:out value="${sight.sName }" />
				</h4>
				<c:out value="${sight.sIntroduce }" />
			</div>
		</div>
		<div id="buttons">
			<button class="btn btn-primary btn-xs">메인페이지</button>
			<button onclick="writeForm()" id="writeReview" type="button" class="btn btn-info btn-xs">리뷰작성</button>

		</div>
	</div>
	
			
<script>
	function writeForm(){
		location.href="sightReviewWrieteForm.tpo?sNo=${sight.sNo}"
	}
	
	/* 지도 API*/
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level : 3
	// 지도의 확대 레벨
	};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					'${sight.sLocation}',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${sight.sName }</div>'
									});
							infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});
</script>
	


	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />
</body>
</html>