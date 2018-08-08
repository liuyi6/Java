<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta charset="UTF-8">
	<title>customer register</title>
	<link rel="stylesheet" type="text/css" href="user/css/reset.css">
	<link rel="stylesheet" type="text/css" href="user/css/cus_main.css">
	<script type="text/javascript" src="user/js/cus.js"></script>
</head>
<body>
	<div class="head" style="border-bottom: 2px solid #F1F1F1;box-shadow: 10px 2px #F1F1F1">
	<b>Register</b>
	</div>

	<div class="register_box">
		<div class="register_innerbox">
			<form action="register" method="post">
			<div style="width:900px;float: left;">
				<div class="register_div">
				<label>Account</label>
				<input type="text" name="user_name" class="login_box_input1" id="account" >
				</div>
				<div class="register_tips">
					<div class="img"><img id="img1"></div>
					<p id="tips1" class="tips"></p>
				</div>
			</div>		
			<div style="width: 900px;float: left;">	
				<div class="register_div">
					<label>Password</label>
					<input type="password" name="password" class="login_box_input1" id="pwd1" >
				</div>
				<div class="register_tips">
					<div class="img"><img id="img2"></div>
					<p id="tips2" class="tips"></p>
				</div>
			</div>
			<div style="width: 900px;float: left;">
				<div class="register_div">
					<label>Confirm</label>
					<input type="password" name="confirm_password" placeholder="confirm the password" class="login_box_input1" id="pwd2">
				</div>
				<div class="register_tips">
					<div class="img"><img id="img3"></div>
					<p id="tips3" class="tips"></p>
				</div>
			</div>
			<div style="width: 900px;float: left;">
				<div class="register_div">
					<label>Address</label>
					<input type="text" name="address" class="login_box_input1" id="address">
				</div>
				<div class="register_tips">
					<div class="img"><img id="img5"></div>
					<p id="tips5" class="tips"></p>
				</div>
			</div>
			<div style="width: 900px;float: left;">
				<div class="register_div">
					<label>Telephone</label>
					<input type="text" name="phone" class="login_box_input1" id="tel">
				</div>
				<div class="register_tips">
					<div class="img"><img id="img6"></div>
					<p id="tips6" class="tips"></p>
				</div>
			</div>
			<div class="register_div" style="border: none;">
				<input type="submit" value="register now" class="register_btn">
			</div>
			</form>
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