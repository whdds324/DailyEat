<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>ID 중복체크</title>
<script type="text/javascript" src="join.js">
	if(document.frm.userid.value =="") {
		alert("아이디를 입력하세요.")
		document.frm.userid.focus();
		return;
	}
</script>
</head>
<body>
	<h2>아이디 중복확인</h2>
		<form action ="idCheck.do" method="get" name="frm">
			아이디 <input type ="text" name ="userid" value ="${userid}">
				<input type ="submit" value="중복체크"> <br>
			<c:if test ="${result==1}">
				<script type="text/javascript">
					opener.document.frm.userid.value="";
				</script>
				${userid}는 이미 사용중인 아이디입니다.
			</c:if>
			
			<c:if test ="${result== -1}">
				${userid}는 사용 가능한 아이디입니다.
				<input type="button" value="사용하기" class="cancel" onclick="idok(); window.close();">
					
			</c:if>
		</form>
</body>
</html>