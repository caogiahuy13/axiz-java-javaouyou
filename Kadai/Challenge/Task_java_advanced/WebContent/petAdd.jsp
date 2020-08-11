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
	<h1>ペット情報管理</h1>

	<div class="update">
	    <h3>
	    	ペット種類：
	    	<c:choose>
				<c:when test = "${petType eq 'cat'}">猫</c:when>
				<c:when test = "${petType eq 'dog'}">犬</c:when>
				<c:when test = "${petType eq 'lizard'}">トカゲ</c:when>
	      	</c:choose>
	    </h3>

		<form action="petAddServlet" method="post">
			<table class="petInfoTable">
		      <tr>
		        <th>名前：</th>
		        <td><input type="text" style="margin: 1px" name="name"  required></td>
		      </tr>
		      <tr>
		        <th>年齢：</th>
		        <td><input type="number" style="margin: 1px" name="age" ></td>
		      </tr>
		      <tr>
		        <th>体長：</th>
		        <td><input type="number" style="margin: 1px" name="height" ></td>
		      </tr>
		      <tr>
		        <th>体重：</th>
		        <td><input type="number" style="margin: 1px" name="weight" ></td>
		      </tr>
		      <c:if test="${isAnimal eq true}">
				<tr>
					<th>種別：</th>
			        <td><input type="text" style="margin: 1px" name="type" ></td>
				</tr>
		      </c:if>
		      <c:if test="${petType eq 'cat'}">
				<tr>
					<th>お気に入り遊具：</th>
			        <td><input type="text" style="margin: 1px" name="favoriteItem" ></td>
				</tr>
		      </c:if>
		      <c:if test="${petType eq 'dog'}">
				<tr>
					<th>散歩場所：</th>
			        <td><input type="text" style="margin: 1px" name="walkingPlace" ></td>
				</tr>
		      </c:if>
			</table>

			<input type="hidden" name="petType" value="<c:out value = "${petType}"/>">
			<input type="hidden" name="isAnimal" value="<c:out value = "${isAnimal}"/>">
			<button class="btn-update" type="submit">追加する</button>
		</form>
  	</div>

  	<form action="petType.jsp">
    	<button class="btn" type="submit">戻る</button>
	</form>

  	<form action="startServlet">
    	<button class="btn" type="submit">先頭に戻る</button>
  	</form>
</body>
</html>