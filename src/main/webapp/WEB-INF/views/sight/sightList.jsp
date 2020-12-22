<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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


img {
	width:200px;
}
</style>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />


	<!-- left sidebar -->
	<section class="container">
	
	<div id="search" class="col-md-3">
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
	<h2 id="contentTitle">명소 리스트</h2>
	 <div class="container">
      <div class="row">
      <c:forEach items="${sList }" var="sightList">
        <div class="col-4">
          <div class="card">
          	<c:if test="${sightList.sPicture != null }">
          		<img src="${sightList.sPicture }" alt="" class="card-img-top" />
          	</c:if>
          	<c:if test="${sightList.sPicture == null }">
          		<img src="/resources/img/sitelogo.png" alt="" class="card-img-top" />
          	</c:if>
            <div class="card-body">
              <h5 class="card-title">${sightList.sName}</h5>
              <a href="javascript:location.href='selectSight.kh?sno=${sightList.sNo }'" class="btn btn-primary">
              <input type="hidden" id="sNo" value="${sightList.sNo }">More</a>
            </div>
          </div>
        </div>
        </c:forEach>
        
        </div>

		<div id="buttons">
			<button class="btn btn-primary btn-xs">메인페이지</button>
			
		</div>
	</div>
	
	
</section>
<script>
	function sightDetail(){
		var sNo = document.getElementById("sNo").value;
		var form=document.createElement("form");
		form.setAttribute("charset", "UTF-8");
        form.setAttribute("method", "post");  //Post 방식
        form.setAttribute("action", "selectSight.tpo"); //요청 보낼 주소
        
        var hidden = document.createElement("input");
        hidden.setAttribute("type", "hidden");
        hidden.setAttribute("sNo", sNo);
        form.appendChild(hidden);
  		document.body.appendChild(form);
  		
		form.submit();
	}
</script>


	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />

</body>
</html>