<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題4(発展)</title>
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

  <h1>Java応用 - 演習問題4(発展)</h1>

  <h2>ファイル取込</h2>

  <h3>取り込むデータを選択してください</h3>

  <form action="importServlet" method="post">
    <p>
    <select name="data">
      <option value="cat">ネコ</option>
      <option value="rabbit">ウサギ</option>
    </select>
    </p>
    <button type="submit">実行</button>
  </form>
</body>
</html>