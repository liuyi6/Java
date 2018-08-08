<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Management System - PARKnSHOP </title>
<link rel="stylesheet" type="text/css" href="/mall/css/style.css">
<script src="/mall/js/jquery.js"></script>
<script src="/mall/js/jquery.mCustomScrollbar.concat.min.js"></script>
<script>

	(function($){
		$(window).load(function(){
			
			$("a[rel='load-content']").click(function(e){
				e.preventDefault();
				var url=$(this).attr("href");
				$.get(url,function(data){
					$(".content .mCSB_container").append(data); //load new content inside .mCSB_container
					//scroll-to appended content 
					$(".content").mCustomScrollbar("scrollTo","h2:last");
				});
			});
			
			$(".content").delegate("a[href='top']","click",function(e){
				e.preventDefault();
				$(".content").mCustomScrollbar("scrollTo",$(this).attr("href"));
			});
			
		});
	})(jQuery);
	$(document).ready(function(){
	});

</script>
<script type="text/javascript" src="/mall/js/stlect_time.js"></script>
<script src="js/amcharts.js" type="/mall/text/javascript"></script>
<script src="js/serial.js" type="/mall/text/javascript"></script>
<script src="/mall/js/pie.js" type="text/javascript"></script>
<script type="text/javascript" src="/mall/js/statistic_chart.js"></script>
</head>
<body>
<!--header-->
<header>
  <img src="/mall/images/logo_management_128px.png"></img>
   <div class="logo_admin" > 
	<h1 >PARKnSHOP </h1>
    <p>Management System</p>
  </div>

 <ul class="rt_nav">
  <li><a href="/mall/admin" class="quit_icon">Exit Safely</a></li>
 </ul>
</header>
<!--aside nav-->
<!--aside nav-->
<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="#"> Management System </a></h2>
 <ul>
		<li>
			<dl>
				<dt>Shop Management</dt>
				<!--当前链接则添加class:active-->
				<dd>
					<a href="/mall/admin/apply/1">Shop Owner Request</a>
				</dd>
				<dd>
					<a href="/mall/admin/query/shop/1" >Shop Owner
						Management</a>
				</dd>
				<dd>
					<a href="/mall/admin/query/shop/blacklist">Shop Owner Blacklist</a>
				</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>Customer Magagement</dt>
				<dd>
					<a href="/mall/admin/query/user/1">Customer Magagement</a>
				</dd>
				<dd>
					<a href="/mall/admin/query/user/blacklist">Customer Blacklist</a>
				</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>Order Magagement</dt>
				<dd>
					<a href="/mall/admin/search/order">Order Tracking</a>
				</dd>
				<dd>
					<a href="/mall/admin/query/order">Sales Record Query</a>
				</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>Sales Management</dt>
				 <dd><a href="/mall/admin/income" >Commission Income Query</a></dd>
				<dd>
					<a href="/mall/admin/rate" class="active">Commission Management</a>
				</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>Advertising Management</dt>
				<dd>
					<a href="/mall/admin/query/advertisement/shop">Shop Advertising</a>
				</dd>
				<dd>
					<a href="/mall/admin/query/advertisement/product/1">Product Advertising</a>
				</dd>
			</dl>
		</li>
		<li>
			<p class="btm_infor">© PARKNSHOP.com Copyright Infringement</p>
		</li>
	</ul>
</aside>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">Commission Management</h2>
      </div>
      <div class="rate_current">
      	<p>Current Commission : <span> ${rate*100 } </span> %</p>
      </div>
      <div  class="rate_new">
      	<form action="/mall/admin/rate" method="post">
      		<p>New Commission : <input type="text" class="textbox rate_textbox" name="adjustRate"> %</p>	
		    <input type="submit" value="submit" class="group_btn rate_btn"> 
      	</form>
	  </div>
	</div>
</section>

</body>
</html>
