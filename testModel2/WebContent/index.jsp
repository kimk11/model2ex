<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	response.sendRedirect(request.getContextPath()+"/login.kjw");
// 	response.sendRedirect(request.getContextPath()+"/user/list.kjw");
// 	response.sendRedirect(request.getContextPath()+"/user/insertForm.kjw");
%>
</body>
</html>