<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>图片</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pics }" var="pic">
			<tr>
				<td><img src="pic/${pic.path }" width="100px" height="100px"/></td>
				<td><a href="delete?id=${pic.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>