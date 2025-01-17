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
<title>글 상세조회하기</title>
<script type="text/javascript">
	function updateForm(seq){
		location.href="updateBoardForm.jsp?seq="+seq;
	}
	
	//삭제하기
	function deleteBoard(seq){
		location.href="deleteBoard.jsp?seq="+seq;
	}
	
</script>
</head>
<%
	String seq=request.getParameter("seq");// 전달되는 파리미터들은 모두 text--> String타입임 : 5->"5"
	int sseq=Integer.parseInt(seq);//숫자형식의 문자열 --> 숫자(정수형)로 변환
	
	HkDao dao=new HkDao();
	HkDto dto=dao.getBoard(sseq);
%>
<body>
<h1>글 상세조회</h1>
<table border="1">
	<tr>
		<th>작성자</th>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea> </td>
	</tr>
	<tr>
		<td colspan="2">
			<button onclick="updateForm(<%=dto.getSeq()%>)">수정</button>
			<button onclick="deleteBoard(<%=dto.getSeq()%>)">삭제</button>
			<button type="button" onclick="location.href='boardList.jsp'">글목록</button>
		</td>
	</tr>
</table>

</body>
</html>


