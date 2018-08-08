<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>Product Information</title>
	<meta name="description" content="">
	<meta name="keywords" content=""><!--网站关键词-->
	<meta name="Description" Content=""><!--网站简介-->
	<link rel="stylesheet" href="/mall/sell/css/common.css" type="text/css" />
	<link rel="stylesheet" href="/mall/sell/css/main.css" type="text/css" />
	<script type="text/javascript" src="/mall/sell/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/mall/sell/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="/mall/sell/js/jquery.SuperSlide.2.1.1.js"></script>
	<script type="text/javascript" src="/mall/sell/js/main.js"></script>
	<script type="text/javascript" src="/mall/sell/js/cookie_util.js"></script>
	<script type="text/javascript">
        $(function(){
            var productId=getCookie("productId");
            var shopName=getCookie("shopName");
            $.ajax({
                url: "/mall/product/findByProductId.do",
                type: "post",
                data: {"productId": productId},
                dataType: "json",
                success:function(result){
                    var pro=result.data;
                    var price=pro.productPrice;
                    var name=pro.productName;
                    var punum=pro.purchaseNum;
                    var path=pro.imgAddr;
                    var desc=pro.productDesc;
                    $("#productName").html(name);
                    $("#price").html("price:"+price);
                    $("#shopName").html("shop_name:"+shopName);
                    $("#sales").html("sales:"+punum);
                    $("#desc").html(desc);
                    document.getElementById("myImage").src=path;


                }

            })

        })


	</script>
</head>
<body>
<div class="nav_header">
	<div class="w">
		<div class="user_info">
        <span class="user not_login">
          <a class="link" href="index.html">Hi, welcome to PARKnSHOP !</a>
          <a class="link js_login">Login or Register</a>
        </span>
			<span class="user login">
          <span class="link_text">Hi,
            <a class="link username" >username</a>
          </span>
          <a class="link js_logout">Exit</a>
        </span>
		</div>
		<ul class="nav_list">
			<li class="nav_item myshop">
				<img src="/mall/sell/images/index/shop_32px.png" ></img>
				<a id="shop" class="link"> My Shop </a>
			</li>
			<li class="nav_item">
				<img src="/mall/sell/images/index/shopping_cart_32px.net.png" ></img>
				<a id="cart" class="link">
					Shopping Cart ( <span class="cart_count">0</span> )
				</a>
			</li>
			<li class="nav_item">
				<a id="my_order" class="link">Orders</a>
			</li>
			<li class="nav_item">
				<a id="my_ltt"  class="link">Personal Center</a>
			</li>
			<li class="nav_item">
				<a class="link">About PARKn</a>
			</li>
		</ul>
	</div>
</div>


<div class="biaoti">
	<span>Detail</span>
	<div class="biaoti1">Commodity Detail<p>Your Location：<a href="">Commodity</a> > <a href="" class="on">Commodity_name</a></p></div>
</div>

<div class="normal dnews">

	<div class="dnleft">
		<div class="info-t" id="productName" ></div>
		<div class="info-sp"><span id="price"></span>    <span id="shopName"></span>
			<span id="sales"> </span><div class="bdsharebuttonbox">

				<a href="#" class="bds_sqq" data-cmd="sqq" title="share to QQ"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="share to  wechat"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="share to siga"></a><a href="#" class="bds_qzone" data-cmd="qzone" title="share to QQ zone"></a>

			</div>
			<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		</div>
		<div class="info-c">
			<div class="buybuy" ><a href="addOrderss" class="" id="pay">Buy it!</a><p><a href="addcollect">Favourite</a></p><p class=""><a href="addCart">Add to cart</a></p></div>
			<img id="myImage" src="">
			<span id="desc"></span>

		</div>
		<div class="sxpian">
			<div>Prev commodity:<a href=""></a></div>
			<div>Next commodity:<a href=""></a></div>
		</div>


	</div>
<!--  
	<div class="dnright">

		<h2 class="xuxian1">Remark<a href="">MORE+</a></h2>
		<p class="border"></p>

		<ul class="ul3" style="padding-left: 0px">

			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>
			<li><a href=""></a></li>

		</ul>



	</div>

-->
</div>





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

</body>
</html>