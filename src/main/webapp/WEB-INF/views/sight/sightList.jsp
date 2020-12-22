<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

img {
	width: 200px;
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

		<div id="search" class="col-md-3">
			<h3>명소검색</h3>

			<ul class="media-list">

				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>주차여부</b> <input type="checkbox" name="parking" value="1"
							onclick="fnParking(this)">
					</div>
				</li>

				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>유모차 여부</b> <input type="checkbox" name="baby" value="1"
							onclick="fnBaby(this)">
					</div>
				</li>

				<li class="media">
					<div class="media-left"></div>
					<div class="media-body">
						<b>애완동물 가능 여부</b> <input type="checkbox" name="pet" value="1"
							onclick="fnPet(this)">
					</div>
				</li>

				<!-- 			<li class="media">
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
			</li> -->
			</ul>
		</div>



		<!-- Content -->
		<h2 id="contentTitle">명소 리스트</h2>
		<div class="container">
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
								<a
									href="selectSight.kh?sno=${sightList.sNo }"
									class="btn btn-primary">More</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

<!-- 			<div id="buttons">
				<button class="btn btn-primary btn-xs">메인페이지</button>

			</div> -->
		</div>


	</section>
	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />

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
	// 주차, 유모차, 애완동물 선택 값
	var parkingValue =0;
	var babyCarValue =0;
	var petValue =0;
	
	// 주차 여부
	function fnParking(chk){
		var parking = $("input[name='parking']:checked");
		if(parking.length>0){
		parkingValue = chk.value;
		console.log(parkingValue);
		}else{
		parkingValue = 0;
		}
		$.ajax({
			url:"sightChkList.tpo",
			type:"get",
			dataType: "json",
			data: {"parking":parkingValue,"babyCar":babyCarValue,"pet":petValue},
			success: function(data){
					$(".row.sight").empty();
					successFunction(data);
			}
		});
	}
	// 유모차 여부
	function fnBaby(chk){
		var babyCar = $("input[name='baby']:checked");
		if(babyCar.length>0){
		babyCarValue = chk.value;
		console.log(babyCarValue);
		}else{
		babyCarValue = 0;
		}
		$.ajax({
			url:"sightChkList.tpo",
			type:"get",
			dataType: "json",
			data: {"parking":parkingValue,"babyCar":babyCarValue,"pet":petValue},
			success: function(data){
					$(".row.sight").empty();
					successFunction(data);
			}
		});
	}
	
	// 애완동물 가능 여부
		function fnPet(chk){
		var pet = $("input[name='pet']:checked");
		if(pet.length>0){
		petValue = chk.value;
		console.log(petValue);
		}else{
		petValue =0;
		}
		$.ajax({
			url:"sightChkList.tpo",
			type:"get",
			dataType: "json",
			data: {"parking":parkingValue,"babyCar":babyCarValue,"pet":petValue},
			success: function(data){
					$(".row.sight").empty();
					successFunction(data);
			}
		});
	}
	
 	function successFunction(data){
		for(var i=0; i<data.length; i++){
			if(data[i].sPicture != null){
			$(".row.sight").append(
			 '<div class="col-4" style="margin-top:20px;">'
			 + '<div class="card">'
			 + '<img src="' + data[i].sPicture + '" alt="" class="card-img-top" width="265.66" height="176.84"/>'
			 + '<div class="card-body">'
			 + '<h5 class="card-title">' + data[i].sName + '</h5>'
			 + '<a href="selectSight.kh?sno=' + data[i].sNo + '"class="btn btn-primary">More</a>'
			 + '</div></div></div>') 
			}
/* 			else{
				$(".row").append(
						 '<div class="col-4" style="margin-top:20px;">'
						 + '<div class="card">'
						 + '<img src="/resources/images/noimage.png" alt="" class="card-img-top" width="265.66" height="176.84" />'
						 + '<div class="card-body">'
						 + ' <h5 class="card-title">' + data[i].sName + '</h5>'
						 + '<a href="selectSight.kh?sno=' + data[i].sNo + '"class="btn btn-primary">More</a>'
						 + '</div></div></div>'
						) 	
			} */
		}
	} 
</script>

</body>
</html>