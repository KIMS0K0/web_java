<%@page import="com.hk.board.daos.UserDao"%>
<%@page import="com.hk.board.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
</head>
<body>
<% 
	String userId=request.getParameter("userId");
	UserDao dao = new UserDao();
	
	boolean isS=dao.deleteUser(userId);
	
	if(isS) {
		%>
		<script type="text/javascript">
			alert("회원정보를 삭제했습니다.");
			location.href="index.jsp";
		</script>
		<%
	}else{
		response.sendRedirect("error.jsp");
	}
%>
</body>
</html>