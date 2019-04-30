<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
  <title>오늘 뭐하지?</title>
  <script type ="text/javascript" src ="join.js"></script>
  <meta charset="utf-8">

<style>
	body {
		background-color:#606c88;
	}
</style>
</head>
<body>
  <h1 align="center"><a href="/Main.jsp">오늘 뭐하지?</a></h1>
  <div id="grid">
  	<div class="left" align="center">

  
	</div>
    <div id="article">
        <h3 align = "center">my page</h1>
<h4 align ="center">회원정보 관리</h4>
<form action = "/JoinServlet" method="post" name="frm">
<table align ="center" border="1">
<tr>
   <td> 아이디 </td>
   <td> 
     ${loginuser}
     
      
   </td>
</tr>

<tr>
  <td> 이름 </td>
  <td> 
   ${username}
   
  </td>
</tr>

<tr>
  <td> 비밀번호 </td>
  <td> ${password} </td>
</tr>

<tr>
   <td> 주소 </td>
   <td> ${addr} </td>
</tr>

<tr>
   <td> 출생년대</td>
   <td>
   		${birthyear}
   </td>
</tr>


<tr>
   <td colspan = "2" align ="center">
    <a href ="/Main.jsp"><input type = "button" value ="메인으로"></a>
  <input type = "button" value="변경하기" onclick = "location.href = 'ChangeServlet'">
   <input type = "reset" value ="회원탈퇴" onclick ="deletemember()">
      </td>
</tr>


</table>
      </div>
  </div>
  </body>
  </html>
