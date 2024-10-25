<%@page import="com.hk.dtos.HkDto"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id=request.getParameter("id");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	//서버쪽에서 유효값 처리하는 경우
// 	if(id==""||title==""||content==""){
// 		//값을 모두 입력하라고 알리고 글추가 페이지로 이동하기 코드
// 	}else{
// 		//밑에 있는 코드 실행(글추가코드)
// 	}
	
	
 	HkDao dao=new HkDao();
	boolean isS=dao.insertBoard(new HkDto(id,title,content));
	if(isS){
		%>
		<script type="text/javascript">
			alert("글을 추가합니다.");
			location.href="boardList.jsp";//글추가하고, 글목록 페이지로 이동하기
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("글추가실패!");
			location.href="insertBoardForm.jsp";//글추가 실패하면, 글추가 페이지로 이동하기
		</script>
		<%
	}
%>
</body>
</html>










