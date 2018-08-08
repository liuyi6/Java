<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>PARKnSHOP</title>
	<meta name="description" content="">
	<meta name="keywords" content=""><!--网站关键词-->
	<meta name="Description" Content=""><!--网站简介-->
	<link rel="stylesheet" href="user/css/common.css" type="text/css" />
	<link rel="stylesheet" href="user/css/main.css" type="text/css" />
	<script type="text/javascript" src="user/js/jquery-1.11.3.min.js"></script>	
	<script type="text/javascript" src="user/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="user/js/jquery.SuperSlide.2.1.1.js"></script>
	<script type="text/javascript" src="user/js/main.js"></script>
	<script type="text/javascript" src="user/js/serach.js"></script>
	</head>
<body>
	<div class="whitebg">
		<div class="normal top2">
			<div class="logo"><a href=""><img src="user/images/index/shop_red_64px.png"><h2>PARKnSHOP</h2><p>welcome to PARKnSHOP !</p></a></div>
			<div class="search">
			  <select id="select">
			    <option>product</option>
			    <option>shop</option>
			  </select>
			  <input type="text" name="productName" class="text" id="text" placeholder="Please enter the product name">
			  <input type="button" value="search" class="search_btn" id="serach" onclick="serach()">
			</div>
		</div>
	</div>
		
</body>
</html>