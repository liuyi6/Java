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
	<title>PARKnSHOP</title>
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
	<%@include file="top2.jsp"%>
	
	<div class="bg">
		<div class="nav">
		  <div class="bigbig" id="index">
		    <a href="" class="navon li1a">Categories</a>
		  <div class="area">
		    <ul>
		      
		        <li class="ca1">
		        <h2>TV & Home Theater</h2>
		        <div id="ca1" class="ca kongbaige">
		          <ul class="ca_detail">	           
		           <li><h2>Flat-panel TV</h2></li>	        
		           <li><a href="">4K Ultra HD</a><p>Here is a description.</p></li>
		           <li><a href="">China TV</a><p>Here is a description.</p></li>
		           <li><a href="">Curved screen</a><p>Here is a description.</p></li>
		           <li><a href="">Smart TV</a><p>Here is a description.</p></li>
		           
		         </ul>
		           <ul class="ca_detail">	           
		           <li><h2>NoScreen TV</h2></li>	        
		           <li><a href="">Portable Projector</a><p>Here is a description of the Categories</p></li>
		           <li><a href="">Projection Pen</a><p>Here is a description of the Categories</p></li>
		           <li><a href=""> HD Projection</a><p>Here is a description of the Categories</p></li>
		           <li><a href="">Home Theater</a><p>Here is a description of the Categories</p></li>
		           
		         </ul>
		         <ul class="ca_detail">	           
		           <li><h2>TV Accessories</h2></li>	        
		           <li><a href="">Displays</a><p>Here is a description of the Categories</p></li>
		           <li><a href="">Adapters</a><p>Here is a description of the Categories</p></li>		       
		         </ul>
		         </div>
		        </li>
		        <li class="ca2">
		        <h2>Computers & Tablets</h2>
		        <div id="ca2" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Game Computer</h2></li>	        
		             <li><a href="">DIY Computer</a><p>Here is a description.</p></li>
		             <li><a href="">Competitive DIY</a><p>Here is a description.</p></li>
		             <li><a href=""> Game Book</a><p>Here is a description.</p></li>
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Portable Office</h2></li>	        
		             <li><a href="">Kindle</a><p>Here is a description.</p></li>
		             <li><a href="">ThinkPad</a><p>Here is a description.</p></li>
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Hardware Storage</h2></li>	        
		             <li><a href="">Memory Bar</a><p>Here is a description.</p></li>
		             <li><a href="">CPU</a><p>Here is a description.</p></li>
		             <li><a href="">SSD</a><p>Here is a description.</p></li>
		           </ul>      
		         </div>
		        </li>
		        <li class="ca3">
		        <h2>Cell Phones</h2>
		          <div id="ca3" class="ca kongbaige">
                   <ul class="ca_detail">	           
		             <li><h2>Hot Mobile Phone</h2></li>	        
		             <li><a href="">MI</a><p>Here is a description.</p></li>
		             <li><a href="">iPhone</a><p>Here is a description.</p></li>
		             <li><a href="">Meizu</a><p>Here is a description.</p></li>
		             <li><a href="">Honor</a><p>Here is a description.</p></li>		           
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Mobile Phone Accessories</h2></li>	        
		             <li><a href="">Headphone</a><p>Here is a description.</p></li>
		             <li><a href="">Cell Phone</a><p>Here is a description.</p></li>
		             <li><a href="">Selfie Stick</a><p>Here is a description.</p></li>  
		           </ul>	
		          </div>
		        </li>
		        <li class="ca4">
		        <h2>Cameras & Camcorders</h2>
		        <div id="ca4" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Camera </h2></li>	        
		             <li><a href="">Camera</a><p>Here is a description.</p></li>
		             <li><a href="">Single Counter</a><p>Here is a description.</p></li>
		             <li><a href="">Microcamera</a><p>Here is a description.</p></li>
		             <li><a href="">Video Camera</a><p>Here is a description.</p></li>		           
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Digital Photography</h2></li>	        
		             <li><a href="">VRcamera</a><p>Here is a description.</p></li>
		             <li><a href="">Void</a><p>Here is a description.</p></li>
		             <li><a href="">360 Camera</a><p>Here is a description.</p></li>  
		           </ul>	
		         </div>
		        </li>
		        <li class="ca5">
		        <h2>Audio & Video</h2>
		        <div id="ca5" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Entertainment</h2></li>	        
		             <li><a href="">Earphone</a><p>Here is a description.</p></li>
		             <li><a href="">TmallBox</a><p>Here is a description.</p></li>
		             <li><a href="">Nivdia Sheled</a><p>Here is a description.</p></li>  
		           </ul>	
		           <ul class="ca_detail">	           
		             <li><h2>Smart Digital</h2></li>	        
		             <li><a href="">Smart Earphone</a><p>Here is a description.</p></li>
		             <li><a href="">Bone Conduction Earphone</a><p>Here is a description.</p></li>
		             <li><a href="">Smart Ring</a><p>Here is a description.</p></li>  
		           </ul>	
		           <ul class="ca_detail">	           
		             <li><h2>Social Encyclopedia</h2></li>	        
		             <li><a href="">Roasted</a><p>Here is a description.</p></li>
		             <li><a href="">Tourism </a><p>Here is a description.</p></li>
		             <li><a href="">Recipe</a><p>Here is a description.</p></li>  
		           </ul>	
		         </div>
		        </li>
		        <li class="ca6">
		        <h2>Car Electronics & GPS</h2>
		        <div id="ca6" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Vehicular Electrical Apparatus</h2></li>	        
		             <li><a href="">Air Cleaner</a><p>Here is a description.</p></li>
		             <li><a href="">Vehicle MP3 </a><p>Here is a description.</p></li>
		             <li><a href="">Inverter</a><p>Here is a description.</p></li>  
		           </ul>	
		           <ul class="ca_detail">	           
		             <li><h2>Social Encyclopedia</h2></li>	        
		             <li><a href="">Traffic Recorder</a><p>Here is a description.</p></li>
		             <li><a href="">Security Early-warning Instrument </a><p>Here is a description.</p></li>
		             <li><a href="">GPS</a><p>Here is a description.</p></li>  
		           </ul>	
		           <ul class="ca_detail">	           
		             <li><h2>Safety Self Driving</h2></li>	        
		             <li><a href="">Tire Alarm Inflatable</a><p>Here is a description.</p></li>
		             <li><a href="">Pump </a><p>Here is a description.</p></li>
		           </ul>	
		         </div>
		        </li>
		        <li class="ca7">
		        <h2>Games, Movies & Music</h2>
		        <div id="ca7" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Original Import</h2></li>	        
		             <li><a href="">Imported Film and Audio</a><p>Here is a description.</p></li>
		             <li><a href="">Original Film </a><p>Here is a description.</p></li>
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Game Entertainment</h2></li>	        
		             <li><a href="">ACT</a><p>Here is a description.</p></li>
		             <li><a href="">RPG</a><p>Here is a description.</p></li>
		             <li><a href="">MOBA</a><p>Here is a description.</p></li>  
		             <li><a href="">SandBox</a><p>Here is a description.</p></li>  
		           </ul>
		         </div>
		        </li>
		        <li class="ca8">
		        <h2>Health, Fitness & Sports</h2>
		        <div id="ca8" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Medicine</h2></li>	        
		             <li><a href="">Cold&Cough</a><p>Here is a description.</p></li>
		             <li><a href="">Gynecologic Drug Use </a><p>Here is a description.</p></li>
		             <li><a href="">Male Medicine</a><p>Here is a description.</p></li>  
		           </ul>
		            <ul class="ca_detail">	           
		             <li><h2>Medical Instruments</h2></li>	        
		             <li><a href="">Thermometer</a><p>Here is a description.</p></li>
		             <li><a href="">Wheelchair</a><p>Here is a description.</p></li>
		             <li><a href="">Hearing Aid</a><p>Here is a description.</p></li> 
		           </ul>
		            <ul class="ca_detail">	           
		             <li><h2>Health Products</h2></li>	        
		             <li><a href="">Aloe</a><p>Here is a description.</p></li>
		             <li><a href="">Vitamin C  </a><p>Here is a description.</p></li>
		             <li><a href="">Fish Oil</a><p>Here is a description.</p></li>  
		           </ul>
		           <ul class="ca_detail">	           
		             <li><h2>Sporting Goods</h2></li>	        
		             <li><a href="">Basketball</a><p>Here is a description.</p></li>
		             <li><a href="">ToFootballurism </a><p>Here is a description.</p></li>
		             <li><a href="">Table Tennis </a><p>Here is a description.</p></li>  
		           </ul>
		         </div>
		        </li>
		        <li class="ca9">
		        <h2>Home & Office</h2>
		        <div id="ca9" class="ca kongbaige">
		           <ul class="ca_detail">	           
		             <li><h2>Furniture</h2></li>	        
		             <li><a href="">Curtain</a><p>Here is a description.</p></li>
		             <li><a href="">Carpet  </a><p>Here is a description.</p></li>
		             <li><a href="">Sofa</a><p>Here is a description.</p></li>  
		           </ul>
		            <ul class="ca_detail">	           
		             <li><h2>Office supplies</h2></li>	        
		             <li><a href="">Desk</a><p>Here is a description.</p></li>
		             <li><a href="">Boss Chair </a><p>Here is a description.</p></li>
		           </ul>
		            <ul class="ca_detail">	           
		             <li><h2>Flowers and Plants</h2></li>	        
		             <li><a href="">Succulent Plants,</a><p>Here is a description.</p></li>
		             <li><a href="">Plants Indoor </a><p>Here is a description.</p></li>
		             <li><a href="">Plant Gardening Tools</a><p>Here is a description.</p></li>  
		           </ul>
		            <ul class="ca_detail">	           
		             <li><h2>Accessories</h2></li>	        
		             <li><a href="">Wall Stickers</a><p>Here is a description.</p></li>
		             <li><a href="">Photo Frame </a><p>Here is a description.</p></li>
		             <li><a href="">Decorative Painting</a><p>Here is a description.</p></li>  
		           </ul>
		         </div>
		        </li>
		      </ul>
		    </div>
		  </div>
		</div>
	</div>
	
	<div class="pic">
        <div class="flexslider">
          <ul class="slides">
            <li style="background: url(user/images/index/ad_SumSung.jpg) no-repeat -180px center ;">
              <a href=""></a>
            </li>
            <li style="background: url(user/images/index/ad_tangguo.JPG) no-repeat -180px center;">
              <a href=""></a>
            </li>
            <li style="background: url(user/images/index/ad_sharp.JPG) no-repeat -180px center;">
              <a href=""></a>
            </li>
            <li style="background: url(user/images/index/ad_Midea.JPG) no-repeat -180px center;">
              <a href=""></a>
            </li> 
            <li style="background: url(user/images/index/ad_LG.JPG) no-repeat -120px center;">
              <a href=""></a>
            </li> 
          </ul>
        </div>
    </div>
    <!-- 
	<div class="bigpic normal">
		<a href="" class="ablock"><img src="images/bigpic1.jpg"></a>
	</div>
	 -->
	<div class="yasi normal">
		<h2 class="mosth2"><p></p>Shop Top5</h2>
		<ul class="yasi_ul1">
			<c:forEach var="shop" items="${shops }">
				<li><a href="/mall/admin/advertisement/shop/${shop.shopId }" class="ablock"><img src="${shop.headUrl }"></img></a><a href="" class="ablock"><h2>${shop.shopName }</h2></a><p>Look for Bixby talent</p><a href="/mall/admin/advertisement/shop/${shop.shopId }" class="enter_btn">enter</a></li>
			</c:forEach>
			<!--  
			<li><a href="" class="ablock"><img src="user/images/index/logo_tangguo.JPG"></img></a><a href="" class="ablock"><h2>TangGuo Flagship Store</h2></a><p>Look for Bixby talent</p><a href="" class="enter_btn">enter</a></li>
			<li><a href="" class="ablock"><img src="user/images/index/logo_sharp.JPG"></img></a><a href="" class="ablock"><h2>Sharp Flagship Store</h2></a><p>Look for Bixby talent</p><a href="" class="enter_btn">enter</a></li>
			<li><a href="" class="ablock"><img src="user/images/index/logo_Midea.JPG"></img></a><a href="" class="ablock"><h2>Media Flagship Store</h2></a><p>Look for Bixby talent</p><a href="" class="enter_btn">enter</a></li>
			<li><a href="" class="ablock"><img src="user/images/index/logo_LG.JPG"></img></a><a href="" class="ablock"><h2>LG Flagship Store</h2></a><p>Look for Bixby talent</p><a href="" class="enter_btn">enter</a></li>
			-->
		</ul>
	</div>
	<div class="yasi normal">
		<h2 class="mosth2"><p></p>Product Top10</h2>
		<ul class="pro_top10">
			<c:forEach var="product" items="${products }">
				<li><div><a href="/mall/admin/advertisement/product/${product.productId }"><img src="${product.imageUrl }"></img></a><a href=""><h1> ${product.productName }</h1></a><p>$ <span>${product.price }</span></p></div></li>
			</c:forEach>
			<!-- 
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			<li><div><a href=""><img src="user/images/index/pro_samsungGlaxy.png"></img></a><a href=""><h1> Samsung GALAXY Note8 SM-N9500 64G/128G</h1></a><p>$ <span>999.99</span></p></div></li>
			 -->		
		</ul>
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