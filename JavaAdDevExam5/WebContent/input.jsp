<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題5(発展)</title>
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

.info {
  border: solid 2px #4682b4;
  border-radius: 20px;
  width: 260px;
  margin: 5px;
  padding: 10px;
}

.info label {
    display: inline-block;
    width: 80px;
    text-align: right;
}

.width-50 {
    width: 50px;
}


</style>
</head>
<body>

  <h1>Java応用 - 演習問題5(発展)</h1>

  <c:if test="${not empty result}">
    <div class="result">
      <p>${result}</p>
    </div>
  </c:if>

  <h2>車の登録</h2>

  <div class="info">
    <form action="inputServlet" method="post">
      <label>名前：</label> <input type="text" name="carName"> <br>
      <label>車体の色：</label> <input type="text" name="bodyColor"> <br>
      <label>最高速度：</label> <input type="number" class="width-50" name="maxSpeed"> <br>
      <button type="submit">登録</button>
    </form>
  </div>
</body>
</html>