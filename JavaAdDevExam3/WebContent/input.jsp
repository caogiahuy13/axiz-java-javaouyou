<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題3(発展)</title>
<style>
body {
    border: solid 2px #000080;
    padding: 5px;
}

.box {
    background: #fffacd;
    display: inline-block; margin : 5px;
    padding: 10px;
    margin: 5px;
}

.box label {
    display: inline-block;
    width: 70px;
    text-align: right;
}
</style>
</head>
<body>

  <h1>Java応用 - 演習問題3(発展)</h1>

  <h2>人物登録</h2>

  <form action="inputServlet" method="post">

    <p>簡易登録</p>

    <div class="box">
      <label>出身地：</label> <select name="birthPlace">
        <option value="" selected></option>
        <option value="japan">日本</option>
        <option value="america">アメリカ</option>
      </select>
    </div>
    <button type="submit" name="btn" value="simple">登録</button>
  </form>

  <form action="inputServlet" method="post">

    <p>詳細登録</p>

    <div class="box">
      <label>名前：</label> <input type="text" name="name"> <br>
      <label>言語：</label> <input type="text" name="language"> <br>
      <label>出身地：</label> <select name="birthPlace">
        <option value="" selected></option>
        <option value="japan">日本</option>
        <option value="america">アメリカ</option>
      </select>
    </div>
    <button type="submit" name="btn" value="details">登録</button>
  </form>

</body>
</html>