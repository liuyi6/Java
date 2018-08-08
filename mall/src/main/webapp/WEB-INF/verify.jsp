<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>verification</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta charset="UTF-8">
    
    <link rel="stylesheet" type="text/css" href="css/verify.css">

  </head>
  
  <body>
    <div class="login-container">
    	<div class="login-wrapper">
    		<div class="login-panel">
    			<div class="panel-header">
    				<div class="login-tab">
    					<a>verify the account</a>
    				</div>
    			</div>
    			<div class="panel-body">
    				<div class="form-group">
    					<input class="form-phone" type="text" placeholder="mobilephone"/>
    				</div>
    				<div class="form-group">
    					<input class="form-code" type="text" placeholder="verification code"/>
    					<button id="btn-code">get code</button>
    				</div>
    				<div class="form-group">
    					<button class="btn-login">submit</button>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
  </body>
</html>