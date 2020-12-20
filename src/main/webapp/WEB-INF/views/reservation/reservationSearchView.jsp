<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
   <jsp:include page="/include/includeHeader.jsp"/>
   <div id="page"></div>
   <a href="ex2.tpo">다음</a>
   <%-- <c:forEach items="${fList }" var="fly">
      ${fly.vihicleId }
      ${fly.airlineNm }
      <c:set var="time" value="${fly.depPlandTime }"/>
         ${fn:substring(time,8,10) }: ${fn:substring(time,10,12) }
      <c:set var="time2" value="${fly.arrPlandTime }"/>
         ${fn:substring(time2,8,10) }: ${fn:substring(time2,10,12) }


      ${fly.depAirportNm }
      
      ${fly.arrAirportNm }
      ${fly.economyCharge }
      ${fly.prestigeCharge }
      <br>
   </c:forEach> --%>
   <!-- 컨텐츠 시작 -->
    <section class="gtco-container" style="margin-top: 50px;">
    <c:set var="depDay" value="${fList[0].depPlandTime }"/>
    <c:set var="arrDay" value="${fList[0].arrPlandTime }"/>
        <article>
            <div style="width: 50%; float: left;">
                <div style="font-size: 25px; font-weight: 500">
                    <img src="../resources/images/plane2.png" style="width: 50px;">
                    가는편 [${fList[0].depAirportNm } -> ${fList[0].arrAirportNm }]
                </div>
                <div>
                    <div style="float: left;">
                        ${fn:substring(depDay,4,6) }월 ${fn:substring(depDay,6,8) }일
                    </div>
                    <div style="text-align: right; margin-right: 20px;">
                         <select id="airport">
                            <option value="all">항공사</option>
                            <option value="대한항공">대한항공</option>
                            <option value="아시아나항공">아시아나</option>
                            <option value="제주항공">제주항공</option>
                            <option value="진에어">진에어</option>
                            <option value="이스타항공">이스타항공</option>
                            <option value="티웨이항공">티웨이항공</option>
                            <option value="에어부산">에어부산</option>
                            <option value="에어서울">에어서울</option>
                            <option value="플라이강원">플라이강원</option>
                            <option value="하이에어">하이에어</option>
                        </select>
                        <select id="time">
                            <option value="allTime">시간대</option>
                            <option value="06">06시</option>
                            <option value="07">07시</option>
                            <option value="08">08시</option>
                            <option value="09">09시</option>
                            <option value="10">10시</option>
                            <option value="11">11시</option>
                            <option value="12">12시</option>
                            <option value="13">13시</option>
                            <option value="14">14시</option>
                            <option value="15">15시</option>
                            <option value="16">16시</option>
                            <option value="17">17시</option>
                            <option value="18">18시</option>
                            <option value="19">19시</option>
                            <option value="20">20시</option>
                            <option value="21">21시</option>
                            <option value="22">22시</option>
                            <option value="23">23시</option>
                        </select>
                    </div>
                </div>
            </div>
           <script type="text/javascript">
                $("#airport").on("change",function(){
                   var airNm = $(this).val();
                   var time = $("#time option:selected").val();
                   console.log(time);
                   
                   if(airNm == "all" ){
                      $(".air").show();
                   }else{
                      $(".air").hide();
                       $("."+airNm).show();
                   }
                });
                $("#time").on("change",function() {
                   var time = $(this).val();
                   if (time == "allTime") {
                      $(".time").show();
                   } else {
                      $(".time").hide();
                      $("."+time).show();
                   }
                });
           </script>
            <div style="width: 50%; float: left;">
                <div style="font-size: 25px; font-weight: 500">
                    <img src="../resources/images/plane2.png" style="width: 50px;">
                    오는편 [${fList[0].depAirportNm } -> ${item.arrAirportNm }]
                </div>
                <div>
                    <div style="float: left;">
                        01월 08일 금요일
                    </div>
                    <div style="text-align: right; margin-right: 20px;">
                        <select id="airport">
                            <option>항공사</option>
                            <option value="대한항공">대한항공</option>
                            <option value="아시아나항공">아시아나</option>
                            <option value="제주항공">제주항공</option>
                            <option value="진에어">진에어</option>
                            <option value="이스타항공">이스타항공</option>
                            <option value="티웨이항공">티웨이항공</option>
                            <option value="에어부산">에어부산</option>
                            <option value="에어서울">에어서울</option>
                            <option value="플라이강원">플라이강원</option>
                            <option value="하이에어">하이에어</option>
                        </select>
                       
                        <select>
                            <option>시간대</option>
                            <option value="">06시</option>
                            <option value="">07시</option>
                            <option value="">08시</option>
                            <option value="">09시</option>
                            <option value="">10시</option>
                            <option value="">11시</option>
                            <option>12시</option>
                            <option>13시</option>
                            <option>14시</option>
                            <option>15시</option>
                            <option>16시</option>
                            <option>17시</option>
                            <option>18시</option>
                            <option>19시</option>
                            <option>20시</option>
                            <option>21시</option>
                            <option>22시</option>
                            <option>23시</option>
                        </select>
                    </div>
                </div>
            </div>
            <div style="float: left; width: 50%;">
                <table class="table table-hover">
                    <thead>
                        <tr style="display:table; width:100%;">
                            <th style="width: 120px;">항공/편명</th>
                            <th style="width: 100px;">운항시간</th>
                            <th style="width: 120px; text-align: center;">좌석</th>
                            <th style="width: 70px;">가격</th>
                            <th style="width: 120px;">잔여석</th>
                        </tr>
                    </thead>
                    <tbody style="display:block; height:400px; overflow:auto;">
                       <c:forEach items="${fList }" var="flight">
                       <c:set var="time" value="${flight.depPlandTime }"/>
                   <c:set var="time2" value="${flight.arrPlandTime }"/>
                        <c:if test="${flight.airlineNm ne null }">
                        <tr style="display:table; width:100%;" onclick="departure_chk()" class="${flight.airlineNm } air ${fn:substring(time,8,10) } time">
                            <td>
                                ${flight.airlineNm }<br>
                                &nbsp;&nbsp;${flight.vihicleId }
                            </td>
                            <td style="line-height: 2.5;">
                               ${fn:substring(time,8,10) }: ${fn:substring(time,10,12) } ~ ${fn:substring(time2,8,10) }: ${fn:substring(time2,10,12) }
                     </td>
                     <c:if test="${flight.prestigeCharge eq 0 || flight.prestigeCharge eq null}">
                        <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                               <td style="line-height: 2.5;">${flight.economyCharge }</td>
                     </c:if>
                     
                     <c:if test="${flight.prestigeCharge ne null && flight.prestigeCharge ne 0}">
                        <td style="line-height: 2.5; margin-left: -50px;">비즈니스</td>
                               <td style="line-height: 2.5;">${flight.prestigeCharge }</td>
                     </c:if>
                     
                            <td style="line-height: 2.5;">9</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="DepartureSelect" id="departure">
                            </td>
                        </tr>
                        </c:if>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div style="float: left; width: 50%;">
                <table class="table table-hover">
                    <thead>
                        <tr style="display:table; width:100%;">
                            <th style="width: 120px;">항공/편명</th>
                            <th style="width: 100px;">운항시간</th>
                            <th style="width: 120px; text-align: center;">좌석</th>
                            <th style="width: 70px;">가격</th>
                            <th style="width: 120px;">잔여석</th>
                        </tr>
                    </thead>
                    <tbody style="display:block; height:400px; overflow:auto;">
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                        <tr style="display:table; width:100%;">
                            <td>
                                제주항공<br>
                                &nbsp;&nbsp;7C161
                            </td>
                            <td style="line-height: 2.5;">06:05~07:10</td>
                            <td style="line-height: 2.5; margin-left: -50px;">일반석</td>
                            <td style="line-height: 2.5;">40,000원</td>
                            <td style="line-height: 2.5;">7</td>
                            <td>
                                <input style="margin-top: 13px;" type="radio" name="ArrivalSelect">
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </article>
        
        <article>
            <div>
                <h3>선택한 항공 스케줄</h3>
            </div>
            <div>
                <table align="center" class="table table-bordered" style="height: 150px; font-size: 20px;">
                    <thead style="background-color: #09c6ab; color: white; text-align: center;">
                        <tr style="text-align: center;">
                            <th style="text-align: center;">여정</th>
                            <th style="text-align: center;">항공편</th>
                            <th style="text-align: center;">출발시간</th>
                            <th style="text-align: center;">도착시간</th>
                            <th style="text-align: center;">좌석등급</th>
                            <th style="text-align: center;">금액</th>
                            <th style="text-align: center;">요청좌석</th>
                        </tr>
                    </thead>
                    <tbody style="text-align: center;">
                        <tr>
                            <td style="line-height: 2">김포 -> 제주</td>
                            <td style="line-height: 2">진에어</td>
                            <td style="line-height: 2">2021.01.04(월) 07:15</td>
                            <td style="line-height: 2">2021.01.04(월) 08:15</td>
                            <td style="line-height: 2">일반석</td>
                            <td style="line-height: 2">38900원</td>
                            <td style="line-height: 2">1석</td>
                        </tr>
                        <tr>
                            <td style="line-height: 2">제주 -> 김포</td>
                            <td style="line-height: 2">진에어</td>
                            <td style="line-height: 2">2021.01.08(금) 19:45</td>
                            <td style="line-height: 2">2021.01.08(금) 20:45</td>
                            <td style="line-height: 2">일반석</td>
                            <td style="line-height: 2">19900원</td>
                            <td style="line-height: 2">1석</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </article>
        
        <article>
            · 상기 요금은 항공운임/발권대행수수료 등 총액이 포함된 금액이며, 발권일/환률 등에 따라 유류할증료와 제세공과금은 변동될 수 있습니다.<br>
            · <span style="color: red;">발권대행수수수료는 인원별 1,000원씩 부과되며 인터파크로 별도 승인, 결제 완료 후 항공권 취소 시 환불되지 않습니다. (편도-성인/소아기준)</span><br>
            · 유류할증료(편도기준/성인,소아 동일) : 0원 | 제세공과금(편도기준) : 성인 4,000원 / 소아 2,000원<br>
            · 소아/유아는 단독 탑승이 불가하며, 탑승 수속 시 생년월일을 확인할 수 있는 증빙 서류(의료보험증/등본/여권 등)를 반드시 지참하시기 바랍니다.
        </article>
        <br><br>
        <article>
            <fieldset>
                <legend>※ 항공 예약 시 유의사항</legend>
                · <b style="color: red;">즉시 결제하지 않으면 예약이 자동취소 됩니다. (예약과 동시구매)</b><br>
                · <b style="color: red;">전 항공사가 결제는 신용카드, 체크카드만 가능합니다. (현금결제 불가)</b><br>
                · <span style="color: red;">결제하지 않은 예약 건은 마이페이지에 미노출됩니다.</span><br>
                · <span style="color: red;">예약 후 일정/인원/항공시간/항공사/이름 변경이 불가하며 취소 후 재 예약 하셔야 합니다.</span><br>
                · <span style="color: red;">대한항공, 아시아나항공인 경우 결제 후 카드 승인이 되어도 정상 예약이 되지 않는 경우가 있으니 반드시 마이페이지에서 예약 건을 확인해주세요.</span><br>
                · 항공좌석과 할인석 요금은 실시간 변동입니다.<br>
                · 예약은 성인과 유아를 포함하여 최대 9명까지 가능하며, 10명이상 예약 시 인원을 나누어 예약 진행하셔야 합니다.<br>
                · 개인신분할인 중 동반보호자 및 유가족 할인은 1인만 할인 가능합니다.<br><br>
                
                · 아시아나항공 김포/부산, 부산/제주, 대구/제주, 김포/울산, 울산/제주 구간의 일부 편은 에어부산 항공사와 공동운항됩니다.<br>
                &nbsp;&nbsp;(에어부산 공동운항편의 경우 탑승 수속 시 에어부산 항공 카운터를 이용하시기 바랍니다.)<br>
                · 공동 운항편의 경우 실제 운항사와 운임이 상이할 수 있습니다. 상이한 운임에 대해선 차액환불이 불가합니다.<br>
                · 항공권 예매 후 항공사 사정 및 천재지변으로 인하여 시간 변경 또는 결항될 수 있습니다.<br>
                &nbsp;&nbsp;필히 출발 전 마이페이지에서 항공 시간 재확인 바랍니다.<br>
                · 항공권은 타인양도 및 명의 변경이 불가하오니 반드시 실제 탑승하시는 고객의 성함을 정확하게 기입하시기 바랍니다.<br>
                &nbsp;&nbsp;사진이 부착된 신분증과 상이한 정보로 예약한 경우 탑승이 거절될 수 있으며, 결제 후 변경 시에는 취소 환불 후 재예약 하셔야 합니다.<br>
                &nbsp;&nbsp;단, 수수료가 발생할 수 있으며, 원하는 항공권 및 좌석이 없을 수 있습니다.<br>
                · 이름 입력 시 공백 또는 특수문자는 입력이 불가합니다.<br>
                · 동명이인의 경우 인터넷으로 동시 예약이 불가능하오니, 각 탑승자 별로 예약을 진행해 주시기 바랍니다.<br>
                &nbsp;&nbsp;동시예약을 하고자하시는 분은 각 항공사를 통해 예약바랍니다.
            </fieldset>
        </article>
        <br><br>
        <article>
            <div style="width: 35%; margin: auto;">
                <button onclick="#" class="btn btn-secondary" style="height: 60px;">
                    항공 스케줄 다시 선택
                </button>
                <input type="submit" id="btn" value="다음 단계" style="background-color: #09c6ab; height: 60px; border-radius: 5px; border: 1px solid #09c6ab; color: white; width: 150px;">
            </div>
        </article>
    </section>
    <!-- 컨텐츠 끝 -->
   
   <jsp:include page="/include/includeFooter.jsp"/>
</body>
</html>