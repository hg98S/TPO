<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항공예약정보</title>
<style type="text/css">
 #reservation tr{
	text-align:center;
}
#reservation td{
	text-align:center;
}
#reservation th{
	text-align:center;
	color:gray;
}
.cancelBtn{
	background: #555555;
	border-radius: 4px;
	border: 1px solid #555555;
	color: white;
}
</style>
</head>
<body>
	<div id="reservationPage" >
	<br>
	<table id="reservation" class="table table-hover" width="300" cellspacing="5" style="background:white;">
 		<tr>
 			<th>번호</th>
			<th>예매일자</th>
			<th>구분</th>
			<th>항공편명</th>
 			<th>출발지</th>
 			<th>도착지</th>
 			<th>출발 시간</th>
 			<th>도착 시간</th>
 			<th>인원</th>
 			<th>좌석</th>
 			<th>요금</th>
 			<th>취소요청</th>
 		</tr>
 		<tr>
 			<td>1</td>
 			<td>2</td>
 			<td>3</td>
 			<td>2</td>
 			<td>3</td>
 			<td>4</td>
 			<td>5</td>
 			<td>6</td>
 			<td>7</td>
 			<td>7</td>
 			<td><fmt:formatNumber value="300000" pattern="#,###" /></td>
 			<td><button class="cancelBtn">취소</button></td>
 		</tr>
 		 <tr>
 			<td>1</td>
 			<td>2</td>
 			<td>2</td>
 			<td>3</td>
 			<td>3</td>
 			<td>4</td>
 			<td>5</td>
 			<td>6</td>
 			<td>7</td>
 			<td>7</td>
 			<td><fmt:formatNumber value="300000" pattern="#,###" /></td>
 			<td><button class="cancelBtn">취소</button></td>
 		</tr>
 		<tr>
 			<td>1</td>
 			<td>2</td>
 			<td>2</td>
 			<td>3</td>
 			<td>3</td>
 			<td>4</td>
 			<td>5</td>
 			<td>6</td>
 			<td>7</td>
 			<td>7</td>
 			<td><fmt:formatNumber value="300000" pattern="#,###" /></td>
 			<td><button class="cancelBtn">취소</button></td>
 		</tr>
	</table>
	</div>
</body>
</html>