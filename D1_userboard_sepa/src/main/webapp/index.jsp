<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 첫페이지</title>
</head>
<body>
	<h1>회원관리 HOME</h1>
	<p><a href="userList.jsp">(1)회원 조회(조회 후 수정/삭제 가능)</a></p>
	<p><a href="userInsertForm.jsp">(2)신규회원 등록</a></p>
	<form action="userUpdateForm.jsp" method="post">
		<label>(3)회원수정-회원아이디:</label>
		<input type="text" name="userId" />
		<input type="submit" value="수정" />
	</form>
	<form action="userDelete.jsp" method="post" onsubmit="return deleteUser(userId.value)">
		<label>(4)회원삭제-회원아이디:</label>
		<input type="text" name="userId" />
		<input type="submit" value="삭제" />
	</form>
	<script>
	function deleteUser(userId) {
		if(confirm(userId+ " 회원을 정말 삭제하겠습니까?")) {
			return true;
		} else{
			return false;
		}
	}
	</script>
</body>
</html>