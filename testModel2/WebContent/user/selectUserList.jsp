<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="dto.Users"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Users> arrayList = (ArrayList<Users>)request.getAttribute("users");
%>
	<table>
		<tr>
			<td>���̵�</td>
			<td>�����ȣ</td>
			<td>�̸�</td>
		</tr>
		<%
			for(Users users : arrayList){
			%>
				<tr>
					<td><%= users.getUserId() %></td>
					<td><%= users.getUserPw() %></td>
					<td><%= users.getUserName() %></td>
				</tr>	
			<%
			}
		%>
	</table>
</body>
</html>