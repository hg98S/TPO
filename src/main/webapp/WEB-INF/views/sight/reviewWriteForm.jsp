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
<title>이것은 명소 상세 정보다 이말이야!</title>
</head>
<body>
	<!--  header -->

	<jsp:include page="/include/includeHeader.jsp" />


<!--  content -->
	<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h2 class="text-center"> 명소 리뷰 작성 </h2><p></p>
        <form action="insertReview.tpo" method="post" enctype="multipart/form-data">
            <div class="table table-responsive">
                      <table class="table table-striped">
            <tr>
                <td>작성자</td>
                <td><input type="text"  class="form-control" name="userId" value="${sessionScope.loginUser.userId }"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text"  class="form-control" name="reviewTitle" ></td>
            </tr>
            <tr>
                <td>글내용</td>
                <td><textarea rows="10" cols="50" name="reviewContent" class="form-control" ></textarea></td>
            </tr>
            <tr>
                <td>평점</td>
                <td>
                	<input type="radio" name="reviewScore" value="1">1점
                	<input type="radio" name="reviewScore" value="2">2점
                	<input type="radio" name="reviewScore" value="3">3점
                	<input type="radio" name="reviewScore" value="4">4점
                	<input type="radio" name="reviewScore" value="5">5점
                </td>
            </tr>
            <tr>
                <td>사진 업로드</td>
                <td><input type="file"  class="form-control" name="uploadFile" ></td>
            </tr>
            <tr>  
                <td colspan="2"  class="text-center">
                 
                    <input type="hidden" name="sNo"  value="${sNo }">
                    <input type="hidden" name="ref"  value="">
                    <input type="hidden" name="ref_step"  value="">
                    <input type="hidden" name="ref_level"  value="">
                 
                    <input type="submit" value="답글쓰기완료" class="btn btn-success">
                    <input type="reset" value="취소" class="btn btn-warning">
                    <input type="button"  class="btn btn-primary" onclick="location.href=''" value="전체글보기">
                </td>
            </tr>
             
          </table>
         
     
            </div>
        </form>   
    </div>
</div>
	
	<!-- footer -->
	<jsp:include page="/include/includeFooter.jsp" />
</body>
</html>
