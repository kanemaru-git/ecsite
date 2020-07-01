<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
history.pushState(null, null, location.href);
window.addEventListener('popstate', (e) => {
  history.go(1);
});
</script>
<link rel="stylesheet" href="/ecsiteproject/css/purchase_confirm.css">
</head>
<body>
<h2>MANGA STORE</h2>
<h1>この内容で購入しますか？</h1>



<form action="/ecsiteproject/ItemUserServlet" method="post" class="item_form">
<c:forEach var="cart" items="${cart}" >
<div class="item">
  	<div class="dimg"><img alt="" src="/ecsiteproject/images/${cart.item_code}.jpg" class="img"></div>
    <div class="dname">${cart.item_name}</div>
    <div class="dprice">${cart.price}円</div>
    <div class="dcount">×${cart.count}冊＝</div>
    <div class="dsum">小計${cart.price*cart.count}円</div>
</div>
<input type="hidden" name="username" value="${cart.username}">
<input type="hidden" name="item_code" value="${cart.item_code}">
  <input type="hidden" name="item_name" value="${cart.item_name}">
  <input type="hidden" name="price" value="${cart.price}">
  <input type="hidden" name="count" value="${cart.count}">
</c:forEach>
<p class="sum">${sum}</p>
<table>
<caption>商品お届け先</caption>
<tr>
<td>お名前</td>
<td><input type="text" name="name" value="${usersession.name}"></td>
</tr>
<tr>
<td>郵便番号</td>
<td><input type="text" name="post" value="${usersession.post}"></td>
</tr>
<tr>
<td>住所</td>
<td><input type="text" name="address" value="${usersession.address}"></td>
</tr>
<tr>
</table>
</form>

<form action="/ecsiteproject/ItemUserServlet" method="post" class="btn">
 <input type="submit" name="purchase_back" value="戻る">
<!-- <input type="button" onClick="history.back()" value="戻る"> -->
<input type="submit" name="purchase_finish" value="購入">
<c:forEach var="cart" items="${cart}" >
<input type="hidden" name="username" value="${cart.username}">
<input type="hidden" name="item_code" value="${cart.item_code}">
  <input type="hidden" name="item_name" value="${cart.item_name}">
  <input type="hidden" name="price" value="${cart.price}">
  <input type="hidden" name="count" value="${cart.count}">
</c:forEach>
</form>


<!-- <form action="/ecsiteproject/ItemUserServlet" method="post"> -->
<%-- <c:forEach var="cart" items="${cart}" > --%>
<!--   <tr> -->
<%-- 	<td><img alt="" src="/ecsiteproject/images/${cart.item_code}.jpg"></td> --%>
<%--     <td>${cart.item_code}</td> --%>
<%--     <td>${cart.item_name}</td> --%>
<%--     <td>${cart.price}</td> --%>
<%--     <td>${cart.count}</td> --%>
<%--     <td>小計${cart.price*cart.count}</td> --%>
<!--   </tr> -->
<%--   <input type="hidden" name="username" value="${cart.username}"> --%>
<%-- <input type="hidden" name="item_code" value="${cart.item_code}"> --%>
<%--   <input type="hidden" name="item_name" value="${cart.item_name}"> --%>
<%--   <input type="hidden" name="price" value="${cart.price}"> --%>
<%--   <input type="hidden" name="count" value="${cart.count}"> --%>
<%-- </c:forEach> --%>
<!-- <input type="submit" name="purchase_finish" value="購入"> -->
<!-- <input type="submit" name="purchase_back" value="戻る"> -->
<!-- </form> -->




<p>${emsg}</p>
</body>
</html>