<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用課題</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
  <h1>ペット情報追加</h1>

  <div class="info">
    <h2>ペット種類選択</h2>
    <form action="petAddServlet">
		<button class="btn" type="submit" name="btn" value="cat">猫</button>
		<button class="btn" type="submit" name="btn" value="dog">犬</button>
		<button class="btn" type="submit" name="btn" value="lizard">トカゲ</button>
    </form>
  </div>

  <form action="petList.jsp">
    <button class="btn" type="submit">戻る</button>
  </form>

  <form action="startServlet">
    <button class="btn" type="submit">先頭に戻る</button>
  </form>
</body>
</html>