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
<title>管理_登録確認</title>
<link rel="stylesheet" href="/ecsiteproject/css/item_registerConfirm.css">
</head>
<body>
<form action="/ecsiteproject/ItemRegisterServlet" method="post">
<h1>登録確認</h1>
<p>この商品を登録しますか？</p>
<table border="1" style="border-collapse: collapse">
<tr>
<td>商品コード</td>
<td><input type="hidden" name="item_code" value="${itemes.item_code}">${itemes.item_code}</td>
</tr>
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
<td><textarea name="details" rows="" cols="" readonly>${itemes.details}</textarea></td>
</tr>
<tr>
<td>検索ワード</td>
<td><textarea name="serch_word" rows="" cols="" readonly>${itemes.serch_word}</textarea></td>
</tr>
</table>
<div>
<input type="submit" name="back" value="戻る">
<input type="submit" name="register_confirm" value="登録">
</div>
<p>${msg}</p>
<p>${emsg}</p>
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
<!-- <input type="submit" name="" value="戻る"> -->
<!-- <input type="submit" name="register_confirm" value="登録"> -->
<!-- </form> -->
</body>
</html>