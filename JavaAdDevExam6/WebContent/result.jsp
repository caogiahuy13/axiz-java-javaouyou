<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- todoと書かれている部分の処理を修正してください -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題6(発展)</title>
<style>
body {
    border: solid 2px #000080;
    padding: 5px;
}

.result {
    background: #fffacd;
    display: inline-block;
    margin: 5px;
    padding: 10px;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題6(発展)</h1>
  <div class="result">
    <p>商品が登録されました</p>
  </div>

  <div>
    <a href="input.jsp">戻る</a>
  </div>

  <h2>現在の登録情報</h2>

  <table border="1">
    <tr>
      <th>商品名</th>
      <th>金額</th>
    </tr>

    <!-- c:forEachについて
         javaの拡張for文にあたるものである
         items属性に配列やコレクションを指定する
         var属性に配列などから取り出した値を保存する変数名を指定する(型の指定は不要)
         items属性に配列やコレクションを指定する
         ここでは、セッションに保存した商品情報(List型)の
         値(productオブジェクト)を取り出し、
         そのオブジェクトのゲッターメソッドを呼び、
         商品名などを表示する
    -->
    <!-- todo:
         下記の<tr>～</tr>タグ部分の4行をc:forEachタグで囲み、
         登録されている商品の数だけ、その4行が繰り返し表示されるようにする
         <td>タグで囲まれている部分を修正し、登録されている
         商品の情報(商品名と金額)を表示する
    -->
	<c:forEach items="${sessionScope.productList}" var="prod">
		<tr>
        	<td>${prod.getName()}</td>
        	<td>${prod.getPrice()}</td>
      	</tr>
	    ${item}<br>
	</c:forEach>

  </table>
</body>
</html>