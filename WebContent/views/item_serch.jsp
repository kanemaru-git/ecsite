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
<title>管理_商品検索</title>
<link rel="stylesheet" href="/ecsiteproject/css/admin_var.css">
<link rel="stylesheet" href="/ecsiteproject/css/item_serch.css">
</head>
<body>
<form action="/ecsiteproject/LogoutServlet" method="post" class="var">
<div class="title">管理者ページ</div>
<div class="title2">ー商品検索ー</div>
<div class="menue">
<input type="button" onclick="location.href='/ecsiteproject/views/item_serch.jsp'" value="商品検索">
<input type="button" onclick="location.href='/ecsiteproject/views/item_update.jsp'" value="商品変更">
<input type="button" onclick="location.href='/ecsiteproject/views/item_delete.jsp'" value="商品削除">
<input type="button" onclick="location.href='/ecsiteproject/views/item_register.jsp'" value="商品登録">
<input type="submit" name="" value="ログアウト">
</div>
</form>
<form action="/ecsiteproject/ItemServlet" method="post" class="serch">
<div><input type="submit" name="all" value="すべて表示"></div>
<div>商品コード<input type="text" name="item_code"></div>
<div><input type="submit" name="serch" value="検索"></div>
<div>${emsg}</div>
</form>
<div class="th" id="th">
<div class="a">商品コード</div>
    <div class="b">商品名</div>
    <div class="c">フリガナ</div>
    <div class="d">著者</div>
    <div class="e">出版社</div>
    <div class="f">値段</div>
    <div class="g">カテゴリ</div>
    <div class="h">在庫数</div>
    <div class="i">商品詳細</div>
    <div class="j">検索ワード</div>
    <div class="k">編集</div>
    <div class="l">削除</div>
</div>
<table border="1" style="border-collapse: collapse">
<thead>
  <tr>
    <th width="100px">商品コード</th>
    <th width="100px">商品名</th>
    <th width="100px">フリガナ</th>
    <th width="100px">著者</th>
    <th width="100px">出版社</th>
    <th width="100px">値段</th>
    <th width="100px">カテゴリ</th>
    <th width="100px">在庫数</th>
    <th width="100px">商品詳細</th>
    <th width="200px">検索ワード</th>
    <th width="200px">編集</th>
    <th width="100px">削除</th>
  </tr>
</thead>
<tbody>
<c:forEach var="itemes" items="${itemes}" >
<form action="/ecsiteproject/ItemUpdateServlet" method="post">
<tr>
    <td class="1" width="100px">${itemes.item_code}<input type="hidden" name="item_code" value="${itemes.item_code}"></td>
    <td class="2" width="100px">${itemes.item_name}</td>
    <td class="3" width="100px">${itemes.phonetic}</td>
    <td class="4" width="100px">${itemes.author}</td>
    <td class="5" width="100px">${itemes.publisher}</td>
    <td class="6" width="100px">${itemes.price}</td>
    <td class="7" width="100px">${itemes.category}</td>
    <td class="8" width="100px">${itemes.stock}</td>
    <td class="9" width="100px"><textarea rows="" cols="" readonly>${itemes.details}</textarea></td>
    <td class="10" width="100px"><textarea rows="" cols="" readonly>${itemes.serch_word}</textarea></td>
    <td class="11" width="100px"><input type="submit" name="view" value="変更"></td>
    <td class="12" width="100px"><input type="submit" name="delete_view" formaction="/ecsiteproject/ItemServlet" value="削除"></td>
</tr>
</form>
</c:forEach>
</tbody>
</table>
<script type="text/javascript">
var th = document.getElementById("th");

window.addEventListener('scroll', _handleScroll, false);

function _handleScroll() {
  th.style.left = -window.scrollX + "px";
}

</script>

</body>
</html>