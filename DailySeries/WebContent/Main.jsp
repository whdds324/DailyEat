<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!doctype html>
<html>
<head>
  <title>오늘 뭐하지?</title>
  <meta charset="utf-8">
 <link rel="stylesheet" href="style.css">

 </head>
<body>
 	
  <div id="topgrid">
	<h1><a href="/Main.jsp"><div onmouseover="this.style.color='coral'" onmouseout="this.style.color='black'">오늘 뭐하지?</div></a></h1>
  </div>	
	
	<div id="grid">
		<div class ="leftmenu">
			<table border="1">
			 	<tr><td colspan="2">아이디 : ${loginuser}</td></tr> <br>
			 	<tr> <td><input type = "button" value="my page" onclick = "location.href = 'MypageServlet'"></td>  
			 	<form method="post" action="logout.jsp">
				<td><input type = "submit" value="로그아웃"></td> </tr>
				</form>	
			</table>
			
				<h3>오늘의 날씨</h3>
   		<p>
   			<a href ="https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=${addr}+
						날씨" align="center" onmouseover="this.style.color='coral'" onmouseout="this.style.color='black'" 
						target ="_blank">회원님의 주소 (${addr}) 날씨 보기.</a>
   		</p>
    			
				
			
		</div>
		
		<div class="main1">
			<h3 align="center"><a target="_blank" href="https://opentutorials.org/course/3084" onmouseover="this.style.color='coral'" onmouseout="this.style.color='black'">오늘의 코딩</a></h3>
    		<p style="margin-left:70px">
        	<iframe width="700" height="500" src="https://www.youtube.com/embed/F9GujgK0y2M" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        	</p>
		</div>
		
		<div class="main2">
		
			 <h3 align = "center">오늘의 명언.</h3>
		
				
				<div  align="center">
					${kortxt}<br>
					${engtxt}<br>
					<span align="center">${speaker}</span><br><br>

				</div>
			<form action = "/MainServlet" method = "post" name="frm">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type = "submit" value="다른 명언 보기">
			</form>
		</div>
		
		<div class="main3">
			 <h3 align = "center">오늘 뭐먹지?</h3>
<table border = "1" align ="center">	

<tr>
<td><img src = "img/H.jpg" width = "150" height="120" align = "center"><a href = "/MenudetailServlet?type=H">특식</a></td>
<td><img src = "img/A.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=A">한식</a></td>
<td><img src = "img/B.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=B">중식</a></td>
</tr>
<tr>
<td><img src = "img/C.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=C">일식</a></td>
<td><img src = "img/00.jpg" width = "150" height="120" align = "center"></td>
<td><img src = "img/D.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=D">양식</a></td>
</tr>

<tr>
<td><img src = "img/reco.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?addr=${addr}">추천</a></td>
<td><img src = "img/F.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=F">인도/멕시칸</a></td>
<td><img src = "img/G.jpg" width = "150" height="120" align = "center"><a href ="/MenudetailServlet?type=G">간편식</a></td>
</tr>

		</div>
		
	</div>
  
  </body>
  </html>
