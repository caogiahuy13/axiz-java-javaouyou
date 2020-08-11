<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="jp.co.axiz.servlet.PetSessionInfo" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	PetSessionInfo petSessionInfo = (PetSessionInfo) session.getAttribute("petSessionInfo");
	String dogName = petSessionInfo.getPetList().get("dog").getName();
	String catName = petSessionInfo.getPetList().get("cat").getName();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用課題</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
  <h1>ペット情報管理</h1>

  <div class="info">
    <h2>ペット一覧</h2>
    <form action="petListServlet">
      <button class="btn" type="submit" name="btn" value="dog"><%= dogName %></button>
      <button class="btn" type="submit" name="btn" value="cat"><%= catName %></button>
    </form>
  </div>

  <form action="index.jsp">
    <button class="btn" type="submit">先頭に戻る</button>
  </form>
</body>
</html>