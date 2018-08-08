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
	 <div class="nav_header">
    <div class="w">
      <div class="user_info">
        <span class="user not_login">
          <a class="link" href="index">Hi, welcome to PARKnSHOP !</a>
          <a href="logins" class="link js_login">Login or Register</a>
        </span>
        <span class="user login">
          <span class="link_text">Hi,
            <a class="link username" >${customer.userName}</a>
          </span>
          <a class="link js_logout">Exit</a>
        </span>
      </div>
  <ul class="nav_list">
        <li class="nav_item">
          <img src="user/images/index/shopping_cart_32px.net.png" ></img>
            <a id="cart" class="link" href="cart"  style="text-decoration:none">Shopping Cart</a>
        </li>
        <li class="nav_item">
          <a href="queryorders?pageId=1&state=5" id="my_order" class="link" style="text-decoration:none">Orders</a>
        </li>
        <li class="nav_item">
          <a id="my_ltt"  class="link" href="customerCenter?pageId=1"  style="text-decoration:none">Personal Center</a>
        </li>
        <li class="nav_item">
          <img src="user/images/index/shop_32px.png" ></img>
            <a id="shop" class="link"> My Shop </a>
        </li>
      </ul>

    </div>
  </div>
</body>
</html>