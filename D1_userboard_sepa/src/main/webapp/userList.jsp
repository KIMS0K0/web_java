<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="com.hk.board.daos.UserDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>
</head>
<%
//java 실행부
UserDao dao = new UserDao();
List<UserDto> lists = dao.getAllUser();
%>
<body>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<%
			for (int i = 0; i < lists.size(); i++) {
				UserDto dto = lists.get(i);
			%>
				<tr>
					<td><%= dto.getUserID() %></td>
					<td><%= dto.getName() %></td>
					<td><%= dto.getmDate() %></td>
					<td><a href="userUpdateForm.jsp?userId=<%=dto.getUserID()%>">수정</a></td>
					<td><a href="#" onclick="deleteUser('<%=dto.getUserID()%>')">삭제</a></td>
				</tr>
			<%
			}
		%>
		
		<tr>
			<td colspan="5">
				<a href="index.jsp">초기화면</a>
			</td>
		</tr>
	</table>
	<script>
	function deleteUser(userId) {
		if(confirm(userId+ " 회원을 정말 삭제하겠습니까?")) {
			location.href="userDelete.jsp?userId="+userId;
		} else{
			response.sendRedirect("error.jsp");
		}
	}
	</script>
</body>
</html>