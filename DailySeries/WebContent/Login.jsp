
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body {background-color:#606c88;}
</style>

<title>오늘 뭐하지?</title>
</head>
<form action = "/LoginServlet" method="post" name="frm">
<body align = "center">
<h1>오늘 뭐하지?</h1>
<h2 align ="center"> 로그인 </h2>

<table align = "center" border = "1">

<tr>
  <td> 아이디 </td>
  <td> <input type = "text" name="userid"></td>
</tr>

<tr>
  <td> 비밀번호 </td>
  <td> <input type ="password" name ="password"></td>
</tr>
  
 <tr>
   <td colspan = "2" align = "center">
   <form action = "/LoginServlet" method = "post" name="frm">
   <input type = "submit" value = "로그인" > &nbsp;&nbsp;
  	</form>
   <input type = "button"  align = "right" value = "회원가입" onclick = "location.href = 'JoinServlet' ">
   </td>
</tr>

<tr><td colspan = "2">${message}</td></tr>

</table>
<br><br>
<img src = "img/in.jpg" width="400" border = "0" width = "100%">

</body>
</html>

 
