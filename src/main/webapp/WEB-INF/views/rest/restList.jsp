<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">

<!-- restPage.css -->
<link rel="stylesheet" href="resources/css/restPage.css">
</head>
<body>


	<div class="gtco-loader"></div>

	<div id="page"></div>


	<!-- <div class="page-inner"> -->
	<jsp:include page="/include/includeHeader.jsp" />
	<!--헤더 끝-->
	<!--section시작-->
	<section class="gtco-container sectionmain" role="contentinfo">
		<div class="section-container" style="margin-top: 1050px;">
			<div class="section-main">
				<div class="main-side"
					style="width: 25%; height: 100%; float: left;">

					<div class="well well-lg search"
						style="background-color: #eeeeee; padding-left: 6%; padding-top: 6%; width: 100%; padding-bottom: 3%;">
						<form action="searchAllList.tpo" method="get">
							<h3>
								<b id="rs">숙소검색</b>
							</h3>
							<div class="search-list">
								<b>목적지</b> <input type="text" class="well well-sm location"
									name="location" id="location" value="${search.location }"
									style="margin-top: 5%; margin-bottom: 7%; background-color: white; width: 99%; height: 35px;">
							</div>
							<div class="search-list">
								<b>숙박기간</b> <input type="text" class="well well-sm sleep"
									name="sleep" value="${search.sleep }"
									style="width: 40px; margin-top: -50%; margin-left: 4%; margin-bottom: 7%; height: 0%; background-color: white;">
								<b>박</b> <input type="text" class="well well-sm sleep"
									style="width: 40px; margin-top: -50%; margin-left: 4%; margin-bottom: 7%; height: 0%; background-color: white;">
								<b>일</b>

							</div>
							<b>객실 및 인원</b>
							<div class="well well-sm total"
								style="width: 100%; height: 130px; background-color: white; margin-top: 7%;">
								<div class="total-amount"
									style="background-color: #09c6ab; color: white; width: 38%; height: 100%; margin-bottom: -1%; padding-top: 3%; padding-left: 6%; border-radius: 4px; float: left; line-height: 2;">
									<b>객실수</b><br> <b>성인</b><br> <b>어린이</b><br>
								</div>
								<div
									style="width: 60%; height: 100%; float: left; margin-bottom: -1%; padding-left: 6%;">
									<div id="roomCount">
										<button type="button" class="updown" id="rPlus" value=" + "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">+</button>
										<input type="text" id="rAmount" class="amount" name="rAmount"
											value="1" size="2"
											style="border-style: none; padding-left: 15px; border-style: none; padding-left: 14px; margin-left: 1px;">
										<button type="button" class="updown" id="rminus" value=" - "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">-</button>
									</div>
									<div id="adultCount" style="margin-top: 10px;">
										<button type="button" class="updown" id="aPlus" value=" + "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">+</button>
										<input type="text" id="aAmount" class="amount" name="aAmount"
											value="1" size="2"
											style="border-style: none; padding-left: 15px;">
										<button type="button" class="updown" id="aminus" value=" - "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">-</button>
									</div>
									<div id="kidAmount" style="margin-top: 10px;">
										<button type="button" class="updown" id="kPlus" value=" + "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">+</button>
										<input type="text" id="kAmount" class="amount" name="kAmount"
											value="1" size="2"
											style="border-style: none; padding-left: 15px;">
										<button type="button" class="updown" id="kminus" value=" - "
											style="width: 30px; border-style: none; background-color: #00a38d; color: white">-</button>
									</div>
								</div>
							</div>
							<div class="search-list"
								style="margin-top: 10%; margin-left: 1%; width: 100%; margin-bottom: 6%;">
								<button type="submit" class="btn btn-primary btn-sm"
									style="width: 220px; background-color: #09c6ab">검색</button>
							</div>
						</form>
					</div>

					<div class="well well-lg search price-search"
						style="background-color: #eeeeee; padding-left: 10%; padding-top: 6%; margin-top: 20px; width: 100%; height: 260px;">

						<h3>
							<b id="rs">가격</b>
						</h3>
						<div class="search-list">
							<form action="rPriceSearch.tpo" method="get">
								<b>최저금액 </b><br> <input type="text"
									class="well well-sm location"
									style="margin-top: 5%; margin-bottom: 7%; background-color: white; width: 65%; height: 35px;"
									name="minPrice" value="${search.minPrice}" id="min"> 원
								부터<br> <b>최고금액 </b><br> <input type="text"
									class="well well-sm location"
									style="margin-top: 5%; margin-bottom: 7%; background-color: white; width: 65%; height: 35px;"
									name="maxPrice" value="${ search.maxPrice}" id="max"> 원
								까지
							</form>
						</div>
					</div>
					<div class="well well-lg search name-search"
						style="background-color: #eeeeee; padding-left: 10%; padding-top: 6%; width: 100%; float: left;">
						<form action="rNameSearch.tpo" method="get">
							<h3>
								<b id="rs">숙소명</b>
							</h3>
							<input type="text" class="well well-sm location"
								name="searchName"
								style="margin-top: 5%; margin-bottom: 7%; background-color: white; width: 99%; height: 35px;">&nbsp;
							<button type="submit" class="btn btn-primary btn-xs"
								style="width: 100px; margin-left: 50%;">검색</button>
						</form>
					</div>
				</div>
			</div>
			<div class="main-right"
				style="width: 75%; height: 100%; float: left;">
				<div class="well well-sm search sortarea"
					style="background-color: #eeeeee; width: 100%; height: 60px; margin-left: 5%; float: left;">
					<a href="alignList.tpo?alignList=Name" value="alignName">이름</a> | <a
						href="alignList.tpo?alignList=Price" value="alignPrice">요금</a> | <a
						href="alignList.tpo?alignList=Click" value="alignClick">최다클릭</a> |
				</div>
				<div class=" restInfo-area"
					style="width: 100%; height: 100%; margin-top: 10%;">
					<c:forEach items="${rList }" var="rest">
						<input type="hidden" value="${rest.reNo}">
						<a href="restDetail.tpo?reNo=${rest.reNo}">
							<div class="well well-lg search restInfo"
								style="background-color: #eeeeee; margin-top: 2%; margin-left: 5%; height: 260px; width: 100%; color: black">
								<c:if test="${rest.reImage eq '없음'}">
									<div style="float: left">
										<img src="resources/images/noimage.png"
											style="width: 270px; height: 230px;" />
									</div>
									<div style="float: left; margin-left: 15px;">
										<b>${rest.reName }</b> <br> <b>전화번호 :</b> ${rest.rePhone }
										<br> <b>상세주소 :</b> <br> ${rest.reAddr } <br>
										<c:if test="${rest.sumPrice ne 0 }">
											<b>최저금액 :</b>
											${rest.sumPrice }
									</c:if>
									</div>

								</c:if>
								<c:if test="${rest.reImage ne '없음'}">
									<div style="float: left">
										<img src="${rest.reImage }"
											style="width: 270px; height: 210px;" />
									</div>
									<div style="float: left; margin-left: 15px;">
										<b>${rest.reName }</b>
										<c:url var="restDetail" value="restDetail.tpo">
											<c:param name="reName" value="${rest.reName }"></c:param>
											<c:param name="page" value="${pi.currentPage }"></c:param>
										</c:url>
										<br> <b>전화번호 :</b> ${rest.rePhone } <br> <b>상세주소
											: </b> <br> ${rest.reAddr } <br>
										<c:if test="${rest.sumPrice ne 0 }">
											<b>최저금액 :</b>
											 ${rest.sumPrice }
									</c:if>
									</div>
								</c:if>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>

			<div class="pageDiv">
				
				<div class="pagination p12" style="margin-top: -2.5%;">
					<c:if test="${pi.currentPage<=1 }">
						<a href="${before }">Previous</a>&nbsp;
				</c:if>
					<c:if test="${pi.currentPage>1 }">
						<c:url var="before" value="restList.tpo">
							<c:param name="page" value="${pi.currentPage-1 }"></c:param>
						</c:url>
						<a href="${before }">Previous</a>
					</c:if>
					<!-- 페이지 -->
					<c:forEach var="p" begin="${pi.startPage }" end="${pi.endpage }">
					<c:choose>
					<c:when test = "${search.alignList eq 'Name' }">
						<c:url var="pagination" value="alignList.tpo">
							<c:param name="alignList" value="${search.alignList}"></c:param>
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage}">
							<a class="is-active" style="background-color: #007c6b;"
								href="${pagenation }">${p }</a>&nbsp; 
							<%-- <font color="red" size="4">[${p }]</font> --%>
							<%-- ${p } --%>
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
					</c:when>
					<c:when test = "${search.alignList eq 'Price' }">
						<c:url var="pagination" value="alignList.tpo">
							<c:param name="alignList" value="${search.alignList}"></c:param>
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage}">
							<a class="is-active" style="background-color: #007c6b;"
								href="${pagenation }">${p }</a>&nbsp; 
							<%-- <font color="red" size="4">[${p }]</font> --%>
							<%-- ${p } --%>
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
					</c:when>
					<c:when test = "${search.alignList eq 'Click' }">
						<c:url var="pagination" value="alignList.tpo">
							<c:param name="alignList" value="${search.alignList}"></c:param>
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage}">
							<a class="is-active" style="background-color: #007c6b;"
								href="${pagenation }">${p }</a>&nbsp; 
							<%-- <font color="red" size="4">[${p }]</font> --%>
							<%-- ${p } --%>
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
					</c:when>
					<c:when test = "${search.location ne null }">
						<c:url var="pagination" value="searchAllList.tpo">
							<c:param name="location" value="${search.location}"></c:param>
							<c:param name="sleep" value="${search.sleep}"></c:param>
							<c:param name="rAmount" value="${search.rAmount}"></c:param>
							<c:param name="aAmount" value="${search.aAmount}"></c:param>
							<c:param name="kAmount" value="${search.kAmount}"></c:param>
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage}">
							<a class="is-active" style="background-color: #007c6b;"
								href="${pagenation }">${p }</a>&nbsp; 
							<%-- <font color="red" size="4">[${p }]</font> --%>
							<%-- ${p } --%>
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<a href="${pagination }">${p }</a>&nbsp;
						</c:if>
					</c:when>	
					<c:otherwise>
					<c:url var="pagination" value="restList.tpo">
							<c:param name="page" value="${p }"></c:param>
						</c:url>
						<c:if test="${p eq pi.currentPage}">
							<a class="is-active" style="background-color: #007c6b;"
								href="${pagenation }">${p }</a>&nbsp; 
							<%-- <font color="red" size="4">[${p }]</font> --%>
							<%-- ${p } --%>
						</c:if>
						<c:if test="${p ne pi.currentPage}">
							<a href="${pagination }">${p }</a>&nbsp;
					</c:if>
					</c:otherwise>								
					</c:choose>
					</c:forEach>

					<!-- 다음 -->
					<c:if test="${pi.currentPage>=pi.maxPage }">
					Next&nbsp;
				</c:if>
					<c:if test="${pi.currentPage<pi.maxPage }">
						<c:url var="after" value="restList.tpo">
							<c:param name="page" value="${pi.currentPage+1 }"></c:param>
						</c:url>
						<a href="${after }">Next</a>&nbsp;
					</c:if>
				</div>
				
			</div>
		</div>

		<script type="text/javascript">
		

		// 가격 조회 부분
			$('#min').change(function(){
				var min2 = $('#min').val();
				$('#min').attr('value',min2);
				console.log(min);
			});
			$('#max').change(function(){
					var max2 = $('#max').val();
					$('#max').attr('value',max2);
					console.log(max)
				});
			
		// 객실부분
		var rSum = 1;	
		$("#rPlus").click(function(){
			rSum = rSum+1;
			$("#rAmount").attr('value',rSum);
		});
		$("#rminus").click(function(){
			rSum = rSum-1;
			$("#rAmount").attr('value',rSum);
		});	
		
		// 성인부분
		var aSum = 1;	
		$("#aPlus").click(function(){
			aSum = aSum+1;
			$("#aAmount").attr('value',aSum);
		});
		$("#aminus").click(function(){
			aSum = aSum-1;
			$("#aAmount").attr('value',aSum);
		});			

		// 어린이 부분
		var kSum = 1;	
		$("#kPlus").click(function(){
			kSum = kSum+1;
			$("#kAmount").attr('value',kSum);
		});
		$("#kminus").click(function(){
			kSum = kSum-1;
			$("#kAmount").attr('value',kSum);
		});	
			
			
		// 지역 조회 부분
		$("#location").change(function(){
			var loca = $("#location").val();
			$("#location").attr('value', loca);
		});
		
		
		// 지역 조회 ajax
		$("#location").keyup(function(){
			var loca = $('#location').val();
			$.ajax({
				url : "searchLocation.tpo",
				data : {"location" : loca},
				dataType : "json",
				type : "get",
				success : function(data, pi){
					var i;
					$(".restInfo-area").empty();
					successFunction(data);
					//page부분 삭제
					$(".pageDiv").empty();			
					console.log(pi.startPage)
					console.log("성공")
					return data;
				}
			})
		
		});
		
		// 최고 금액 설정x
		$('#min').keyup(function(){
			// 최저 최고 조회
			if($("#max").val() == 0){
			var min = $('#min').val();
			console.log('min값 : ' + min);
			$.ajax({
				url:"searchRowPrice.tpo",
				data : { "minPrice" : min},
				dataType:"json",
			    type: "get",
				success : function(data){
					/* $(".restInfo-area").remove(); */
					//$(".well well-sm search sortarea").append("<div class='>" + data[0].rowMin + "</div>") */
					var i;
					$(".restInfo-area").empty();
					successFunction(data);
					//page부분 삭제
					$(".pageDiv").empty();						
					
					return data;											
				}
			})
			}
			})
			
	
		// 최고 금액 설정시
			$('#max').keyup(function(){
				// 최저 최고 조회
				if($("#min").val() != 0){
				var min = $('#min').val();
				console.log('min값 : ' + min);
				var max = $('#max').val();
				console.log('max값 : ' + max);
				$.ajax({
					url:"searchPrice.tpo",
					data : { "minPrice" : min , "maxPrice" : max},
					dataType:"json",
				    type: "get",
					success : function(data){
						/* $(".restInfo-area").remove(); */
						//$(".well well-sm search sortarea").append("<div class='>" + data[0].rowMin + "</div>") */
						var i;
						$(".restInfo-area").empty();
						//page부분 삭제
						$(".pageDiv").empty();						
						successFunction(data);
						return data;											
					}
				})
				}else{
					var max = $('#max').val();
					console.log('max값 : ' + max);
					$.ajax({
						url:"searchPrice.tpo",
						data : {"maxPrice" : max},
						dataType:"json",
					    type: "get",
						success : function(data){
							/* $(".restInfo-area").remove(); */
							//$(".well well-sm search sortarea").append("<div class='>" + data[0].rowMin + "</div>") */
							var i;
							$(".restInfo-area").empty();
							//page부분 삭제
							$(".pageDiv").empty();	
							
							successFunction(data);
							return data;											
						}
					})
				}
			})
			
			// ajax 성공했을시 부분
			function successFunction(data){
				for(i =0; i<data.length; i++){
					console.log(data[i].reName);
		
				if(data[i].reImage == "없음"){
					$('.restInfo-area').append(
							'<input type="hidden" value="'+data[i].reNo+'">'
							+ '<a href="restDetail.tpo?reNo="'+data[i].reNo+'">'
							+ '<div class="well well-lg search restInfo" style="background-color: #eeeeee; margin-top: 2%; margin-left: 5%; height: 260px; width: 100%; color: black">'
							+ '<div style="float: left">'
							+ '<img src="resources/images/noimage.png" style="width: 270px; height: 230px;"/> '
							+ '</div>'
							+ '<div style="float: left; margin-left: 15px;">'
							+ '<b>' + data[i].reName +'</b> <br> <b>전화번호 :</b>' + data[i].rePhone
							+ '<br> <b>상세주소 :</b> <br>' + data[i].reAddr + '<br>'
							+ '<b>최저 금액</b> : ' + data[i].rowMin + '원'
							+ '</div></div>')
						}else if(data[i].reImage != "없음"){
						$('.restInfo-area').append('<input type="hidden" value="'+data[i].reNo+'">'
							+ '<a href="restDetail.tpo?reNo="'+data[i].reNo+'">'
							+ '<div class="well well-lg search restInfo" style="background-color: #eeeeee; margin-top: 2%; margin-left: 5%; height: 260px; width: 100%; color: black">'
							+ '<div style="float: left">'
							+ '<img src="' + data[i].reImage + '" style="width: 270px; height: 230px;" /> '
							+ '</div>'
							+ '<div style="float: left; margin-left: 15px;">'
							+ '<b>' + data[i].reName +'</b> <br> <b>전화번호 :</b>' + data[i].rePhone
							+ '<br> <b>상세주소 :</b> <br>' + data[i].reAddr + '<br>'
							+ '<b>최저 금액</b> : ' + data[i].rowMin + '원'
							+ '</div>'
							+ '</div></a>');
												}
				}
			}
			
			
			
		</script>

	</section>
	<!--section 끝-->
	<jsp:include page="/include/includeFooter.jsp" />

</body>
</html>
