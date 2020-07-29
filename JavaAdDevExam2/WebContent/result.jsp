<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果画面</title>
</head>
<body>
	<p>よこそ、<c:out value = "${fn:escapeXml(id)}"/>さん</p>
	<a href="<c:url value = "/login"/>">戻る</a>
</body>
</html>