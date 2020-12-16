<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
					<div id="city_busan" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_daegu" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_incheon" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_gwangju" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_daejeon" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_ulsan" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_sejong" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_gyeonggido" style="display:none;">
						<jsp:include page="common/gyeonggido.jsp"></jsp:include>
					</div>
					<div id="city_gangwon" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_chungcheon1" style="display:none;">
					<%-- 	<jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_chungcheon2" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_jeonla1" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_jeonla2" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_gyeongsang1" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_gyeongsang2" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_jeju" style="display:none;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
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
						<a href="#" class="fh5co-card-item image-popup">
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
						<a href="#" class="fh5co-card-item image-popup">
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
						<a href="#" class="fh5co-card-item image-popup">
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

				<% int i =0; %>
				<c:forEach items="${restList }" var="restList">
					<!-- 숙소이미지가 없는 건 스킵하고 있는것만 3번 돌게 함 -->
					<c:if test="${restList.reImage ne '없음'}">
					<% if(i !=3) { i++; %>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<!-- 객실리스트를 돌면서 해당 숙소와 일치하는 정보를 가져옴 -->
						<c:forEach var="roomList" items="${roomList }">
							<c:if test="${restList.reNo eq roomList.reNo }">
								<!-- 여기서 room정보를 넣어야함  -->
								<c:forTokens var="reImage" items="${roomList.roImage }" delims=",">
								<!-- 없는 사진은 가져오지도 마셈 -->
									<c:if test="${reImage ne '없음' }">
									<a href="${reImage }" class="fh5co-card-item image-popup" style="display:none"></a>
									</c:if>
								</c:forTokens>
							</c:if>
						</c:forEach>
						 <a href="#" class="fh5co-card-item image-popup">
							<figure>
								<div class="overlay">
									<i class="ti-plus"></i>
								</div>
								<img src="${restList.reImage}" alt="Image"
									class="img-responsive">
							</figure>
							<div class="fh5co-text">
							<h2>
							<c:choose>
							        <c:when test="${fn:length(restList.reName) gt 14}">
							        <c:out value="${fn:substring(restList.reName, 0, 13)}">...</c:out>
							        </c:when>
							        <c:otherwise>
							        <c:out value="${restList.reName}"></c:out>
							        </c:otherwise>
							</c:choose>
							</h2>
								<p>
									<c:choose>
									        <c:when test="${fn:length(restList.reInfo) gt 35}">
									        <c:out value="${fn:substring(restList.reInfo, 0, 34)}">...</c:out>
									        </c:when>
									        <c:otherwise>
									        <c:out value="${restList.reInfo }"></c:out>
									        </c:otherwise>
									</c:choose>
								</p>
								<p>
									<span class="btn btn-primary">Schedule a Trip</span>
								</p>
							</div>
						</a>
					</div>
					<% }else{ %>
					<% break; } %>
					</c:if>
				</c:forEach>

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
