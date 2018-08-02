<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="<%= request.getContextPath() %>/user/insertAction.kjw" method="post">
			<h3>회원가입</h3>
			<label>아이디 : </label><input type="text" name="userId"><br>
			<label>비밀번호 : </label><input type="password" name="userPw"><br>
			<label>이름 : </label><input type="text" name="userName"><br>
			<button type="submit">회원가입</button>
		</form>
	</div>
</body>
</html>