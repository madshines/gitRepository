<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>插入键值</h2>
<form action="setString" method="post">
	<input type="text" name="str"/>
	<input type="submit" value="提交"/>
</form>

<h2>根据键查找键值</h2>
<form action="getString" method="post">
	<input type="text" name="key"/>
	<input type="submit" value="提交"/>
</form>

<h2>查看list长度</h2>
<form action="getListSize" method="post">
	<input type="text" name="key"/>
	<input type="submit" value="提交"/>
</form>

<h2>查看list内容</h2>
<form action="getListContext" method="post">
	<input type="text" name="key"/>
	<input type="text" name="begin"/>
	<input type="text" name="end"/>
	<input type="submit" value="提交"/>
</form>

<h2>查看list内容</h2>
<form action="getListContextIndex" method="post">
	<input type="text" name="key"/>
	<input type="text" name="index"/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>