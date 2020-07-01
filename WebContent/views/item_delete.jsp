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
<title>管理_商品削除</title>
<link rel="stylesheet" href="/ecsiteproject/css/admin_var.css">
<link rel="stylesheet" href="/ecsiteproject/css/item_delete.css">
</head>
<body>
<form action="/ecsiteproject/LogoutServlet" method="post" class="var">
<div class="title">管理者ページ</div>
<div class="title2">ー商品削除ー</div>
<div class="menue">
<input type="button" onclick="location.href='/ecsiteproject/views/item_serch.jsp'" value="商品検索">
<input type="button" onclick="location.href='/ecsiteproject/views/item_update.jsp'" value="商品変更">
<input type="button" onclick="location.href='/ecsiteproject/views/item_delete.jsp'" value="商品削除">
<input type="button" onclick="location.href='/ecsiteproject/views/item_register.jsp'" value="商品登録">
<input type="submit" name="" value="ログアウト">
</div>
</form>

<form action="/ecsiteproject/ItemServlet" method="post" class="form">
<div class="serch">
<div>商品コード<input type="text" name="item_code" value="${itemes.item_code}"></div>
<div><input type="submit" name="delete_view" value="検索">${emsg}</div>
</div>
<table border="1" style="border-collapse: collapse">
<tr>
<td>商品名</td>
<td><input type="hidden" name="item_name" value="${itemes.item_name}">${itemes.item_name}</td>
</tr>
<tr>
<td>フリガナ</td>
<td><input type="hidden" name="phonetic" value="${itemes.phonetic}">${itemes.phonetic}</td>
</tr>
<tr>
<td>著者</td>
<td><input type="hidden" name="author" value="${itemes.author}">${itemes.author}</td>
</tr>
<tr>
<td>出版社</td>
<td><input type="hidden" name="publisher" value="${itemes.publisher}">${itemes.publisher}</td>
</tr>
<tr>
<td>値段</td>
<td><input type="hidden" name="price" value="${itemes.price}">${itemes.price}</td>
</tr>
<tr>
<td>カテゴリ</td>
<td><input type="hidden" name="category" value="${itemes.category}">${itemes.category}</td>
</tr>
<tr>
<td>在庫数</td>
<td><input type="hidden" name="stock" value="${itemes.stock}">${itemes.stock}</td>
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
<input type="submit" name="delete" value="削除">
</form>


<!-- <form action="/ecsiteproject/ItemServlet" method="post"> -->
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
<!-- <input type="submit" name="delete_view" value="検索"> -->
<!-- <input type="submit" name="delete" value="削除"> -->
<!-- </form> -->
</body>
</html>