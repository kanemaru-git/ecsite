<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${usernamesession == null}">
<jsp:forward page="/views/login.jsp"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//history.pushState(null, null, location.href);
//window.addEventListener('popstate', (e) => {
  //history.go(1);
//});
</script>
<link rel="stylesheet" href="/ecsiteproject/css/history.css">
</head>
<body>
<h2>MANGA STORE</h2>
<h1>購入履歴</h1>
<div class="btn1">
<input type="button" onClick="history.back()" value="戻る">
</div>


<c:forEach var="history" items="${history}" >
<form action="/ecsiteproject/ItemUserServlet" method="post" class="item_form">
<div class="item">
  	<div class="dimg"><img alt="" src="/ecsiteproject/images/${history.item_code}.jpg" class="img"></div>
    <div class="dname">${history.item_name}</div>
    <div class="dprice">${history.price}円</div>
    <div class="dcount">×${history.count}冊＝</div>
    <div class="dsum">${history.price*history.count}円</div>
    <div class="ddate">${history.date}</div>
    <div class="ddetails"><input type="submit" name="details" value="商品詳細"></div>
</div>
<input type="hidden" name="item_code" value="${history.item_code}">
</form>
</c:forEach>
<p class="emsg">${emsg}</p>
<div class="btn2">
<input type="button" onClick="history.back()" value="戻る">
</div>

<%-- <c:forEach var="history" items="${history}" > --%>
<!-- <form action="/ecsiteproject/ItemUserServlet" method="post"> -->
<!--   <tr> -->
<%--   	<td><img alt="" src="/ecsiteproject/images/${history.item_code}.jpg"></td> --%>
<%--     <td>${history.item_code}<input type="hidden" name="item_code" value="${history.item_code}"></td> --%>
<%--     <td>${history.item_name}</td> --%>
<%--     <td>${history.price}</td> --%>
<%--     <td>${history.count}</td> --%>
<%--     <td>${history.date}</td> --%>
<!--     <td><input type="submit" name="details" value="詳細"></td> -->
<!--   </tr> -->
<!-- </form> -->
<%-- </c:forEach> --%>


</body>
</html>