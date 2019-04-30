<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
  <title>오늘 뭐하지?</title>
  <meta charset="utf-8">
 <link rel="stylesheet" href="style.css">
</head>
<body>
  <h1><a href="/Main.jsp">오늘 뭐하지?</a></h1>
  <div id="grid">
  	<div class="left">
  			<table border="1">
			 	<tr><td colspan="2">아이디 : ${loginuser}</td></tr> <br>
			 	<tr> <td><input type = "button" value="my page" onclick = "location.href = 'MypageServlet'"></td>  
				<td><input type = "button" value="로그아웃" onclick = "location.href = 'LoginServlet' "></td> </tr>	
			</table>	
  
    		<ul style="padding-left:20px;">
    			<form action = "/MainServlet" method = "post" name="frm">
				<li ><input type = "submit" value="오늘의 명언"></li>
				</form>
				<li><input type = "button" value="오늘의 날씨" onclick ="location.href = 'Weather.jsp'"></li>
				<li><input type = "button" value="오늘의 식사" onclick ="location.href = 'Food.jsp'"></li>
			</ul>
	</div>
    <div id="article">
        <h3 align = "center">오늘 뭐먹지?</h3>
<table border = "1" align ="center">	

<tr>
<td><a href = "/MenudetailServlet?type=H"><img src = "C:\Users\krit\Desktop\HTML실습\\8.jpg" width = "150" align = "center"></a>특식</td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\1.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=A">찌개</a></td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\2.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=B">덮밥/복음밥</a></td>
</tr>
<tr>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\7.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=C">해장</a></td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\00.jpg" width = "150"align = "center"></td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\3.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=D">면</a></td>
</tr>

<tr>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\6.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=E">오늘의 추천</a></td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\5.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=F">간편식</a></td>
<td><img src = "C:\Users\krit\Desktop\HTML실습\\4.jpg" width = "150"align = "center"><a href ="/MenudetailServlet?type=G">국/탕</a></td>
</tr>
  </div>
  </body>
  </html>
