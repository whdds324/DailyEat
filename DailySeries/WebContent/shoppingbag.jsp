<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>장바구니</title>
<link rel ="stylesheet" href="style.css">
<script type="text/javascript" src="shoppingbag.js">
	
</script>

</head>
<body>
	<div class="main3">
			
	<h3>orderlist</h3>
	
	<table class = "list" border="1">
	
	<tr><th>매장명</th> <th>메뉴</th> <th>가격</th><th>주문번호</th> </tr>
	<form action = "/BagServlet" method="post" name="frm">
	 <c:forEach var = "orderlist" items = "${orderlist}">
	 
	 <tr >
	 	<td name ="storename">${orderlist.storename}</td>
	 	<td name="menu">${orderlist.menu}</td>
	 	<td class ="price" name="price">${orderlist.price}</td>
	 	<td name="orderid">${orderlist.orderid}</td>
		<td><input type="button" value="삭제" onclick ="alert('삭제 되었습니다.'),location.href='/deleteServlet?orderid=${orderlist.orderid}'"></td>
	</tr>
	
	 
	
	</c:forEach>
	</table>
	</form>
		<br>
		
	총액 : ${totalprice}원 입니다.
	
	<input type = "submit"  value="바로결제" onclick = "alert('결제 되었습니다.'),location.href='/ChargeServlet'">
	
	<input type = "button"  value="닫기" onclick = "window.close()">
	
		</div> 
</body>
</html>