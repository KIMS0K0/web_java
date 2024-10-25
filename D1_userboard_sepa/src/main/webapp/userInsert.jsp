<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="com.hk.board.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>
<%
	String userId=request.getParameter("userId");
	String name=request.getParameter("name");
	//String birthYear_=request.getParameter("birthYear");
	int birthYear=Integer.parseInt(request.getParameter("birthYear"));
	String addr=request.getParameter("addr");
	String mobile1=request.getParameter("mobile1");
	String mobile2=request.getParameter("mobile2");
	String height_=request.getParameter("height");
	int height=Integer.parseInt(height_);
	
	UserDao dao=new UserDao();
	boolean isS=dao.insertUser(new UserDto(userId,
										   name,
										   birthYear,
										   addr,
										   mobile1,
										   mobile2,
										   height));
	if(isS) {
		response.sendRedirect("index.jsp");
	}else{
		response.sendRedirect("error.jsp");
	}
%>
</body>
</html>