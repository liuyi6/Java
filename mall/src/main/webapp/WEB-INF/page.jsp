<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page isELIgnored="false" %>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>pages</title>
</head>
<body>
	<div class="changePage" style="height:30px;width:100%;background-color:white;text-align:right;line-height:30px;font-size:14px;">
		<a href="queryorders?pageId=1&state=${state}" style="text-decoration:none;cursor:pointer;" id="first">首页</a>
		<a href="queryorders?pageId=${page.currentPage-1}&state=${state}" style="text-decoration:none;cursor:pointer;" >上一页</a> 
		<font>${page.currentPage}/${page.allPage}</font> 
		<a href="queryorders?pageId=${page.currentPage+1}&state=${state}" style="text-decoration:none;cursor:pointer;" >下一页</a>
		<a href="queryorders?pageId=${page.allPage}&state=${state}" style="text-decoration:none;cursor:pointer;">尾页</a> 
		<font>每页5条记录</font>
	</div>
</body>
</html>