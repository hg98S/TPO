<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title>TPO</title>
<meta charset="UTF-8">
<style type="text/css">
.img-responsive {
    -webkit-transform:scale(1);
    -moz-transform:scale(1);
    -ms-transform:scale(1); 
    -o-transform:scale(1);  
    transform:scale(1);
    -webkit-transition:.3s;
    -moz-transition:.3s;
    -ms-transition:.3s;
    -o-transition:.3s;
    transition:.3s;
}
.img-responsive:hover {
    -webkit-transform:scale(1.1);
    -moz-transform:scale(1.05;
    -ms-transform:scale(1.05);   
    -o-transform:scale(1.05);
    transform:scale(1.05);
}
</style>
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
						<jsp:include page="common/seoul.html"></jsp:include>
					</div>
					<div id="city_busan" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_daegu" style="opacity:0;">
						- <jsp:include page="common/daegu.html"></jsp:include> 
					</div>
					<div id="city_incheon" style="opacity:0;">
						 <jsp:include page="common/incheon.html"></jsp:include> 
					</div>
					<div id="city_gwangju" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_daejeon" style="opacity:0;">
						 <jsp:include page="common/daejeon.html"></jsp:include> 
					</div>
					<div id="city_ulsan" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_sejong" style="opacity:0;">
						<jsp:include page="common/sejong.html"></jsp:include> 
					</div>
					<div id="city_gyeonggido" style="opacity:0;">
						<jsp:include page="common/gyeonggido.html"></jsp:include>
					</div>
					<div id="city_gangwon" style="opacity:0;">
						<jsp:include page="common/gangwon.html"></jsp:include> 
					</div>
					<div id="city_chungcheon1" style="opacity:0;">
					<%-- 	<jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_chungcheon2" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_jeonlabukdo" style="opacity:0;">
						 <jsp:include page="common/jeonlabukdo.html"></jsp:include> 
					</div>
					<div id="city_jeonlanamdo" style="opacity:0;">
						 <jsp:include page="common/jeonlanamdo.html"></jsp:include>
					</div>
					<div id="city_gyeongsang1" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_gyeongsang2" style="opacity:0;">
						<%-- <jsp:include page="common/gyeonggido.jsp"></jsp:include> --%>
					</div>
					<div id="city_jeju" style="opacity:0;">
						 <jsp:include page="common/jeju.html"></jsp:include>
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
						 <% int i =0; %>
				<c:forEach items="${sightList }" var="sightList">
					<!-- 명소이미지가 없는 건 스킵하고 있는것만 3번 돌게 함 -->
					<c:if test="${sightList.sPicture ne '없음'}">
					<% if(i < 3) { i++;  %>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<!-- 객실리스트를 돌면서 해당 숙소와 일치하는 정보를 가져옴 -->
						<!--  각 클래스명을 다르게해서 줘야함 -->
					<a href="${sightList.sPicture }" class="sight">
						<figure>
						<% if(i==0) { %>
						<div class="sight1">
							<img src="${sightList.sPicture}" alt="Image" class="img-responsive" style="width:346.66px; height:259.98px;">
						<!-- 해당 지역에 맞는 명소를 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						
								<!-- 여기서 명소 지역이 (" ")로 구분되어있어서 c:forTokens를 사용  -->

								<!-- 여기는 popup창에 나오는 사진 -->
									<a href="${sightList.sPicture }"></a>
						</div>
						<% }else if(i==1) { %>
						<div class="sight1">
							<img src="${sightList.sPicture}" alt="Image" class="img-responsive" style="width:346.66px; height:259.98px;">
						<!-- 해당 지역에 맞는 명소를 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						
								<!-- 여기서 명소 지역이 (" ")로 구분되어있어서 c:forTokens를 사용  -->

								<!-- 여기는 popup창에 나오는 사진 -->
									<a href="${sightList.sPicture }"></a>
						</div>
						<% }else{%>
						<div class="sight1">
							<img src="${sightList.sPicture}" alt="Image" class="img-responsive" style="width:346.66px; height:259.98px;">
						<!-- 해당 지역에 맞는 명소를 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						
								<!-- 여기서 명소 지역이 (" ")로 구분되어있어서 c:forTokens를 사용  -->

								<!-- 여기는 popup창에 나오는 사진 -->
									<a href="${sightList.sPicture }"></a>
						</div>
						<%};%>
						</figure>
							<div class="fh5co-text">
							<h2 style="text-align:center;">
							<c:choose>
							        <c:when test="${fn:length(sightList.sName) gt 14}">
							        <c:out value="${fn:substring(sightList.sName, 0, 13)}">...</c:out>
							        </c:when>
							        <c:otherwise>
							        <c:out value="${sightList.sName}"></c:out>
							        </c:otherwise>
							</c:choose>
							</h2>
								<p style="color:black;">
									<c:choose>
									        <c:when test="${fn:length(sightList.sLocation) gt 30}">
									        <c:out value="${fn:substring(sightList.sLocation, 0, 29)}">...</c:out>
									        </c:when>
									        <c:otherwise>
									        <c:out value="${sightList.sLocation }"></c:out>
									        </c:otherwise>
									</c:choose>
								</p>
								<p style="text-align:center">
									<a><span class="btn btn-primary">바로가기</span></a>
								</p>
							</div>
						</a>
					</div>
					<%};%>
					</c:if>
				</c:forEach> 
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

				<% int j =0; %>
				<c:forEach items="${restList }" var="restList">
					<!-- 숙소이미지가 없는 건 스킵하고 있는것만 3번 돌게 함 -->
					<c:if test="${restList.reImage ne '없음'}">
					<% if(j < 3) { j++;  %>
					<div class="col-lg-4 col-md-4 col-sm-6">
						<!-- 객실리스트를 돌면서 해당 숙소와 일치하는 정보를 가져옴 -->
						<!--  각 클래스명을 다르게해서 줘야함 -->
					<a href="${restList.reImage }" class="rest">
						<figure>
						<% if(j==0) { %>
						<div class="gallery1">
							<img src="${restList.reImage}" alt="Image" class="img-responsive">
						<!-- 해당 숙소에 맞는 객실을 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						<c:forEach var="roomList" items="${roomList }">
							<c:if test="${restList.reNo eq roomList.reNo }">
								<!-- 여기서 객실 사진이 (,)로 구분되어있어서 c:forTokens를 사용  -->
								<c:forTokens var="reImage" items="${roomList.roImage }" delims=",">
								<!-- 없는 사진은 가져오지도 마셈 -->
									<c:if test="${reImage ne '없음' }">
									<a href="${reImage }"></a>
									</c:if>
								</c:forTokens>
							</c:if>
						</c:forEach>
						</div>
						<% }else if(j==1) { %>
						<div class="gallery2">
							<img src="${restList.reImage}" alt="Image" class="img-responsive">
						<!-- 해당 숙소에 맞는 객실을 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						<c:forEach var="roomList" items="${roomList }">
							<c:if test="${restList.reNo eq roomList.reNo }">
								<!-- 여기서 객실 사진이 (,)로 구분되어있어서 c:forTokens를 사용  -->
								<c:forTokens var="reImage" items="${roomList.roImage }" delims=",">
								<!-- 없는 사진은 가져오지도 마셈 -->
									<c:if test="${reImage ne '없음' }">
									<a href="${reImage }"></a>
									</c:if>
								</c:forTokens>
							</c:if>
						</c:forEach>
						</div>
						<% }else{%>
						<div class="gallery3">
							<img src="${restList.reImage}" alt="Image" class="img-responsive">
						<!-- 해당 숙소에 맞는 객실을 찾는데, 이미지가 존재하는 것만 넣을거임 -->
						<c:forEach var="roomList" items="${roomList }">
							<c:if test="${restList.reNo eq roomList.reNo }">
								<!-- 여기서 객실 사진이 (,)로 구분되어있어서 c:forTokens를 사용  -->
								<c:forTokens var="reImage" items="${roomList.roImage }" delims=",">
								<!-- 없는 사진은 가져오지도 마셈 -->
									<c:if test="${reImage ne '없음' }">
									<a href="${reImage }"></a>
									</c:if>
								</c:forTokens>
							</c:if>
						</c:forEach>
						</div>
						<%};%>
						</figure>
							<div class="fh5co-text">
							<h2 style="text-align:center;">
							<c:choose>
							        <c:when test="${fn:length(restList.reName) gt 14}">
							        <c:out value="${fn:substring(restList.reName, 0, 13)}">...</c:out>
							        </c:when>
							        <c:otherwise>
							        <c:out value="${restList.reName}"></c:out>
							        </c:otherwise>
							</c:choose>
							</h2>
								<p style="color:black;">
									<c:choose>
									        <c:when test="${fn:length(restList.reInfo) gt 50}">
									        <c:out value="${fn:substring(restList.reInfo, 0, 49)}">...</c:out>
									        </c:when>
									        <c:otherwise>
									        <c:out value="${restList.reInfo }"></c:out>
									        </c:otherwise>
									</c:choose>
								</p>
								<p style="text-align:center">
								<c:if test="${restList.reUrl eq '준비중'}">
									<c:url var="roomDirect" value="restDetail.tpo">
										<c:param name="reNo" value="${restList.reNo }"></c:param>
									</c:url>
									<a style="cursor:hand;" href="${roomDirect }"><span class="btn btn-primary">상세 페이지</span></a>
								</c:if>
								<c:if test="${restList.reUrl ne '준비중'}">
									<a href="${restList.reUrl }"><span class="btn btn-primary">바로가기</span></a>
								</c:if>
								</p>
							</div>
						</a>
					</div>
					<%};%>
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
		$('.gallery1').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		});
		$('.gallery2').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		}); 
		$('.gallery3').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		}); 
		
		$('.sight1').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		});
		$('.sight2').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		}); 
		$('.sight3').each(function() { // the containers for all your galleries
		    $(this).magnificPopup({
		        delegate: 'a', // the selector for gallery item
		        type: 'image',
		        gallery: {
		          enabled:true
		        }
		    });
		});
	</script> 
</body>
</html>
