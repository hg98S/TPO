<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
	<div id="deletePage">
		<form action="deleteMember.tpo" method="post">
		<input type="hidden" id="userId" name="userId" value="${loginUser.userId }">
		<table width="650" cellspacing="5" style="margin:auto;">
				<tr>
					<td>
							<ul class="myPageList" style="line-style:none;">
						 	<li><b style="font-size:25px;font-weight:bold; color:black">마이페이지</b> <small style="color:#b9b9b9"> my Page</small></li>
						 	<li><hr style="height: 1px; width:100%; background-color: #007c6b"></li>
							<li ><a href="myPageView.tpo" onclick="fnMemberInfo()"><b style="color:gray">개인정보 관리</b></a></li>
							<li><br></li>
							<li><a href="#" onclick="fnReservationInfo()"><b style="color:gray">항공 예약 정보</b></a></li>
							<li><br></li>
							<li><a href="#" onclick="fnMemberDelete()"><b style="color:gray">회원 탈퇴</b></a></li>
							</ul>
					</td>
			       <td style="width:50px;">
					</td>
					<td>비밀번호
					<input type="password" id="userPwd" name="userPwd">
					<input type="submit" id="submit" onclick="return fnDeleteButton()" value="탈퇴하기">
					</td>
				</tr>
		</table>	
		</form>
	</div>
	<script>
		function fnDeleteButton(){
			var userId = $("#userId").val();
			var userPwd = $("#userPwd").val();
			var loginPwd = ${loginUser.userPwd};
			if(userPwd!=""){  // 비밀번호 입력했을때
				 if($("#userPwd").val()==loginPwd){
					 alert("회원 탈퇴 되었습니다.");
					 return true;
				 }else{
					 alert("비밀번호를 다시 확인해주세요.");
					 return false;
				 }
		 	}else{ // 비밀번호 입력값 없을 때
				alert("비밀번호를 입력해주세요.");
				return false;
			} 
		}
	</script>
</body>
</html>