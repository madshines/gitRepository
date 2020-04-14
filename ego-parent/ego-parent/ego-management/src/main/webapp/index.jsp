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
	<form action="insertPic" enctype="multipart/form-data" method="post">
		广告图片：<input type="file" name="file" value="请选择文件"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>