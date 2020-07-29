<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<div>
  <form action="login" method="post">
  	<c:if test = "${not empty inputError}">
		<div>${inputError}</div>
		<br>
	</c:if>
    <div>
    	ID: <input type="text" name="id">
    	<c:if test = "${not empty idError}">
			<span>${idError}</span>
		</c:if>
    </div>
    <div>
    	PASS: <input type="password" name="password">
		<c:if test = "${not empty passwordError}">
			<span>${passwordError}</span>
		</c:if>
    </div>
    <div><button type="submit">ログイン</button></div>
  </form>
</div>
</body>
</html>