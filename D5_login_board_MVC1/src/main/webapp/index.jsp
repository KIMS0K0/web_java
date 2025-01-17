<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/cookiefunc.js"></script>
<link rel="stylesheet" href="css/loginpage1.css">
</head>
<body>
<% String msg=request.getParameter("msg"); %>
<form action="userController.jsp" method="post" onsubmit="userIdCookie()">
	<input type="hidden" name="command" value="login"/>
	<h1>Login</h1>
	<input type="text" name="id" placeholder="ID" required="required" />
	<input type="password" name="password" placeholder="password" 
											  required="required" />
	<input type="checkbox" value="remember-me"/><label>아이디 저장</label>
	<label style="color:red;"><small><%=msg==null?"":msg%></small></label>	
	<button type="submit">Sign in</button>
	<button type="button" onclick="registForm()">Sign up</button>
</form>
<script type="text/javascript">
	function registForm(){
		location.href="userController.jsp?command=registform";
	}
	
	//아이디를 쿠키에 저장하기
	function userIdCookie(){
		//chkID 객체 구함
		var chkID=document.querySelectorAll("input[type=checkbox]")[0];
		//입력된 ID구함
		var id=document.querySelectorAll("input[name=id]")[0].value;
		
		if(chkID.checked){//체크가 되어 있으면 쿠키에 id를 저장하자
			setCookie("rememberid",id,100);
		}
	}
	
	//cookie에 아이디가 저장되어 있다면 id입력박스에 해당 id를 출력하자
	onload=function(){
		var cookieID=getCookie("rememberid");

		if(cookieID!=null){
			document.querySelectorAll("input[name=id]")[0].value=cookieID;
		}
	}
</script>
</body>
</html>