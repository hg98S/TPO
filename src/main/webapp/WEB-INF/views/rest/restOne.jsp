<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<!--
   Traveler by freehtml5.co
   Twitter: http://twitter.com/fh5co
   URL: http://freehtml5.co
-->
<html>
<head>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=39e18fbed61f7ff631c9562c6207cdf1"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />




</head>
<body>

	<div class="gtco-loader"></div>

	<div id="page"></div>


	<!-- <div class="page-inner"> -->
	<jsp:include page="/include/includeHeader.jsp" />
	<!--헤더 끝-->
	<!--section시작-->
	<section class="gtco-container sectionmain" role="contentinfo">
		<div class="section-container" style="margin-top: 950px;">

			<div class="infoArea" style="height: 270px; width: 100%;">
				<div class="well well-sm infoImage"
					style="width: 38%; height: 250px; float: left;">
					<c:if test="${rest.reImage ne '없음'}">
						<img src="${rest.reImage }" style="width: 100%; height: 230px;">
					</c:if>
					<c:if test="${rest.reImage eq '없음'}">
						<img src="resources/images/noimage.png"
							style="width: 100%; height: 310px; margin-top: -10%;">
					</c:if>
				</div>
				<div class="well well-sm  restName"
					style="width: 60%; background-color: #eeeeee; height: 250px; margin-left: 2%; float: left; padding-left: 35px; padding-top: 15px;">
					<b>${rest.reName }</b>
					<div style="margin-top: 10px; margin-left: 20px;">
						전화번호 : ${rest.rePhone } <br>홈페이지 : ${rest.reUrl } <br>주소
						: ${rest.reAddr } <br>주차유무 :
						<c:if test="${rest.pStatus eq 'Y'}">가능</c:if>
						<br> <br>
						<div class="btn btn-primary btn-sm"
							style="width: 220px; background-color: #09c6ab">
							<a href="#ex1" rel="modal:open" style="color: white;">지도보기</a>
						</div>
					</div>
				</div>

			</div>

			<div class="well well-sm restIntro"
				style="background-color: #eeeeee; width: 100%; padding-top: 15px; padding-bottom: 25px;">

				&nbsp;&nbsp;&nbsp;<b>숙소소개</b> <br>
				<div style="margin-left: 20px;">${rest.reInfo }</div>
			</div>
			<c:forEach items="${room }" var="room">
				<div class="roomsArea">
					<div class="well well-lg rooms"
						style="height: 270px; background-color: #09c6ab; margin-top: 2%;">
						<div class="roomsimage"
							style="height: 100%; width: 30%; float: left;">
							<%-- ${room.roImage } --%>
							<c:forTokens items="${room.roImage }" delims=","
								varStatus="status" var="image">
								<c:if test="${status.index eq 0}">
									<c:if test="${image ne '없음'}">
										<img src="${image }" style="height: 100%; width: 100%;">
									</c:if>
									<c:if test="${image eq '없음'}">

										<img src="resources/images/noimage.png"
											style="height: 100%; width: 100%;">
									</c:if>
								</c:if>
								<%-- <c:if test="${status.index eq 0}"> <img src="resources/images/noimage.png" style="height:100%; width:100%;"></c:if> --%>
							</c:forTokens>
						</div>
						<div class="well well-lg roomsInfo"
							style="width: 65%; height: 100%; float: left; margin-left: 5%; background-color: #eeeeee;">
							<b>${room.roName }</b>
							<div style="margin-left: 25px; margin-top: 10px;">
								체크인 : ${rest.checkIn }<br> 체크아웃 : ${rest.checkout }<br>
								요금 : ${room.roPrice }(1박 기준)
							</div>

						</div>
					</div>
				</div>
			</c:forEach>


			<!-- 지도 테스트 -->

			
			<!-- 모달 테스트 -->
			<div id="ex1" class="modal"
				style="position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%);">
				<div id="map" style="width: 500px; height: 400px;"></div>
				
				<a href="#" rel="modal:close">닫기</a>
			</div>


			<script>
				$('a[href="#ex7"]').click(function(event) {
					event.preventDefault();

					$(this).modal({
						fadeDuration : 250
					});
				});
				
			
				
			</script>
			
			<script>
//지도
var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(33.450701, 126.570667),
	level: 3
};

var map = new kakao.maps.Map(container, options);

</script>

			<jsp:include page="/include/includeFooter.jsp" />

		</div>

	</section>
</body>
</html>
