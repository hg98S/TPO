<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/assets/css/main.css" />
<noscript><link rel="stylesheet" href="resources/assets/css/noscript.css" /></noscript>
</head>
<body>
	
	<jsp:include page="/include/includeHeader.jsp"></jsp:include>
	
	<section>
		
		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#" class="icon solid fa-home"><span>왕복</span></a>
						<a href="#contact" class="icon solid fa-envelope"><span>편도</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="home" class="panel">
								
								<select id="departure">
									<option selected>출발지</option>
									<option>인천</option>
									<option>김포</option>
									<option>제주</option>
									<option>부산</option>
									<option>광주</option>
									<option>양양</option>
									<option>여수</option>
									<option>포항</option>
									<option>울산</option>
									<option>군산</option>
									<option>원주</option>
									<option>대구</option>
									<option>청주</option>
									<option>무안</option>
									<option>진주</option>
								</select>
								&ensp;
								<span><img src="/resources/images/double-arrow.png" style="width:32px;height:32px;"></span>
								&ensp;
								<select id="arrival">
									<option selected>도착지</option>
									<option>인천</option>
									<option>김포</option>
									<option>제주</option>
									<option>부산</option>
									<option>광주</option>
									<option>양양</option>
									<option>여수</option>
									<option>포항</option>
									<option>울산</option>
									<option>군산</option>
									<option>원주</option>
									<option>대구</option>
									<option>청주</option>
									<option>무안</option>
									<option>진주</option>
								</select>
								<br><br>
								<input type="date" id="currentDate" name="theday" min="2020-12-09" max="2020-12-31">
								&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&ensp;&ensp;&nbsp;
								<input type="date" placeholder="오는날짜">
								<input type="submit" name="항공권 검색" value="항공권 검색" style="float:right;">
							</article>							   

						<!-- Contact -->
							<article id="contact" class="panel">
								<select id="departure">
									<option selected>출발지</option>
									<option>인천</option>
									<option>김포</option>
									<option>제주</option>
									<option>부산</option>
									<option>광주</option>
									<option>양양</option>
									<option>여수</option>
									<option>포항</option>
									<option>울산</option>
									<option>군산</option>
									<option>원주</option>
									<option>대구</option>
									<option>청주</option>
									<option>무안</option>
									<option>진주</option>
								</select>
								&ensp;
								<span><img src="/resources/images/next.png"></span>
								&ensp;
								<select id="arrival">
									<option selected>도착지</option>
									<option>인천</option>
									<option>김포</option>
									<option>제주</option>
									<option>부산</option>
									<option>광주</option>
									<option>양양</option>
									<option>여수</option>
									<option>포항</option>
									<option>울산</option>
									<option>군산</option>
									<option>원주</option>
									<option>대구</option>
									<option>청주</option>
									<option>무안</option>
									<option>진주</option>
								</select>
								<br><br>
								<input type="date" id="o_currentDate" name="theday" min="2020-12-09" max="2020-12-31">
								<input type="submit" name="항공권 검색" value="항공권 검색" style="float:right;">
							</article>
					</div>


		<!-- Scripts -->
			<script src="resources/assets/js/jquery.min.js"></script>
			<script src="resources/assets/js/browser.min.js"></script>
			<script src="resources/assets/js/breakpoints.min.js"></script>
			<script src="resources/assets/js/util.js"></script>
			<script src="resources/assets/js/main.js"></script>
			<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
			<script>
				document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);
				document.getElementById('o_currentDate').value = new Date().toISOString().substring(0, 10);
			</script>

	</section>
	
	<jsp:include page="/include/includeFooter.jsp"></jsp:include>
	
</body>
</html>