<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員登録完了</title>
<script type="text/javascript">
history.pushState(null, null, location.href);
window.addEventListener('popstate', (e) => {
  history.go(1);
});
</script>
<style type="text/css">
body{
	background-color: orange;
}
h2{
	margin-left: 20px;
	margin-right: 20px;
	border-bottom: 1px solid black;
}
div{
	margin-left: 20px;
}
</style>
</head>
<body>
<h2>MANGA STORE</h2>
<div>登録が完了いたしました。<input type="button" name="login" onclick="location.href='/ecsiteproject/views/login.jsp'" value="ログイン画面へ"></div>
</body>
</html>