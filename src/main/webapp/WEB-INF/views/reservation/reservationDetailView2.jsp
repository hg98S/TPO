<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TPO_예약완료</title>
<script
  src="https://code.jquery.com/jquery-3.5.1.min.js"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous">
</script>
</head>
<body>
	<jsp:include page="/include/includeHeader.jsp" />
	<div id="page"></div>
	
	<!-- 컨텐츠 시작 -->
    <section class="gtco-container" style="margin-top: 100px;">
    	<article></article>
        <article style="text-align: center;">
            <h1 style="font-weight: 1000">
                예약이 완료되었습니다.
                <img src="../resources/images/plane1.png" width="50px;" style="margin-top: -45px;">
            </h1>
        </article>
        <article style="text-align: center;">
            <h2 style="font-weight: 800">예약 번호 : 6865467</h2>
        </article>
        <article>
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
                </tbody>
            </table>
        </article>
        <br><br>
        <article>
            <h3 style="font-weight: 700">탑승객 정보</h3>
            <table class="table table-bordered" style="width: 40%;">
                <thead style="background-color: #09c6ab; color: white; font-size: 20px;">
                    <tr>
                        <th style="text-align: center;">구분</th>
                        <th style="text-align: center;">인원</th>
                    </tr>
                </thead>
                <tbody style="font-size: 20px;">
                    <tr>
                        <td style="text-align: center;">성인</td>
                        <td style="text-align: center;">1명</td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">성인</td>
                        <td style="text-align: center;">1명</td>
                    </tr>
                    <tr>
                        <td style="text-align: center;">성인</td>
                        <td style="text-align: center;">1명</td>
                    </tr>
                </tbody>
            </table>
        </article>
    </section>
    <!-- 컨텐츠 끝 -->
    
	<jsp:include page="/include/includeFooter.jsp" />
</body>
</html>