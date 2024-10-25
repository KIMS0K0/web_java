<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록조회</title>
</head>
<%//실행부: java 코드를 실행하는 영역 
	HkDao dao=new HkDao();
	List<HkDto> list=dao.getAllList();
%>
<body>
<h1>게시판</h1>
<h2>글목록</h2>
<table border="1">
	<col width="50px" />
	<col width="100px" />
	<col width="300px" />
	<col width="200px" />
	<tr>
		<th>seq</th><th>작성자</th><th>제목</th><th>작성일</th>
	</tr>
	<%
		for(int i=0;i<list.size();i++){
			HkDto dto=list.get(i);
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><a href="detailBoard.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegDate()%></td>
			</tr>
			<%
		}
	%>
	<tr>
		<td colspan="4">
			<button type="button" onclick="insertBoardForm()">글추가</button>		
		</td>
	</tr>
</table>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="insertBoardForm.jsp";
	}
</script>
</body>
</html>






