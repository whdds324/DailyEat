<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>logout</title>
</head>
<body>
	<% session.invalidate(); %>
	<script>
		alert("로그아웃 되었습니다.");
		location.href="Login.jsp";
	</script>

</body>
</html>