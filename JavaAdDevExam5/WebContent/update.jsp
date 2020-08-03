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

.info_border0 {
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

  <h2>現在の登録情報</h2>

  <div class="info">
    <label>名前：</label> ${car.getCarName()}<br>
    <label>車体の色：</label> ${car.getBodyColor()} <br>
    <label>最高速度：</label> ${car.getMaxSpeed()} <br>
    <label>現在速度：</label> ${car.getSpeed()} <br>
  </div>

  <h2>変更</h2>

  <form action="updateServlet" method="post">
    <div class="info">
      <label>現在速度：</label> <input type="number" class="width-50" name="speed" value="${car.getSpeed()}">
      <br>
      <button type="submit" name="btn" value="update">変更</button> <br>
    </div>
    <div class="info_border0">
      <button type="submit" name="btn" value="back">最初に戻る</button>
    </div>
  </form>

</body>
</html>