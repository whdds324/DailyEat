<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title >오늘 뭐하지? - 회원가입</title>
<script type="text/javascript" src="join.js"> 
	
</script>
<style>
	body {background-color:#606c88;}
</style>
</head>
<h1 align = "center">오늘 뭐하지?</h1>
<h2 align ="center">회원가입</h2>
<form action = "/JoinServlet" method="post" name="frm">
<table align ="center">
<tr>
   <td> 아이디 </td>
   <td> 
      <input type ="text" name="userid" size = "20" id="userid" onchange="checkID()" placeholder="ex) 4글자 이상의 ID">*
      <input type = "hidden" name = "reid" size ="20">
      <input type = "button" value="중복체크" onclick = "idCheck()" >
   </td>
</tr>

<tr>
  <td> 이름 </td>
  <td> <input type = "text" name = "name" size="20" placeholder="ex) 홍길동"  onchange="checkName()">*</td>
</tr>

<tr>
  <td> 비밀번호 </td>
  <td> <input type = "password" name = "password" size="20">*</td>
</tr>

<tr>
  <td> 비밀번호 확인 </td>
  <td> <input type = "password" name = "repassword" size="20" onchange="pwcheck()">*</td>
</tr>


<tr>
   <td> 주소 </td>
   <td> <input type = "text" name = "addr" size = "20">*</td>
</tr>

<tr>
   <td> 출생년대 </td>
   <td>
   		<select name = "birthyear">
   		 <option value = "1900">1900</option>*<option value = "1910">1910</option>*<option value = "1920">1920</option>*<option value = "1930">1930</option>*<option value = "1940">1940</option>*<option value = "1950">1950</option>*<option value = "1960">1960</option>*<option value = "1970">1970</option>*<option value = "1980">1980</option>*<option value = "1990">1990</option>*<option value= "2000">2000</option>*<option value = "2010">2010</option>*<option value = "2020">2020</option>*  
   		</select>
   </td>
</tr>


<tr>
   <td colspan = "2" align ="center">
   <input type = "submit" value ="확인" onclick = "location.href = 'Login.jsp'">
     
   <input type = "reset" value ="취소">
   <input type = "button"  value = "로그인" onclick = "location.href = 'LoginServlet' ">
   </td>
</tr>
<tr><td colspan = "2">${message}</td></tr>

</table>
</form>
<br>
<div align="cneter" style = "margin-left: 730px;">
<img src = "img/people.jpg" width = "400">
</div>
</body>
</html>

 
