<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">
<head>
<%@ page isELIgnored="false" %>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>search - PARKnSHOP</title>
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
	 <%@include file="top.jsp"%>
	<div class="whitebg" >
	<div class="yasi normal" style="border-top:1px solid #DDD;">
		<!-- <h2 class="mosth2">Product Top10</h2> -->
		<ul class="pro_search">
			<c:forEach items="${list}" var="product">
				<li><div><a href="productChoose?id=${product.productId}"><img src="${product.imgAddr}"></img></a><a href=""><h1>${product.productDesc}</h1></a><p><span>￥${product.productPrice}</span></p><a href=""><h2>${produce.shopId}</h2></a></div></li>
			</c:forEach>
			</ul>
	  <div class="paging">
       <a>Previous</a>
        <%List list = (List)request.getAttribute("list");
       int size = list.size();
       int pages = size/10+1;
       %>
       <%if(pages>5){%>
    	   <a>1</a>
           <a>2</a>
           <a>3</a>
           <span>…</span>
           <a><%=pages %></a>
             <a>Next</a>
       <%}else{
    	   for(int i = 1;i<=pages;i++){
    	%>
    		   <a><%=i%></a>
       <%    }
       }
    	   %>
       <span>total</span>
       <span class="pages"><%=pages %></span>
       <span>pages,  to</span>
       <input type="text">
       <span>pages </span>
       <button>Go</button>
      </div>
	</div>
   </div>
	  <!-- 底部信息栏 -->
  <footer class="footer">
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
  </footer>
  <!-- 底部信息栏结束 -->	
		
</body>
</html>