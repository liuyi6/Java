<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login for Administrator</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="/mall/css/style.css" />
<style>
body{height:100%;background:url("/mall/images/bg_login_red2.jpg") center no-repeat;background-size: 100% 70%; overflow:hidden;}


canvas {
	z-index: -1;
	position: absolute;
}
</style>
<script src="/mall/js/jquery.js"></script>
<script src="/mall/js/verificationNumbers.js"></script>
<script src="/mall/js/Particleground.js"></script>
</head>

<body>
	<form action="/mall/admin/login" method="post">
		<dl class="admin_login">
			<dt>
				<strong>PARKnSHOP</strong> <em>Management System</em>
			</dt>
			<dd class="user_icon">
				<input type="text"  class="login_txtbx" name="name" />
			</dd>
			<dd class="pwd_icon">
				<input type="password" class="login_txtbx" name="password" />
			</dd>
			<dd>
				<input type="submit" value="Login" class="submit_btn" />
			</dd>
			<dd>
				<p>© 2017-2018 PARKnSHOP Copyright Infringement.</p>
				<p>ShanB2-20080224-1</p>
			</dd>
		</dl>
	</form>
</body>
</html>