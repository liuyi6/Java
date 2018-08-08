<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<title>customer login</title>
	<link rel="stylesheet" type="text/css" href="user/css/reset.css">
	<link rel="stylesheet" type="text/css" href="user/css/cus_main.css">
	<script type="text/javascript" src="user/js/cus.js"></script>
</head>
<body>
	<div class="head" style="background: white;border-bottom: 2px solid #F1F1F1;box-shadow: 10px 2px #F1F1F1">
		<b>Welcome</b>
	</div>

	<div style="background:#E93854; ">
		<div style="background-image: url(user/images/login_bac.png);height: 440px;padding-top: 20px;background-repeat: no-repeat;background-position: center;">
			<div class="login_box">
				<div class="login_innerbox">
					<div id="form1">
						<form action="login" method="post">
						<li class="login_box_li">Account</li>
						<li class="login_box_li"><input type="text" name="account" class="login_box_input user_icon" placeholder=""></li>
						<li class="login_box_li">Password</li>
						<li class="login_box_li"><input type="password" name="password" class="login_box_input"></li>
						<li class="login_box_li"><a href="verify.jsp" style="padding-left: 180px;">Password recovery</a></li>
						<li><input type="submit" value="login" class="login_btn" style="color: white;font-size: 20px"></li>
						<li style="margin-top: 30px;"><a href="registers" style="padding-left:250px;color: #e80012;font-size: 13px;"><b>Register</b></a></li>
						</form>
					</div>
				</div>
			</div>		
		</div>
	</div>


	<div class="footer" style="border-top: 2px solid #F1F1F1;box-shadow: 10px 2px #F1F1F1">	
		<ul>
	      <li>About Us</li>
	 	  <li>Contact Us</li>
	 	  <li>Terms of Service</li>
	 	  <li>Privacy Agreement</li>
	 	  <li>Help</li>
	    </ul>
	 	<div class="companyName">
	 	  <p>Group 3 of Project Management</p>
	 	</div>
	</div>
</body>
</html>