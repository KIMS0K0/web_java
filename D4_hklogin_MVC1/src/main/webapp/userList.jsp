<%@page import="com.hk.daos.UserDao"%>
<%@page import="java.util.List"%>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input {
	border: 1px solid rgb(192, 192, 192);
	width: 80px;
	height: 30px;
	border-radius: 5px;
	padding-left: 10px;
}

button {
	width: 100px;
	margin: 20px;
}

input, button {
	margin: 4px;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<%
//java 실행부
UserDao dao = UserDao.getUserDao();
List<UserDto> lists = dao.getAllUser();
%>
<body>
	<div id="container">
		<div class="main">
			<div class="lead">
				<span><%=ldto.getId()%>[<%=ldto.getRole()%>]님이 로그인 함</span> | <span><a
					href="userController.jsp?command=getAllUserList">회원전체조회</a></span> | <span><a
					href="userController.jsp?command=getUserList">회원정보[등급]수정</a></span> | <span><a
					href="userController.jsp?command=logout">로그아웃</a></span>
			</div>
			<div class="contents">
				<h1>관리자 페이지</h1>
				<h2>회원목록조회[등급수정]</h2>
				<div id="userAllList">
					<table class="table" border="1">
							<tr>
								<th>회원번호</th>
								<th>아이디</th>
								<th>이름</th>
								<th>회원등급</th>
								<th>가입일</th>
								<th>-</th>
							</tr>
							<%
							for (int i = 0; i < lists.size(); i++) {
								UserDto dto = lists.get(i);
							%>
							<tr>
								<td><%=dto.getSeq()%></td>
								<td><%=dto.getId()%></td>
								<td><%=dto.getName()%></td>
								<td><%=dto.getRole()%></td>
								<td><%=dto.getRegDate()%></td>
								
								<td><a href="userController.jsp?command=userroleform&id=<%=dto.getId()%>">수정</a></td>
							</tr>
							<%
							}
							%>
						</table>
				</div>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>