<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="/ecsiteproject/css/details.css">
</head>
<body>
<!-- <form action="/ecsiteproject/ItemUserServlet" method="post"> -->
<!-- BOOKSTORE -->
<!-- <input type="text" name="keyword"><input type="submit" name="key_serch" formaction="/ecsiteproject/ItemUserServlet" value="検索"> -->
<%-- <input type="hidden" name="category" value="${category}"> --%>
<%-- <input type="hidden" name="sort" value="${sort}"> --%>
<!-- <input type="submit" name="cart" value="カート"> -->
<!-- <input type="submit" name="history" value="購入履歴"> -->
<!-- <input type="submit" name="history" value="アカウント"> -->
<!-- </form> -->
<!-- <form action="/ecsiteproject/ItemUserServlet" method="post"> -->
<!-- <input type="submit" name="category" value="漫画"> -->
<!-- <input type="submit" name="category" value="小説"> -->
<!-- <input type="submit" name="category" value="児童書"> -->
<%-- <input type="hidden" name="keyword" value="${keyword}"> --%>
<%-- <input type="hidden" name="sort" value="${sort}"> --%>
<!-- </form> -->
<h2>MANGA STORE</h2>
<h1>${itemes.item_name}</h1>

<div class="item">
	<div class="dimg"><img alt="" src="/ecsiteproject/images/${itemes.item_code}.jpg" class="img"></div>
	<div class="app">
		<div class="author">著者：${itemes.author}</div>
		<div class="publisher">出版元：${itemes.publisher}</div>
		<div class="price">価格：${itemes.price}円</div>
	</div>
	<div><textarea class="textarea" readonly>${itemes.details}</textarea></div>
</div>


<form action="/ecsiteproject/ItemUserServlet" method="post">
<input type="button" onClick="history.back()" value="戻る">
<select name="count">
    	<script>
		var i;
		for(i=1; i<=${itemes.stock}; i++){
		document.write('<option value="'+i+'">'+i+'冊</option>');
		}
		</script>
</select>
		<input type="submit" name="purchase" formaction="/ecsiteproject/ItemUserServlet" value="購入">
		<input type="hidden" name="item_code" value="${itemes.item_code}">
		<input type="hidden" name="item_name" value="${itemes.item_name}">
		<input type="hidden" name="price" value="${itemes.price}">
		<input type="hidden" name="category" value="${itemes.category}">
</form>


<!-- <form action="/ecsiteproject/ItemUserServlet" method="post"> -->
<!--   <tr> -->
<%--   	<td><img alt="" src="/ecsiteproject/images/${itemes.item_code}.jpg"></td> --%>
<%--     <td>${itemes.item_code}<input type="hidden" name="item_code" value="${itemes.item_code}"></td> --%>
<%--     <td>${itemes.item_name}<input type="hidden" name="item_name" value="${itemes.item_name}"></td> --%>
<%--     <td>${itemes.price}<input type="hidden" name="price" value="${itemes.price}"></td> --%>
<%--     <td>${itemes.category}<input type="hidden" name="category" value="${itemes.category}"></td> --%>
<%--     <td>${itemes.details}</td> --%>
<!--   </tr> -->
<!--   <select name="count"> -->
<!--     	<script> -->
<!--  		var i; -->
<!--  		for(i=1; i<=${itemes.stock}; i++){ -->
<!--  		document.write('<option value="'+i+'">'+i+'冊</option>'); -->
<!--  		} -->
<!-- 		</script> -->
<!-- 		<input type="submit" name="purchase" formaction="/ecsiteproject/ItemUserServlet" value="購入"> -->
<!-- </form> -->
</body>
</html>