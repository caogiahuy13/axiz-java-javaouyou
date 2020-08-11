<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ page import="jp.co.axiz.pet.Pet" %>
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
  <h1>ペット情報管理</h1>
  <div class="info">
    <h2>ペット情報</h2>

    <table class="petInfoTable">
      <tr>
        <th>名前：</th>
        <td><c:out value = "${name}"/></td>
      </tr>
      <tr>
        <th>年齢：</th>
        <td><c:out value = "${age}"/></td>
      </tr>
      <tr>
        <th>体長：</th>
        <td><c:out value = "${height}"/></td>
      </tr>
      <tr>
        <th>体重：</th>
        <td>
        	<c:out value = "${weight}"/>
        	<c:if test = "${(isAnimal eq true) && (isFat eq true)}">
        		<span class="error">※太り気味です</span>
        	</c:if>
        </td>
      </tr>
      <c:if test = "${isAnimal eq true}">
	      <tr>
	        <th>種別：</th>
	        <td><c:out value = "${type}"/></td>
	      </tr>
	      <tr>
	        <th><c:out value = "${optionTitle}"/>：</th>
	        <td><c:out value = "${option}"/></td>
	      </tr>
      </c:if>
      <c:if test = "${isReptile eq true}">
      	  <c:if test = "${isDangerous eq true}">
      	  </c:if>
	      <tr>
	        <td colspan="2"><span class="dangerous">※危険です</span></td>
	      </tr>
      </c:if>
    </table>
  </div>

  <div class="update">
    <h3>ペット情報変更</h3>
	<form action="petInfoServlet" method="post">
    	名前： <input type="text" style="margin: 1px" name="name" value="<c:out value = "${name}"/>"><br>
    	<c:if test = "${isAnimal eq true}">
    		体重： <input type="text" style="margin: 1px" name="weight" value="<c:out value = "${weight}"/>"><br>
    	</c:if>
    	<input type="hidden" name="pet" value="<c:out value = "${pet}"/>">

		<button class="btn-update" type="submit">変更する</button>
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