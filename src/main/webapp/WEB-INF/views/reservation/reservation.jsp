<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TPO_Reservation</title>
<link rel="stylesheet" href="resources/assets/css/main.css" />
<!-- <noscript> -->
<link rel="stylesheet" href="resources/assets/css/noscript.css" />
<!-- </noscript> -->
<!-- datepicker 는 jquery 1.7.1 이상 bootstrap 2.0.4 이상 버전이 필요함 -->
<!-- jQuery가 먼저 로드 된 후 datepicker가 로드 되어야함.-->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" > -->
<link rel="stylesheet" href="resources/css/bootstrap-datepicker.min.css">

<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> -->

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.2.1.js"></script> -->
<script src="resources/js/bootstrap-datepicker.min.js"></script>



<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>




<!--한국어  달력 쓰려면 추가 로드-->
<!-- <script src="resources/js/plugin/datepicker/bootstrap-datepicker.ko.min.js"></script> --> 
</head>
<body>
   
   <jsp:include page="/include/includeHeader.jsp"></jsp:include>
   <section>
      <!-- Wrapper-->
         <div id="wrapper">

            <!-- Nav -->
               <nav id="nav" style="width:350px;">
                  <a href="#" class="icon solid fa-home" style="margin:22px;">
                     <span onMouseOver="this.style.backgroundColor='#ccc'" onMouseOut="this.style.backgroundColor='#09c6ab'" onclick="this.style.backgroundColor='#09c6ab'">왕복</span>
                  </a> <!--  -->
                  &emsp;&ensp;&emsp;&ensp;
                  <a href="#contact" class="icon solid fa-envelope" style="margin:22px;">
                     <span onMouseOver="this.style.backgroundColor='#ccc'" onMouseOut="this.style.backgroundColor='#09c6ab'" onclick="this.style.backgroundColor='#09c6ab'">편도</span>
                  </a> <!--   -->
               </nav>

            <!-- Main -->
               <div id="main">
                  <!-- 왕복 -->
                     <article id="home" class="panel" style="background-color:#eeeeee;">
                        <form action="reservationDataSearchRound.tpo">
                           <select id="twoway_dep" name="sDepAirportNm" required>
                              <option value="" >출발지</option>
                              <option value="NAARKSI">인천</option>
                              <option value="NAARKSS">김포</option>
                              <option value="NAARKPC">제주</option>
                              <option value="NAARKPK">김해</option>
                              <option value="NAARKJJ">광주</option>
                              <option value="NAARKNY">양양</option>
                              <option value="NAARKJY">여수</option>
                              <option value="NAARKTH">포항</option>
                              <option value="NAARKPU">울산</option>
                              <option value="NAARKJK">군산</option>
                              <option value="NAARKNW">원주</option>
                              <option value="NAARKTN">대구</option>
                              <option value="NAARKTU">청주</option>
                              <option value="NAARKJB">무안</option>
                              <option value="NAARKPS">사천</option>
                           </select>
                           &ensp;
                           <span><img src="/resources/images/double-arrow.png" style="width:32px;height:32px;"></span>
                           &ensp;
                           <select id="twoway_arr" name="sArrAirportNm" required>
                              <option value="">도착지</option>
                              <option value="NAARKSI">인천</option>
                              <option value="NAARKSS">김포</option>
                              <option value="NAARKPC">제주</option>
                              <option value="NAARKPK">김해</option>
                              <option value="NAARKJJ">광주</option>
                              <option value="NAARKNY">양양</option>
                              <option value="NAARKJY">여수</option>
                              <option value="NAARKTH">포항</option>
                              <option value="NAARKPU">울산</option>
                              <option value="NAARKJK">군산</option>
                              <option value="NAARKNW">원주</option>
                              <option value="NAARKTN">대구</option>
                              <option value="NAARKTU">청주</option>
                              <option value="NAARKJB">무안</option>
                              <option value="NAARKPS">사천</option>
                           </select>
                           <br><br>
                        
                           <div>
                              가는 날짜 : <input style="width:35%;" type="text" id="datePicker_dep1" class="form-control" name="sDepPlandTime" value="가는 날짜" required>
                           </div>
                           
                           &emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;&nbsp;
                           <div>
                              오는 날짜 : <input style="width:35%;" type="text" id="datePicker_arr1" class="form-control" name="sArrPlandTime" value="오는 날짜" required>
                           </div>
                           
                           <script>
                              $("#datePicker_dep1").click(function() {
                                 var str = $("#datePicker_dep1").val().replace(/\-/g,'');
                                 console.log(str);
                                 $("#datePicker_dep1").val(str);
                                 return true;
                              });
                           </script>
                           
                           <div><br></div>
                           
                           <div>
                              <button type="button" id="select_person_btn" data-toggle="collapse" data-target="#twoway_select_person"
                              style="color:#777; background-color:#eeeeee;">
                                 <span>성인</span>&nbsp;<span id="twoway_adult_headCount">1</span>명·<span>소아</span>&nbsp;<span id="twoway_child_headCount">0</span>명·<span>유아</span>&nbsp;<span id="twoway_infant_headCount">0</span>명
                              </button>
                           </div>
                           <div id="twoway_select_person" class="collapse">   
                              <div class="row twoway_AYIPart">
                                 <p value="성인">성인</p>
                              </div>
                              <select class="row" id="twoway_adult_number" name="adultCount">
                                 <option value="1" selected>1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>
                              <br>
                              <div class="row twoway_AYIPart">
                                 <p value="소아">소아</p>
                              </div>
                              <select class="row" id="twoway_child_number" name="childCount">
                                 <option value="0" selected>0</option>
                                 <option value="1">1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>
                              <br>
                              <div class="row twoway_AYIPart">
                                 <p value="유아">유아</p>
                              </div>
                              <select class="row" id="twoway_infant_number" name="infantCount">
                                 <option value="0" selected>0</option>
                                 <option value="1">1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>
                           </div>
                           <input type="submit" id="twowayFlight" value="항공권 검색" style="display:inline-block; float:right; margin:-50px -10px;"><!--  onclick="return twoway_validate();" -->
                        </form>
                     </article>
                     
                  <!-- 편도 -->
                     <article id="contact" class="panel" style="background-color:#eeeeee;">
                        <form action="reservationDataSearchOne.tpo">
                           <select id="oneway_dep" name="sDepAirportNm" required>
                              <option value="">출발지</option>
                              <option value="NAARKSI">인천</option>
                              <option value="NAARKSS">김포</option>
                              <option value="NAARKPC">제주</option>
                              <option value="NAARKPK">김해</option>
                              <option value="NAARKJJ">광주</option>
                              <option value="NAARKNY">양양</option>
                              <option value="NAARKJY">여수</option>
                              <option value="NAARKTH">포항</option>
                              <option value="NAARKPU">울산</option>
                              <option value="NAARKJK">군산</option>
                              <option value="NAARKNW">원주</option>
                              <option value="NAARKTN">대구</option>
                              <option value="NAARKTU">청주</option>
                              <option value="NAARKJB">무안</option>
                              <option value="NAARKPS">사천</option>
                           </select>
                           &ensp;
                           <span><img src="/resources/images/next.png"></span>
                           &ensp;
                           <select id="oneway_arr" name="sArrAirportNm" required>
                              <option value="">도착지</option>
                              <option value="NAARKSI">인천</option>
                              <option value="NAARKSS">김포</option>
                              <option value="NAARKPC">제주</option>
                              <option value="NAARKPK">김해</option>
                              <option value="NAARKJJ">광주</option>
                              <option value="NAARKNY">양양</option>
                              <option value="NAARKJY">여수</option>
                              <option value="NAARKTH">포항</option>
                              <option value="NAARKPU">울산</option>
                              <option value="NAARKJK">군산</option>
                              <option value="NAARKNW">원주</option>
                              <option value="NAARKTN">대구</option>
                              <option value="NAARKTU">청주</option>
                              <option value="NAARKJB">무안</option>
                              <option value="NAARKPS">사천</option>
                           </select>
                           <br><br>
                        
                           가는 날짜 : 
                           <input style="width:35%;" type="text" id="datePicker_dep2" class="form-control" value="가는 날짜" name="sDepPlandTime" required>
                           <div><br></div>
                           
                           <div>
                              <button type="button" id="select_person_btn" data-toggle="collapse" data-target="#oneway_select_person"
                              style="color:#777; background-color:#eeeeee;">
                                 <span>성인</span>&nbsp;<span id="oneway_adult_headCount">1</span>명·<span>소아</span>&nbsp;<span id="oneway_child_headCount">0</span>명·<span>유아</span>&nbsp;<span id="oneway_infant_headCount">0</span>명
                              </button>
                           </div>
                           <div id="oneway_select_person" class="collapse">   
                              <div class="row oneway_AYIPart">
                                 <p value="성인">성인</p>
                              </div>
                              <select class="row" id="oneway_adult_number" name="adultCount">
                                 <option value="1" selected>1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>
                              <br>
                              <div class="row oneway_AYIPart">
                                 <p value="소아">소아</p>
                              </div>
                              <select class="row" id="oneway_child_number" name="childCount">
                                 <option value="0" selected>0</option>
                                 <option value="1">1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>
                              <br>
                              <div class="row oneway_AYIPart">
                                 <p value="유아">유아</p>
                              </div>
                              <select class="row" id="oneway_infant_number" name="infantCount">
                                 <option value="0" selected>0</option>
                                 <option value="1">1</option>
                                 <option value="2">2</option>
                                 <option value="3">3</option>
                                 <option value="4">4</option>
                                 <option value="5">5</option>
                                 <option value="6">6</option>
                                 <option value="7">7</option>
                                 <option value="8">8</option>
                                 <option value="9">9</option>
                              </select>                  
                           </div>
                           <input type="submit" id="onewayFlight" value="항공권 검색" style="display:inline-block; float:right; margin:-50px -10px;"><!--  onclick="return oneway_validate();" -->
                        </form>
                     </article>
               </div>

            <!-- Scripts -->
            <script src="resources/assets/js/jquery.min.js"></script>
            <script src="resources/assets/js/browser.min.js"></script>
            <script src="resources/assets/js/breakpoints.min.js"></script>
            <script src="resources/assets/js/util.js"></script>
            <script src="resources/assets/js/main.js"></script>
            <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
            <script type="text/javascript">
               /* 왕복/편도 datepicker 시작 */
               $(document).ready(function() {   
                  $('#datePicker_dep1').datepicker({
                     format: 'yyyymmdd',   //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
                      startDate: '+3d',   //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
                      endDate: '+3m',   //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
                      autoclose : true,   //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
                     
                      disableTouchKeyboard : false,   //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
                      immediateUpdates: false,   //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
                      templates : {
                          leftArrow: '&laquo;',
                          rightArrow: '&raquo;'
                      }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
                      showWeekDays : true, // 위에 요일 보여주는 옵션 기본값 : true
                      title: "가는 날짜",   //캘린더 상단에 보여주는 타이틀
                      todayHighlight : true,   //오늘 날짜에 하이라이팅 기능 기본값 :false 
                      toggleActive : true,   //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
                      weekStart : 0 , //달력 시작 요일 선택하는 것 기본값은 0인 일요일 
                      language : "ko"   //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
                  }); //datepicker end
                  $('#datePicker_arr1').datepicker({
                     format: "yyyymmdd",   //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
                      startDate: '+3d',   //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
                      endDate: '+3m',   //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
                      autoclose : true,   //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
                      disableTouchKeyboard : false,   //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
                      immediateUpdates: false,   //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
                      templates : {
                          leftArrow: '&laquo;',
                          rightArrow: '&raquo;'
                      }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
                      showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
                      title: "오는 날짜",   //캘린더 상단에 보여주는 타이틀
                      todayHighlight : true ,   //오늘 날짜에 하이라이팅 기능 기본값 :false 
                      toggleActive : true,   //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
                      weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
                      language : "ko"   //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
                  }); //datepicker end/* 
                  $('#datePicker_dep2').datepicker({
                      format: "yyyymmdd",   //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
                      startDate: '+3d',   //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
                      endDate: '+3m',   //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
                      autoclose : true,   //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
                      disableTouchKeyboard : false,   //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
                      immediateUpdates: false,   //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
                      templates : {
                          leftArrow: '&laquo;',
                          rightArrow: '&raquo;'
                      }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징 
                      showWeekDays : true ,// 위에 요일 보여주는 옵션 기본값 : true
                      title: "가는날짜",   //캘린더 상단에 보여주는 타이틀
                      todayHighlight : true ,   //오늘 날짜에 하이라이팅 기능 기본값 :false 
                      toggleActive : true,   //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
                      weekStart : 0 , //달력 시작 요일 선택하는 것 기본값은 0인 일요일 
                      language : "ko"   //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
                      
                  }); //datepicker end
                  $('#datePicker_dep1').datepicker().on('changeDate', function (selected) {
                     var minDate = new Date(selected.date.valueOf());
                     $('#datePicker_arr1').datepicker('setStartDate', minDate);
                  });
                  $('#datePicker_arr1').datepicker().on('changeDate', function (selected) {
                     var minDate = new Date(selected.date.valueOf());
                     $('#datePicker_dep1').datepicker('setEndDate', minDate);
                  });
               });//ready end
               /* 왕복/편도 datepicker 끝 */
               
               /* 성인/소아/유아 select 시작 */
               /* 왕복 */
               $(document).ready(function() {
                  $("#twoway_adult_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#twoway_adult_headCount").text(data);
                  });
                  $("#twoway_child_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#twoway_child_headCount").text(data);
                  });
                  $("#twoway_infant_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#twoway_infant_headCount").text(data);
                  });
               });
               /* 편도 */
               $(document).ready(function() {
                  $("#oneway_adult_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#oneway_adult_headCount").text(data);
                  });
                  $("#oneway_child_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#oneway_child_headCount").text(data);
                  });
                  $("#oneway_infant_number").change(function() {
                     var data = $(this).find(":selected").html();
                     $("#oneway_infant_headCount").text(data);
                  });
               });
   
               // 왕복 항공권 검색 버튼 눌렀을 때 출발지,도착지,가는날짜,오는날짜가 체크되어있지않을 경우
               // alert 창 띄움
				$("#twowayFlight").click(function() {
				   var sDepAirportNm = $("#twoway_dep").val();
				   var sArrAirportNm = $("#twoway_arr").val();
				   var sDepPlandTime = $("#datePicker_dep1").html();
				   var sArrPlandTime = $("#datePicker_arr1").html();
				   if(sDepAirportNm == "") {
				      alert("출발지를 선택해주세요.");
				      $("#twoway_dep").focus();
				      return false;
				   }
				   else if(sArrAirportNm == "") {
					   alert("도착지를 선택해주세요.");
					   $("#twoway_arr").focus();
					   return false;
				   }
				   else if(sDepPlandTime == "가는 날짜") {
					   alert("가는 날짜를 선택해주세요.");
					   $("#datePicker_dep1").focus();
					   return false;
				   }
				   else if(sArrPlandTime == "오는 날짜") {
					   alert("오는 날짜를 선택해주세요.");
					   $("#datePicker_arr1").focus();
					   return false;
				   }
				});
               
				// 편도 항공권 검색 버튼 눌렀을 때 출발지,도착지,가는날짜가 체크되어있지않을 경우
	            // alert 창 띄움
               
            </script>
      
      </div>
   </section>
   
   <jsp:include page="/include/includeFooter.jsp"></jsp:include>
   
   
   
</body>
</html>