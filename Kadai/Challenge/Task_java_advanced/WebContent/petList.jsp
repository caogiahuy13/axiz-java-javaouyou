<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="jp.co.axiz.servlet.PetSessionInfo, jp.co.axiz.pet.Pet, java.util.TreeMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	PetSessionInfo petSessionInfo = (PetSessionInfo) session.getAttribute("petSessionInfo");
	request.setAttribute("treeMap", new TreeMap<String, Pet>(petSessionInfo.getPetList()));
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

  <c:if test = "${not empty msg}">
    <p class="update-msg"><c:out value = "${msg}"/></p>
  </c:if>

  <div class="info">
    <h2>ペット一覧</h2>
    <form action="petListServlet">
	  <c:forEach items="${treeMap}" var="entry">
	  	<button class="btn" type="submit" name="btn" value="${entry.key}">
	  		${entry.getValue().getName()}
	  	</button>
	  </c:forEach>
    </form>
  </div>

  <form action="petType.jsp">
    <button class="btn" type="submit">ペット追加</button>
  </form>
  <form action="index.jsp">
    <button class="btn" type="submit">先頭に戻る</button>
  </form>
</body>
</html>