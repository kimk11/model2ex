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
			<h3>ȸ������</h3>
			<label>���̵� : </label><input type="text" name="userId"><br>
			<label>��й�ȣ : </label><input type="password" name="userPw"><br>
			<label>�̸� : </label><input type="text" name="userName"><br>
			<button type="submit">ȸ������</button>
		</form>
	</div>
</body>
</html>