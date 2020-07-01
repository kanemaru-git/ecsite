<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム画面</title>
<script type="text/javascript">
//history.pushState(null, null, location.href);
//window.addEventListener('popstate', (e) => {
  //history.go(1);
//});
</script>
<link rel="stylesheet" href="/ecsiteproject/css/index.css">
</head>
<body>
<c:forEach var="itemes" items="${itemes}" >
<form action="/ecsiteproject/ItemUserServlet" method="post" class="item_form">
<div class="item">
<input type="hidden" name="item_code" value="${itemes.item_code}">
<div class="dimg"><img alt="" src="/ecsiteproject/images/${itemes.item_code}.jpg" class="img"></div>
<div>作品：${itemes.item_name}<input type="hidden" name="item_name" value="${itemes.item_name}"></div>
<div>カテゴリ：${itemes.category}</div>
<div>価格：${itemes.price}円<input type="hidden" name="price" value="${itemes.price}"></div>
<div class="btn1"><input type="submit" name="details" value="商品詳細"></div>
<div class="btn2">
<select name="count">
    	<script>
		var i;
		//if("${itemes.category}" == "セット"){
			//for(i=1; i<=${itemes.stock}; i++){
				//document.write('<option value="'+i+'">'+i+'セット</option>');
		//}else{
		for(i=1; i<=${itemes.stock}; i++){
		if("${itemes.category}" == "セット"){
			document.write('<option value="'+i+'">'+i+'セット</option>');
		}else{
			document.write('<option value="'+i+'">'+i+'冊</option>');
		}
		}
		//}
		</script>
		</select>
</div>
<div class="btn3"><input type="submit" name="purchase" formaction="/ecsiteproject/ItemUserServlet" value="カート"></div>
</div>

</form>
</c:forEach>


<form action="/ecsiteproject/ItemUserServlet" method="post" class="serch_form">
<div class="logo">MANGA STORE</div>
<div class="username">ようこそ<span>${usernamesession}</span>さん</div>
<div class="menue">
<input type="text" name="keyword" value="${keyword}"><input type="submit" name="key_serch" formaction="/ecsiteproject/ItemUserServlet" value="検索">
<input type="hidden" name="category" value="">
<input type="hidden" name="sort" value="">
<input type="submit" name="cart" value="カート">
<input type="submit" name="history" value="購入履歴">
<input type="submit" name="logout" value="ログアウト" formaction="/ecsiteproject/LogoutServlet" >
</div>
</form>



<!-- 並び替え -->
<form action="/ecsiteproject/ItemUserServlet" method="post" class="sort_form">
<select name="sort">
<option value=""></option>
<option value="price">安価順</option>
<option value="price DESC">高価順</option>
<option value="phonetic">名前順</option>
</select>
<input type="submit" name="sort_serch" value="並び替え">
<input type="hidden" name="keyword" value="${keyword}">
<input type="hidden" name="category" value="${category}">
</form>



<form action="/ecsiteproject/ItemUserServlet" method="post" class="category_form">
<div>カテゴリ</div>
<div><input type="submit" name="category" value="冒険" class="csub"></div>
<div><input type="submit" name="category" value="恋愛" class="csub"></div>
<div><input type="submit" name="category" value="推理" class="csub"></div>
<div><input type="submit" name="category" value="スポーツ" class="csub"></div>
<div><input type="submit" name="category" value="学園" class="csub"></div>
<div><input type="submit" name="category" value="ギャグ" class="csub"></div>
<div><input type="submit" name="category" value="セット" class="csub"></div>
<input type="hidden" name="keyword" value="">
<input type="hidden" name="sort" value="">
</form>




<c:forEach var="itemes" items="${itemes}" >
<form action="/ecsiteproject/ItemUserServlet" method="post" class="item2">
  <tr>
  	<td><img alt="" src="/ecsiteproject/images/${itemes.item_code}.jpg"></td>
    <td>${itemes.item_code}<input type="hidden" name="item_code" value="${itemes.item_code}"></td>
    <td>${itemes.item_name}<input type="hidden" name="item_name" value="${itemes.item_name}"></td>
    <td>${itemes.price}<input type="hidden" name="price" value="${itemes.price}"></td>
    <td>${itemes.category}</td>
    <td><input type="submit" name="details" value="詳細"></td>
    <td>
    	<select name="count">
    	<script>
    		var i;
  		for(i=1; i<=${itemes.stock}; i++){
  		document.write('<option value="'+i+'">'+i+'冊</option>');
  		} -->
 		</script>
		</select>
    </td>
	<td><input type="submit" name="purchase" formaction="/ecsiteproject/ItemUserServlet" value="購入"></td>
  </tr>
</form>
</c:forEach>
 <p class="emsg">${emsg}</p>
</body>
</html>