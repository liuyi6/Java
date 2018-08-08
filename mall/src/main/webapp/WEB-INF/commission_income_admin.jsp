<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="/mall/js/amcharts.js" type="text/javascript"></script>
<script src="/mall/js/serial.js" type="text/javascript"></script>
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
 <h2><a href="index_admin.html"> Management System </a></h2>
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
				 <dd><a href="/mall/admin/income" class="active">Commission Income Query</a></dd>
				<dd>
					<a href="/mall/admin/rate">Commission Management</a>
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
       <h2 class="fl">Commission Income Query</h2>
      </div>
       <form action="/mall/admin/income" method="post">
       	<select id="select_time" class="select" name="selectWay">
       		<c:if test="${selectWay == 'day' || selectWay == null}">
        		<option value="day">per day</option>
       			<option value="week">per weeek</option>
       			<option value="month">per month</option>
       			<option value="year">per year</option>
			</c:if>
			<c:if test="${selectWay == 'week'}">
        		<option value="day">per day</option>
       			<option value="week" selected="selected">per weeek</option>
       			<option value="month">per month</option>
       			<option value="year">per year</option>
			</c:if>
			<c:if test="${selectWay == 'month'}">
        		<option value="day">per day</option>
       			<option value="week">per weeek</option>
       			<option value="month" selected="selected">per month</option>
       			<option value="year">per year</option>
			</c:if>
			<c:if test="${selectWay == 'year'}">
        		<option value="day">per day</option>
       			<option value="week">per weeek</option>
       			<option value="month">per month</option>
       			<option value="year" selected="selected">per year</option>
			</c:if>
       	</select>
       	<input id="input_time" type="date" class="input_time" name="date" value="${date }">
       	<input id="submit_time" type="submit" value="submit" class="group_btn">
       </form>
      <table class="table">
       <tr>

        <th>Order Quantity</th>
        <th>Commission Rates</th>
        <th>Commission Income</th>
        <th>Advertisement Income</th>
        <th>All Income</th>
       </tr>
       <tr>
       <c:if test="${income != null}">
       		<td>${income.amount }</td>
        	<td>${income.rate}</td>
       	 	<td>${income.orderIncome }</td>
       	 	<td>${income.advertisementIncome }</td>
       	 	<td>${income.advertisementIncome + income.orderIncome}</td> 
	   </c:if>
      </table>
   </div>
</section>

</body>
</html>
