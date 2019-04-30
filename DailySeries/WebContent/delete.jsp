<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원탈퇴</title>
</head>
<body>
<div align="center">
	<h2>확인하기</h2>
		<form action="deleteServlet" method="post" name="frm">
			아이디<input type = "text" name="userid"><br>
			비밀번호<input type = "text" name="password"> <br><br>
		
			<input type = "submit" value="탈퇴하기" onclick="alert('정말로 탈퇴하시겠습니까?')"> &nbsp;<br>
			<div>${message}</div>
			
		</form>
</div>
</body>
</html>