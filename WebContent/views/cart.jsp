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
<title>カート</title>
<script type="text/javascript">
//history.pushState(null, null, location.href);
//window.addEventListener('popstate', (e) => {
  //history.go(1);
//});
</script>
<link rel="stylesheet" href="/ecsiteproject/css/cart.css">
</head>
<body>
<h2>MANGA STORE</h2>
<h1>カート</h1>
<p class="emsg">${emsg}</p>

<c:forEach var="cart" items="${cart}" >
<form action="/ecsiteproject/ItemUserServlet" method="post" class="item_form">
<div class="item">
  	<div class="dimg"><img alt="" src="/ecsiteproject/images/${cart.item_code}.jpg" class="img"></div>
    <div class="dname">${cart.item_name}</div>
    <div class="dprice">${cart.price}円</div>
    <div class="dcount">×${cart.count}冊＝</div>
    <div class="dsum">小計${cart.price*cart.count}円</div>
    <div class="ddetails"><input type="submit" name="details" value="詳細"></div>
    <div class="ddelete"><input type="submit" name="delete_cart" formaction="/ecsiteproject/ItemUserServlet" value="カートから削除"></div>
</div>
<input type="hidden" name="item_code" value="${cart.item_code}">
</form>
</c:forEach>

<p class="sum">${sum}</p>



<%-- <c:forEach var="cart" items="${cart}" > --%>
<!-- <form action="/ecsiteproject/ItemUserServlet" method="post" class="item_form"> -->
<!-- <table class="item_table"> -->
<!--   <tr> -->
<%--   	<td><img alt="" src="/ecsiteproject/images/${cart.item_code}.jpg"></td> --%>
<%--     <td>${cart.item_code}<input type="hidden" name="item_code" value="${cart.item_code}"></td> --%>
<%--     <td>${cart.item_name}</td> --%>
<%--     <td>${cart.price}</td> --%>
<%--     <td>${cart.count}</td> --%>
<%--     <td>小計${cart.price*cart.count}</td> --%>
<!--     <td><input type="submit" name="details" value="詳細"></td> -->
<!--     <td><input type="submit" name="delete_cart" formaction="/ecsiteproject/ItemUserServlet" value="削除"></td> -->
<!--   </tr> -->
<!-- </table> -->
<!-- </form> -->
<%-- </c:forEach> --%>

<form action="/ecsiteproject/ItemUserServlet" method="post" class="btn_form">
<input type="submit" name="cart_back" value="戻る">
<!-- <input type="button" onClick="history.back()" value="戻る"> -->
<input type="submit" name="purchase_confirm" formaction="/ecsiteproject/ItemUserServlet" value="購入">
</form>
<!-- <div> -->
<!-- <p>お届け先</p> -->
<%-- <p>${usersession.name}</p> --%>
<%-- <p>${usersession.post}</p> --%>
<%-- <p>${usersession.address}</p> --%>
<!-- </div> -->


</body>
</html>