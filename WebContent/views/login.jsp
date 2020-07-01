<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-color: orange;
}
h2{
	margin-left: 20px;
	margin-right: 20px;
	border-bottom: 1px solid black;
}
h1{
	text-align:center;
}
form{
	text-aligin:center;
}
table{
	margin:10px auto;
}
div{
	text-align:center;
	border-bottom:1px solid black;
	padding-bottom:10px;
}
p{
	text-align:center;
}
</style>
</head>
<body>
<h2>MANGA STORE</h2>
<h1>ログイン画面</h1>
<form action="/ecsiteproject/LoginServlet" method="post">
<table>
<tr>
<td>ユーザー名</td>
<td><input name="username" type="text" value="${loginBean.username}"></td>
</tr>
<tr>
<td>パスワード</td>
<td><input name="password" type="text" value="${loginBean.password}"></td>
</tr>
</table>
<p class="emsg">${loginBean.emsg}</p>
<div><input type="submit" value="ログイン"></div>
</form>
<p>アカウントをお持ちでない方はこちら<input type="button" onclick="location.href='/ecsiteproject/views/register.jsp'" value="アカウント作成"></p>
</body>

</html>