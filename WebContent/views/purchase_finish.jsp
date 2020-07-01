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
	text-align:center;
	border-top: 2px solid black;
	padding-top: 20px;
}
</style>
</head>
<body>
<h2>MANGA STORE</h2>
<h1>ご購入ありがとうございました。</h1>

<form action="/ecsiteproject/ItemUserServlet" method="post">
<input type="submit" name="buy" value="買い物を続ける">
<input type="hidden" name="keyword" value="人気">
<input type="hidden" name="category" value="">
<input type="hidden" name="sort" value="">
</form>
<p>${emsg}</p>
</body>
</html>