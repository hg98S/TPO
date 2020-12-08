<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link type="text/css" rel="stylesheet"
	href="resources/css/memberLogin.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css" />
<!-- Modal  JQuery -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
.modal-size {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>

	<jsp:include page="/include/includeHeader.jsp"></jsp:include>

	<div id="page"></div>
	<section style="margin-top: 50px;">
		<div class="login-card">
			<div class="log_head" style="text-align: center">
				<h1>LOGIN</h1>
				<i class="fas fa-user-lock" style="color: #FFFFFF; font-size: 30px;"></i>
				<!-- <img src="lock.png" alt="lock" class="lock" /> -->
			</div>
			<div class="log_body">
				<form action="login.tpo" method="post">
					<table style="width: 200; border: 0; text-align: center">
						<tr>
							<td><input placeholder="User Name" type="text" name="userId"
								class="log_user"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input placeholder="Password" type="password"
								name="userPwd" class="log_Pass"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input name="remember" type="checkbox"
								value="Remember Me"> <sm style="color:#78EEB2">Keep
								me logged in</sm></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><input type="submit" name="login" class="login-submit"
								value="SIGN IN"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>
								<!-- 회원가입 작성페이지 이동 url --> 
								<%-- <c:url var="memberJoin" value="memberJoinForm.tpo"></c:url> --%>
								 <!-- <a href="#" data-toggle="modal" data-target="#exampleModal">회원가입</a>  -->
								 <a onclick="fnModuleInfo()">Modal</a>
								 <!--    Modal -->
								<div class="modal fade" id="MemberJoinModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalTitle" aria-hidden="true">
									<div class="modal-dialog modal-dialog-centered" role="document">
										<div class="modal-content">
										</div>
									</div>
								</div> 
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="#" rel="register">ID 찾기</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="#" rel="register">PASSWORD 찾기</a>
							</td>
						</tr>
					</table>
				</form>
				>
			</div>
		</div>
	</section>

	<jsp:include page="/include/includeFooter.jsp"></jsp:include>

	<!-- 	    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">회원가입</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="">
                <div class="modal-body">
                   	
                </div>
                <div class="modal-footer">
                    <input type="button" data-dismiss="modal" value="close" >
                    <input type="submit" value="save" > 
                </div>
                </form>
            </div>
        </div>
    </div> -->
    <script type="text/javascript">
 		   function fnModuleInfo(){
    	   $('#MemberJoinModal .modal-content').load("memberJoinForm.tpo");
    	   $('#MemberJoinModal').modal();
    		}
    </script>
</body>
</html>