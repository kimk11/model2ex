<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String userName = (String)session.getAttribute("userSessionName");
	String check = "";
	if(request.getAttribute("check")!=null){
		check = (String)request.getAttribute("check");
	}

	if(session.getAttribute("userSessionName") == null){
	%>
		<div>
			<form action="<%= request.getContextPath() %>/login/action.kjw" method="post">
				<h3>로 그 인</h3>
				<label>아이디 : </label><input type="text" name="userId"> <span><%= check %></span><br>
				<label>비밀번호 : </label><input type="password" name="userPw"><br>
				<button type="submit">로그인</button>
			</form>
		</div>
	<%
	}else{
	%>
		<div>
			<p><%= userName %>님이 로그인 하였습니다.</p>
		</div>
		<div>
			<a href="<%= request.getContextPath() %>/logout/action.kjw">로그아웃</a>
		</div>
	<%
	}
%>

</body>
</html>