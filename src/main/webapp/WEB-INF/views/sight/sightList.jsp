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
								<a href="selectSight.kh?sno=${sightList.sNo }"  class="btn btn-primary">More</a>
							</div>
						</div>
					</div>
				</c:forEach>
				
			</div>
			<div id="buttons" style="text-align:center; padding-left:530px; line-height:100px;">
				<ul class="pagination">
				<c:if test="${pi.currentPage <= 1 }">
					[이전]&nbsp;
				</c:if> 
				<c:if test="${pi.currentPage >1 }">
					<c:url var="before" value="boardList.kh">
						<c:param name="page" value="${pi.currentPage -1 }"></c:param>
					</c:url>
					<a href="${before }">[이전]</a>&nbsp;
				</c:if> 
				<!-- 페이지 --> 
				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:url var="pagination" value="sightList.tpo">
						<c:param name="page" value="${p }"></c:param>
					</c:url>
					<c:if test="${p eq pi.currentPage }">
						<font color="red" size="4">[${p }]</font>
					</c:if>
					<c:if test="${p ne pi.currentPage }">
					<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
				</c:forEach>
				<!-- 다음 --> 
				<c:if test="${pi.currentPage >= pi.maxPage }">
					[다음]&nbsp;
				</c:if> 
				<c:if test="${pi.currentPage < pi.maxPage }">
				<c:url var="after" value="sightList.tpo">
					<c:param name="page" value="${pi.currentPage+1 }"></c:param>
				</c:url>
					<a href="${after }">[다음]</a>&nbsp;
				</c:if>
				</ul>
			</div>
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
	// 페이지 변수를 1로 초기화
	var page = 1;
	// 주차 여부
	function fnParking(){
		page = 
		var parking = $("input[name='parking']:checked");
		if(parking.length>0){
		parkingValue = page;
		console.log(parkingValue);
		}else{
		parkingValue = 0;
		}
		console.log(page);
		$.ajax({
			url:"sightChkList.tpo",
			type:"get",
			dataType: "json",
			data: {"parking":parkingValue,"babyCar":babyCarValue,"pet":petValue,"page":page},
			success: function(data){
				// 데이터목록 담는 변수  	
				response = data.sightList;
				// 페이징관련 데이터
				paging = data.pi;
				console.log(paging);
				// sight안의 값들 비워주기
				$(".row.sight").empty();
				// 리스트값이 하나도 없으면 span태그 띄우기
				if(response.length==0){
					$(".row.sight").append("<span>해당하는 장소가 없습니다.</span>");
				}else{
					// 리스트값을 하나씩 뿌려주고 사진이 있는지 없는지 여부
					successFunction(response);
					}
				//////////////////////////////여기가 페이징처리////////////////////////////////////
				$(".pagination").empty();
				// 페이지가 1이 아닌 경우 활성화
				if(paging.currentPage!=1){
					 $(".pagination").append("<li><a onclick='fnBefore(this)'>[이전]</a></li>&nbsp;");
				}else{
					 $(".pagination").append("<li><a>[이전]</a><li>&nbsp;");
				}
				// 시작페이지부터 종료페이지까지 반복
				for(var i=paging.startPage; i<=paging.endPage; i++ ){
					// 현재 페이지가 같으면 클릭 비활성화
					if(paging.currentPage == i){
						$(".pagination").append("<li><a color='red'>" + i +  "</a></li>");
					}else{
					// 현재 페이지랑 다르면 활성화버튼
						$(".pagination").append("<li><a onclick='fnParking()'>" + i +"</a></li>&nbsp;");
					}
				}
				// 전체 페이지 수가 현재페이지 수보다 작을 때
				if(paging.currentPage < paging.maxPage){
					// 다음페이지 버튼 활성화
					$(".pagination").append("<li><a>[다음]</a></li>&nbsp;");
				}else{
					$(".pagination").append("<li><a>[다음]</a></li>&nbsp;");
				}
				
				} // success 부분
			}) // ajax부분
		};
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
				// 데이터목록 담는 변수  	
				response = data.sightList;
				// 페이징관련 데이터
				paging = data.pi;
				// sight안의 값들 비워주기
				$(".row.sight").empty();
				if(response.length==0){
					$(".row.sight").append("<span style='color:red; size:16px'>해당하는 장소가 없습니다.</span>");
				}
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
			data: {"parking":parkingValue,"babyCar":babyCarValue,"pet":petValue,"page":page},
			success: function(data){
				console.log("들어오긴함?");
				$(".row.sight").empty();
					//successFunction(data);
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
 			else{
				$(".row.sight").append(
						 '<div class="col-4" style="margin-top:20px;">'
						 + '<div class="card">'
						 + '<img src="/resources/images/noimage.png" alt="" class="card-img-top" width="265.66" height="176.84" />'
						 + '<div class="card-body">'
						 + ' <h5 class="card-title">' + data[i].sName + '</h5>'
						 + '<a href="selectSight.kh?sno=' + data[i].sNo + '"class="btn btn-primary">More</a>'
						 + '</div></div></div>'
						) 	
			} 
		}
  	}
  	
  	$(".goBackPage").click(function(){
      	page = Number(paging.startPage) - 1;

       	pageFlag = 1;

       	$("상단 ajax를 함수로 만들어 재귀호출");

       	pageFlag = 0;

    });
//클릭된 페이지로 가기 이벤트
$(".goPage").click(function(){

	page = $(this).attr("data-page");

	pageFlag = 1;
	
	var chk = $("input:checkbox[name='parking']");
	console.log(chk);
	 fnBaby(chk);

     pageFlag = 0;

});
//다음페이지로 가기 클릭이벤트
$(".goNextPage").click(function(){

	page = Number(paging.endPage) + 1;

	pageFlag = 1;

      	$("상단 ajax를 함수로 만들어 재귀호출");

       	pageFlag = 0;

    });
</script>
</body>
</html>