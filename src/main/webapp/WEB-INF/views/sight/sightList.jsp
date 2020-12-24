<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>명소 리스트</title>
<style>
/* .contents {
	display: inline-block;
}

#bottons {
	
} */
#search {
	margin-left: 10px;
	width: 20%;
}

#content {
	width: 70%;
}
.card-img-top {
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	-o-transform: scale(1);
	transform: scale(1);
	-webkit-transition: .3s;
	-moz-transition: .3s;
	-ms-transition: .3s;
	-o-transition: .3s;
	transition: .3s;
}

.card-img-top:hover {
	-webkit-transform: scale(1.1);
	-moz-transform: scale(1.05;
	-ms-transform: scale(1.05);
	-o-transform: scale(1.05);
	transform: scale(1.05);
}

</style>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />

	<div id="page"></div>
	<!-- left sidebar -->
	<section class="container" style="margin-top: 50px;">
	<form action="sightChkList.tpo" method="get">
		<div id="search" class="col-md-3">
			<h3>명소검색</h3>
			<ul class="media-list">
				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>주차여부</b> <input type="checkbox" name="parking" value="1" <c:if test="${chkValue.parking ne 0 }">checked</c:if>>
					</div>
				</li>

				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>유모차 여부</b> <input type="checkbox" name="baby" value="1" <c:if test="${chkValue.babyCar ne 0 }">checked</c:if>>
					</div>
				</li>

				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>애완동물 가능 여부</b> <input type="checkbox" name="pet" value="1" <c:if test="${chkValue.pet ne 0 }">checked</c:if>>
					</div>
				</li>
				<li>
					<input class="btn btn-primary" type="submit" value="검색" style="background:#1AAB8A; color:#fff; border:none;"/>
				</li>
			</ul>
		</div>



		<!-- Content -->
		<h2 id="contentTitle">명소 리스트</h2>
		<div class="container">
			<if test="${fn:length(sList) > 0}">
			<div class="row sight">
				<c:forEach items="${sList }" var="sightList" varStatus="index">
					<div class="col-4" style="margin-top: 20px;">
						<div class="card">
							<c:if test="${sightList.sPicture != null }">
								<img src="${sightList.sPicture }" alt="" class="card-img-top"
									width="265.66" height="176.84" />
							</c:if>
							<c:if test="${sightList.sPicture == null }">
								<img src="/resources/images/noimage.png" alt=""
									class="card-img-top" width="265.66" height="176.84" />
							</c:if>
							<div class="card-body">
								<h5 class="card-title">${sightList.sName}</h5>
								<a href="selectSight.tpo?sno=${sightList.sNo }"  class="btn btn-primary">More</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- 페이징 처리 -->
			<div id="buttons" style="text-align:center; padding-left:250px; line-height:300px;">
				<ul class="pagination">
				<c:if test="${pi.currentPage <= 1 }">
					<li><a>이전&nbsp;</a></li>
				</c:if> 
				<c:if test="${pi.currentPage >1 }">
					<c:url var="before" value="sightChkList.tpo">
						<c:param name="page" value="${pi.currentPage -1 }"></c:param>
						<c:param name="parking" value="${chkValue.parking }"></c:param>
						<c:param name="baby" value="${chkValue.babyCar }"></c:param>
						<c:param name="pet" value="${chkValue.pet }"></c:param>
					</c:url>
					<li><a href="${before }">이전</a></li>&nbsp;
				</c:if> 
				<!-- 페이지 --> 
				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:url var="pagination" value="sightChkList.tpo">
						<c:param name="page" value="${p }"></c:param>
						<c:param name="parking" value="${chkValue.parking }"></c:param>
						<c:param name="baby" value="${chkValue.babyCar }"></c:param>
						<c:param name="pet" value="${chkValue.pet }"></c:param>
					</c:url>
					<c:if test="${p eq pi.currentPage }">
						<li><a href="" style="color:red; bold:500;">${p }</a></li>
					</c:if>
					<c:if test="${p ne pi.currentPage }">
					<li><a href="${pagination }">${p }</a></li>&nbsp;
					</c:if>
				</c:forEach>
				<!-- 다음 --> 
				<c:if test="${pi.currentPage >= pi.maxPage }">
					<li>다음</li>&nbsp;
				</c:if> 
				<c:if test="${pi.currentPage < pi.maxPage }">
				<c:url var="after" value="sightChkList.tpo">
					<c:param name="page" value="${pi.currentPage+1 }"></c:param>
					<c:param name="parking" value="${chkValue.parking }"></c:param>
					<c:param name="baby" value="${chkValue.babyCar }"></c:param>
					<c:param name="pet" value="${chkValue.pet }"></c:param>
				</c:url>
					<li><a href="${after }">다음</a></li>&nbsp;
				</c:if>
				</ul>
			</div>
			</if>
			<c:if test="${fn:length(sList) == 0}">
				<span>데이터 X</span>
			</c:if>
		</div>
		</form>
	</section>
	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />

</body>
</html>