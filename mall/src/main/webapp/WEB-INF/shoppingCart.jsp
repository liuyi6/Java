<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<%@ page isELIgnored="false" %>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>shopping cart</title>
    <link rel="stylesheet" href="user/css/reset.css">
    <link rel="stylesheet" href="user/css/carts.css">
    <link rel="stylesheet" href="user/css/common.css" type="text/css" />
	<link rel="stylesheet" href="user/css/main.css" type="text/css" />
	<script type="text/javascript" src="user/js/jquery-1.11.3.min.js"></script>	
	<script type="text/javascript" src="user/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="user/js/jquery.SuperSlide.2.1.1.js"></script>
	<script type="text/javascript" src="user/js/main.js"></script>
	<script type="text/javascript" src="user/js/pay.js"></script> 
	<script type="text/javascript" src="user/js/carts.js"></script>  
</head>
<body>
    <%@include file="top.jsp"%>
	<%@include file="top2.jsp"%>
<!--   购物车展示 -->
   
    <section class="cartMain">
        <div class="cartMain_hd">
            <ul class="order_lists cartTop">
                <li class="list_chk">
                    <!--所有商品全选-->
                    <input type="checkbox" id="all" class="whole_check">
                    <label for="all"></label>
                    SelectAll
                </li>
                <li class="list_con">Product Information</li>
                <li class="list_info">Product parameters</li>
                <li class="list_price">Unit Price</li>
                <li class="list_amount">Quantity</li>
                <li class="list_sum">Amount</li>
                <li class="list_op">Operation</li>
            </ul>
        </div>
        
		<c:forEach items="${list}" var="cart">
        <div class="cartBox">
         <div class="shop_info">
                <div class="shop_name">
                    Shop：<a>${cart.shop.shopName}</a>
                </div>
           </div>
            <div class="order_content">
                <ul class="order_lists">
                    <li class="list_chk">
                        <input type="checkbox" id="checkbox_${cart.cartId}" class="son_check" name="checkItem" value="${cart.cartId}">
                        <label for="checkbox_${cart.cartId}"></label>
                        <input type="hidden" value="${cart.product.productId}" class="productshow"></input>
                        <input type="hidden" value="${cart.shop.shopId}" class="shopshow"></input>
                    </li>
                    <li class="list_con">
                        <div class="list_img"><a href="javascript:;"><img src="${cart.product.imgAddr}" alt=""></a></div>
                        <div class="list_text"><a>${cart.product.productName}</a></div>
                    </li>
                    <li class="list_info">
                        <p>${cart.product.productDesc }</p>
                    </li>
                    <li class="list_price">
                        <p class="price">￥${cart.product.productPrice}</p>
                    </li>
                    <li class="list_amount">
                        <div class="amount_box">
                            <a href="javascript:;" class="reduce reSty">-</a>
                            <input type="text" value="${cart.amount}" class="sum">
                            <a href="javascript:;" class="plus">+</a>
                        </div>
                    </li>
                    <li class="list_sum">
                        <p class="sum_price">￥${cart.product.productPrice*cart.amount}</p>
                    </li>
                    <li class="list_op">
                        <p class="del"><a href="deleteCart?cartId=${cart.cartId}" class="delBtn">Remove</a></p>
                    </li>
                </ul>  
            </div>
        </div>
        </c:forEach>
        
        <!--底部-->
        <div class="bar-wrapper">
            <div class="bar-right">
                <div class="piece">Selected Products<strong class="piece_num">0</strong>pieces</div>
                <div class="totalMoney">Total: <strong class="total_text">0.00</strong></div>
                <div class="calBtn"><a href="javascript:;" id="pay">Pay</a></div>
            </div>
        </div>
    </section>
    <section class="model_bg"></section>
    <section class="my_model">
        <p class="title">Delete Product<span class="closeModel">X</span></p>
        <p>Are you sure you want to delete this product?</p>
        <div class="opBtn"><a href="javascript:;" class="dialog-sure">Sure</a><a href="javascript:;" class="dialog-close">Close</a></div>
    </section>
	
    <script src="js/jquery.min.js"></script>
    <script src="js/carts.js"></script>
	
</body>
</html>
