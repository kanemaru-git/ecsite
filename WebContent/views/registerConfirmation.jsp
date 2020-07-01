<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録確認</title>
<link rel="stylesheet" href="/ecsiteproject/css/registerConfirm.css">
</head>
<body>
<h2>MANGA STORE</h2>
<form action="/ecsiteproject/registerServlet" method="post">
<h1>登録確認</h1>
<p class="p">この内容で登録しますか？</p>
<table border="1" style="border-collapse: collapse">
<caption>アカウント</caption>
<tr>
<td>ユーザー名</td>
<td><input type="hidden" name="username" value="${msg.username}">${msg.username}</td>
</tr>
<tr>
<td>パスワード</td>
<td><input type="hidden" name="password" value="${msg.password}">${msg.password}</td>
</tr>
</table>


<table border="1" style="border-collapse: collapse">
<caption>商品お届け先</caption>
<tr>
<td>お名前</td>
<td><input type="hidden" name="name" value="${msg.name}">${msg.name}</td>
</tr>
<tr>
<td>郵便番号</td>
<td><input type="hidden" name="post" value="${msg.post}">${msg.post}</td>
</tr>
<tr>
<td>住所</td>
<td><input type="hidden" name="address" value="${msg.address}">${msg.address}</td>
</tr>
</table>
<div>
<input type="button" onclick="location.href='/ecsiteproject/views/register.jsp'" value="書き直す">
<input type="submit" name="confirmation" value="登録">
</div>
<p>${msg.messege}</p>
</form>




<!-- <form action="/ecsiteproject/registerServlet" method="post"> -->
<%-- <p>ユーザー名<input type="text" name="username" value="${msg.username}"></p> --%>
<%-- <p>パスワード<input type="text" name="password" value="${msg.password}"></p> --%>
<%-- <p>パスワード確認<input type="text" name="password2" value="${msg.password2}"></p> --%>
<!-- <p>商品お届け先</p> -->
<%-- <p>お名前<input type="text" name="name" value="${msg.name}"></p> --%>
<%-- <p>郵便番号<input type="text" name="post" value="${msg.post}"></p> --%>
<%-- <p>住所<input type="text" name="address" value="${msg.address}"></p> --%>
<!-- <p><input type="submit" name="confirmation" value="登録確定"></p> -->
<!-- </form> -->
<!-- <input type="button" onclick="location.href='/ecsiteproject/views/register.jsp'" value="書き直す"> -->
</body>
</html>