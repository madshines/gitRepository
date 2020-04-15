<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead align="center">产品信息列表</thead>
		<tbody>
		<c:forEach items="${selectProduct }" var="sel">
			<tr>
				<td>${sel.id }</td>
				<td>${sel.name }</td>
				<td>${sel.origin }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>