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
		<table width="500" cellspacing="5" style="margin:auto;">
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" id="userPwd" name="userPwd"></td>
					<td><input type="submit" onclick="return fnDeleteButton()" value="탈퇴하기"></td>
				</tr>
		</table>
		</form>
	</div>
	<script>
		function fnDeleteButton(){
			var userId = $("#userId").val();
			var userPwd = $("#userPwd").val();
			
			if(userPwd!=""){
				$.ajax({
					url: "pwdDuplicateChk.tpo",
					type: "get",
					data: {"userId":userId, "userPwd":userPwd},
					success: function(data){
						if(data=="true"){
							alert("비밀번호를 다시 확인해주세요.");
							var chk = data;
						}else{
							alert("회원 탈퇴 되었습니다.");
							var chk = data;
						}
					}
				})
				console.log(chk);
				return chk;
			}else{
				alert("비밀번호를 입력해주세요.");
				return false;
			}
		}
	</script>
</body>
</html>