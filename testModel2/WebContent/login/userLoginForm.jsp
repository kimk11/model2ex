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
				<h3>�� �� ��</h3>
				<label>���̵� : </label><input type="text" name="userId"> <span><%= check %></span><br>
				<label>��й�ȣ : </label><input type="password" name="userPw"><br>
				<button type="submit">�α���</button>
			</form>
		</div>
	<%
	}else{
	%>
		<div>
			<p><%= userName %>���� �α��� �Ͽ����ϴ�.</p>
		</div>
		<div>
			<a href="<%= request.getContextPath() %>/logout/action.kjw">�α׾ƿ�</a>
		</div>
	<%
	}
%>

</body>
</html>