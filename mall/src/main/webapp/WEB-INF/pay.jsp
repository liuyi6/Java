<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%@ page isELIgnored="false" %>
    <title>payment</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta charset="UTF-8">
    
    <link rel="stylesheet" type="text/css" href="user/css/pay.css" >

  </head>
  
  <body>
    <div class="pay-container">
		
		<div style="text-align: center; width: 100%; border: none; padding-top: 100px">
			<img src="user/images/pay.png" style="margin: 0 auto;" />
		</div>
		<br>
		<div style="text-align: center; width: 100%; border: none; padding-bottom: 100px;">
			<a href="pay?id=${ordersDetail.orderDetailId}">
			<button style="text-decoration:none;margin: 0 auto; font-size: 20px; border: 1px solid #1979CA; display: block; width: 18%; color: #fff; background-color: #1979CA;cursor:pointer;">payment
</button>
			</a>
		</div>
    </div>
  </body>
</html>