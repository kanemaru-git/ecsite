<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isLogin != 1}">
<jsp:forward page="/views/login.jsp"></jsp:forward>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理_商品登録</title>
<link rel="stylesheet" href="/ecsiteproject/css/admin_var.css">
<link rel="stylesheet" href="/ecsiteproject/css/item_register.css">
</head>
<body>
<form action="/ecsiteproject/LogoutServlet" method="post" class="var">
<div class="title">管理者ページ</div>
<div class="title2">ー商品登録ー</div>
<div class="menue">
<input type="button" onclick="location.href='/ecsiteproject/views/item_serch.jsp'" value="商品検索">
<input type="button" onclick="location.href='/ecsiteproject/views/item_update.jsp'" value="商品変更">
<input type="button" onclick="location.href='/ecsiteproject/views/item_delete.jsp'" value="商品削除">
<input type="button" onclick="location.href='/ecsiteproject/views/item_register.jsp'" value="商品登録">
<input type="submit" name="" value="ログアウト">
</div>
</form>


<form action="/ecsiteproject/ItemRegisterServlet" method="post" class="form">
<div class="serch">
商品情報を入力して、登録してください。
</div>
<table>
<tr>
<td>商品コード</td>
<td><input type="text" name="item_code" value="${itemes.item_code}"></td>
</tr>
<tr>
<td>商品名</td>
<td><input type="text" name="item_name" value="${itemes.item_name}"></td>
</tr>
<tr>
<td>フリガナ</td>
<td><input type="text" name="phonetic" value="${itemes.phonetic}"></td>
</tr>
<tr>
<td>著者</td>
<td><input type="text" name="author" value="${itemes.author}"></td>
</tr>
<tr>
<td>出版社</td>
<td><input type="text" name="publisher" value="${itemes.publisher}"></td>
</tr>
<tr>
<td>値段</td>
<td><input type="text" name="price" value="${itemes.price}" oninput="value = value.replace(/[^0-9]+/i,'');"></td>
</tr>
<tr>
<td>カテゴリ</td>
<td><input type="text" name="category" value="${itemes.category}"></td>
</tr>
<tr>
<td>在庫数</td>
<td><input type="text" name="stock" value="${itemes.stock}" oninput="value = value.replace(/[^0-9]+/i,'');"></td>
</tr>
<tr>
<td>商品詳細</td>
<td><textarea name="details" rows="" cols="">${itemes.details}</textarea></td>
</tr>
<tr>
<td>検索ワード</td>
<td><textarea name="serch_word" rows="" cols="">${itemes.serch_word}</textarea></td>
</tr>
</table>
<input type="submit" name="register" value="登録">
<p>${emsg}</p>
<p>${isBlank}</p>
</form>





<!-- <form action="/ecsiteproject/ItemRegisterServlet" method="post"> -->
<%-- <p>商品コード<input type="text" name="item_code" value="${itemes.item_code}"></p> --%>
<%-- <p>商品名<input type="text" name="item_name" value="${itemes.item_name}"></p> --%>
<%-- <p>フリガナ<input type="text" name="phonetic" value="${itemes.phonetic}"></p> --%>
<%-- <p>著者<input type="text" name="author" value="${itemes.author}"></p> --%>
<%-- <p>出版社<input type="text" name="publisher" value="${itemes.publisher}"></p> --%>
<%-- <p>値段<input type="text" name="price" value="${itemes.price}"></p> --%>
<%-- <p>カテゴリ<input type="text" name="category" value="${itemes.category}"></p> --%>
<%-- <p>在庫数<input type="text" name="stock" value="${itemes.stock}"></p> --%>
<%-- <p>商品詳細<textarea name="details" rows="" cols="">${itemes.details}</textarea></p> --%>
<%-- <p>検索ワード<textarea name="serch_word" rows="" cols="">${itemes.serch_word}</textarea></p> --%>

<!-- <input type="submit" name="register" value="登録"> -->
<!-- </form> -->

</body>
</html>