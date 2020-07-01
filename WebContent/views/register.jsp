<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新規会員登録</title>
<script type="text/javascript">
//history.pushState(null, null, location.href);
//window.addEventListener('popstate', (e) => {
  //history.go(1);
//});
</script>
<link rel="stylesheet" href="/ecsiteproject/css/register.css">
</head>
<body>
<h2>MANGA STORE</h2>
<form action="/ecsiteproject/registerServlet" method="post" class="form">
<h1>新規会員登録</h1>
<div class="serch">
このページは新規会員登録ページです。すでにアカウントをお持ちの方はこちらから
<input type="submit" name="login" onclick="location.href='/ecsiteproject/views/login.jsp'" value="ログイン">
して下さい。
</div>
<table>
<caption>アカウント</caption>
<tr>
<td>ユーザー名</td>
<td><input type="text" name="username" value="${msg.username}"></td>
</tr>
<tr>
<td>パスワード</td>
<td><input type="text" name="password" value="${msg.password}"></td>
</tr>
<tr>
<td>パスワード確認</td>
<td><input type="text" name="password2" value="${msg.password2}"></td>
</tr>
</table>

<table>
<caption>商品お届け先</caption>
<tr>
<td>お名前</td>
<td><input type="text" name="name" value="${msg.name}"></td>
</tr>
<tr>
<td>郵便番号</td>
<td><input type="text" name="post" value="${msg.post}"></td>
</tr>
<tr>
<td>住所</td>
<td><input type="text" name="address" value="${msg.address}"></td>
</tr>
<tr>
</table>
<input type="submit" name="register" value="登録">
<p>${msg.messege}</p>
<p>${msg.passmsg}</p>
<p>${msg.empmsg}</p>
</form>







<!-- <form action="/ecsiteproject/registerServlet" method="post"> -->
<%-- <p>ユーザー名<input type="text" name="username" value="${msg.username}"></p> --%>
<%-- <p>パスワード<input type="text" name="password" value="${msg.password}"></p> --%>
<%-- <p>パスワード確認<input type="text" name="password2" value="${msg.password2}"></p> --%>
<!-- <p>商品お届け先</p> -->
<%-- <p>お名前<input type="text" name="name" value="${msg.name}"></p> --%>
<%-- <p>郵便番号<input type="text" name="post" value="${msg.post}"></p> --%>
<%-- <p>住所<input type="text" name="address" value="${msg.address}"></p> --%>
<!-- <p><input type="submit" name="register" value="登録"></p> -->
<!-- <input type="submit" name="login" onclick="location.href='/ecsiteproject/views/login.jsp'" value="ログイン画面へ"> -->
<!-- </form> -->
<%-- <p>${msg.messege}</p> --%>
<%-- <p>${msg.passmsg}</p> --%>
<%-- <p>${msg.empmsg}</p> --%>
</body>
</html>