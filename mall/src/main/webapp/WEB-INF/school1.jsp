<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>校院库</title>
	<meta name="description" content="">
	<meta name="keywords" content=""><!--网站关键词-->
	<meta name="Description" Content=""><!--网站简介-->
	<link rel="stylesheet" type="text/css" href="sell/css/bootstrap.css" />
	<link rel="stylesheet" href="sell/css/common.css" type="text/css" />
	<link rel="stylesheet" href="sell/css/main.css" type="text/css" />

	<script type="text/javascript" src="sell/js/jquery-3.2.1.min.js"></script>	
	<script type="text/javascript" src="sell/js/jquery.flexslider-min.js"></script>
	<script type="text/javascript" src="sell/js/jquery.SuperSlide.2.1.1.js"></script>
	<script type="text/javascript" src="sell/js/image.js"></script>
	<script type="text/javascript" src="sell/js/main.js"></script>
	
	<script type="text/javascript" src="sell/js/cookie_util.js"></script>
	<script type="text/javascript" src="sell/js/bootstrap.js"></script>
	<script type="text/javascript">
		$(function(){
		    //addCookie("shopId",10,2);
			var shopId=getCookie("shopId");

			if(shopId==null){
                window.location.href="login.html";
			}else {
                $.ajax({
                    url: "/mall/product/findShopName.do",
                    type: "post",
                    data: {"shopId": shopId},
                    dataType: "json",
                    success:function(result){
                        addCookie("shopName",result.data,2);
                    }

                })

                addCookie("pageNum", 1, 2);
                var shopId = getCookie("shopId");
                $(function () {
                    $.ajax({  //查询页数并显示在页面下方
                        url: "/mall/product/showProduct.do",
                        type: "post",
                        data: {"shopId": shopId},
                        dataType: "json",
                        success: function (result) {
                            var product = result.data;
                            var num = result.num;
                            var page = num / 5;
                            $(".fanye").append('<a href="" class="moren" id="1">1</a>');
                            for (var i = 1; i < page; i++) {

                                $(".fanye").append('<a href="" id="' + (i + 1) + '">' + (i + 1) + '</a>');
                            }
                           ;

                        }

                    });
                    $.ajax({//页面加载显示首页商品
                        url: "/mall/product/pageProduct.do",
                        type: "post",
                        data: {"shopId": shopId, "num": 0},
                        dataType: "json",
                        success: function (result) {
                            var product = result.data;
                            for (var i = 0; i < product.length; i++) {
                                var price = product[i].productPrice;
                                var name = product[i].productName;
                                var type = product[i].shopCategoryName;
                                var kunumber = product[i].productCount;
                                var productId = product[i].productId;
                                var path = product[i].imgAddr;
                                $(".sleft ul").append("<li id='" + productId + "' class='" + name + "'><a><img src='" + path + "'/></a><div class='oooo'><a><h2>" + name + "</h2></a><p>Shop_id:" + shopId + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='commodity_1tel'>Price:" + price + "</span></p><table><tr><td class='td11'>Type：" + type + "</td><td class='td2'>Number：" + kunumber + "</td><td class='td3'>好评率：100%</td></tr><tr><td class='td11'>Comments：0</td><td class='td2'> Sales：0</td></tr></table></div><div class='pppp'><a id='" + productId + "' href='news_detail.html' class='annoy'>Detail>></a></div></li>");

                            }
                        }
                    });
                    $(".fanye ").on("click", "a", function () { //点击页数翻页
                        $(".sleft a ").removeClass("moren");


                        var num = $(this).attr("id");
                        addCookie("pageNum", num, 2);
                        $(this).addClass("moren");
                        num = (num - 1) * 5;
                        $("#productInfo").html("");
                        $.ajax({
                            url: "/mall/product/pageProduct.do",
                            type: "post",
                            data: {"shopId": shopId, "num": num},
                            dataType: "json",
                            success: function (result) {
                                var product = result.data;
                                for (var i = 0; i < product.length; i++) {
                                    var price = product[i].productPrice;
                                    var name = product[i].productName;
                                    var type = product[i].shopCategoryName;
                                    var kunumber = product[i].productCount;
                                    var path = product[i].imgAddr;
                                    var productId = product[i].productId;
                                    $(".sleft ul").append("<li id='" + productId + "' class='" + name + "'><a><img src='" + path + "'/></a><div class='oooo'><a><h2>" + name + "</h2></a><p>Shop_id:" + shopId + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='commodity_1tel'>Price:" + price + "</span></p><table><tr><td class='td11'>Type：" + type + "</td><td class='td2'>Number：" + kunumber + "</td><td class='td3'>好评率：100%</td></tr><tr><td class='td11'>Comments：0</td><td class='td2'> Sales：0</td></tr></table></div><div class='pppp'><a id='" + productId + "' href='news_detail.html' class='annoy'>Detail>></a></div></li>");

                                }

                            }
                        });
                        return false;
                    });
                    $("#productInfo").on("click", ".xiugai", function () {
                        var id = $(this).attr("id");
                        addCookie("productId", id, 2);

                    });
                    $("#ajax1").on("click", function () {
                        var name = $("#name1").val();
                        var type = $("#type1").val();
                        var number = $("#number1").val();
                        var price = $("#prize1").val();
                        var detail = $("#detail1").val();
                        var path = $('#upload1').get(0).files[0];
                        var productId = getCookie("productId");
                        var form = new FormData();
                        form.append("productId", productId);
                        form.append("productName", name);
                        form.append("type", type);
                        form.append("price", price);
                        form.append("kunumber", number);
                        form.append("path", path);
                        form.append("desc", detail);
                        $.ajax({
                            url: "/product/modifyProduct.do",
                            type: "post",
                            data: form,
                            contentType: false,
                            processData: false,
                            dataType: "json",
                            success: function (product) {
                                var page = getCookie("pageNum");
                                window.location.href = "school.html";
                                addCookie("pageNum", page, 2);
                                var page = getCookie("pageNum");
                                num = (num - 1) * 5;
                                $.ajax({
                                    url: "/mall/product/pageProduct.do",
                                    type: "post",
                                    data: {"shopId": shopId, "num": num},
                                    dataType: "json",
                                    success: function (result) {
                                        var product = result.data;
                                        for (var i = 0; i < product.length; i++) {
                                            var price = product[i].productPrice;
                                            var name = product[i].productName;
                                            var type = product[i].shopCategoryName;
                                            var kunumber = product[i].productCount;
                                            var path = product[i].imgAddr;
                                            var productId = product[i].productId;
                                            $(".sleft ul").append("<li id='" + productId + "' class='" + name + "'><a><img src='" + path + "'/></a><div class='oooo'><a><h2>" + name + "</h2></a><p>Shop_id:" + shopId + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='commodity_1tel'>Price:" + price + "</span></p><table><tr><td class='td11'>Type：" + type + "</td><td class='td2'>Number：" + kunumber + "</td><td class='td3'>好评率：100%</td></tr><tr><td class='td11'>Comments：0</td><td class='td2'> Sales：0</td></tr></table></div><div class='pppp'><a id='\" + productId + \"' href='news_detail.html' class='annoy'>Detail>></a></div></li>");

                                        }

                                    }
                                });
                                return false;


                            }
                        });
                    })
                    $("#productInfo").on("click", ".delete", function () {
                        var id = $(this).attr("id");
                        addCookie("productId", id, 2);
                        alert(id);
                        $.ajax({
                            url: "/mall/product/deleteProduct.do",
                            type: "post",
                            data: {"productId": id},
                            dataType: "json",
                            success: function (result) {
                                alert("删除成功!");
                                var page = getCookie("pageNum");
                                window.location.href = "school.html";
                                addCookie("pageNum", page, 2);
                                var page = getCookie("pageNum");
                                num = (num - 1) * 5;
                                $.ajax({
                                    url: "/product/pageProduct.do",
                                    type: "post",
                                    data: {"shopId": shopId, "num": num},
                                    dataType: "json",
                                    success: function (result) {
                                        var product = result.data;
                                        for (var i = 0; i < product.length; i++) {
                                            var price = product[i].productPrice;
                                            var name = product[i].productName;
                                            var type = product[i].shopCategoryName;
                                            var kunumber = product[i].productCount;
                                            var path = product[i].imgAddr;
                                            var productId = product[i].productId;
                                            $(".sleft ul").append("<li id='" + productId + "' class='" + name + "'><a><img src='" + path + "'/></a><div class='oooo'><a><h2>" + name + "</h2></a><p>Shop_id:" + shopId + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='commodity_1tel'>Price:" + price + "</span></p><table><tr><td class='td11'>Type：" + type + "</td><td class='td2'>Number：" + kunumber + "</td><td class='td3'>好评率：100%</td></tr><tr><td class='td11'>Comments：0</td><td class='td2'> Sales：0</td></tr></table></div><div class='pppp'><a id='" + productId + "' href='news_detail.html' class='annoy'>Detail>></a></div></li>");

                                        }

                                    }
                                });
                                return false;

                            }

                        })
                    });



                    $("#productInfo").on("click", ".annoy",function () {
						var productId=$(this).attr("id");

                        addCookie("productId",productId,2);

                    })


                })

            }
		})
	
	</script>



	</head>
<body style="background-color: #fff">
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
          <img src="sell/images/index/shop_32px.png" ></img>
            <a id="shop" class="link"> My Shop </a>
        </li>
        <li class="nav_item">
          <img src="sell/images/index/shopping_cart_32px.net.png" ></img>
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
  
	<div class="whitebg">
		<div class="normal top2">
			<div class="logo"><a href=""><img src="sell/images/index/shop_red_64px.png"><h2>PARKnSHOP</h2><p>welcome to PARKnSHOP !</p></a></div>
			<div class="search">
			  <select>
			    <option>product</option>
			    <option>shop</option>
			  </select>
			  <input type="search" name="" class="text" placeholder="Please enter the product name">
			  <input type="button" value="search" href="" class="search_btn">
			</div>
		</div>
	</div>
	
	
	<div class="biaoti">
		<span>Store</span>
		<div class="biaoti1">Apple<p>Your location：<a href="">Store</a> > <a href="" class="on">Apple</a></p></div>
	</div>

	

	<div class="normal mt20">

		<div class="sleft">

			<input type="text" name="" class="scl" placeholder="请输入院校关键词"><a href="" class="sbutton"></a>

			<ul id="productInfo">
				
				
			</ul>

			<div class="fanye">
			
				

			</div>

		</div>

		<div class="sright">
			
			<div class="stop">
				<p><span class="wocao">sales</span></p>	

				<ul>

					<li><span class="sli1">1</span></li>
					<li><span class="sli2">2</span></li>
					<li><span class="sli3">3</span></li>
					<li><span class="sli4">4</span></li>
					<li><span class="sli4">5</span></li>
					<li><span class="sli4">6</span></li>
					<li><span class="sli4">7</span></li>
					<li><span class="sli4">8</span></li>
					<li><span class="sli4">9</span></li>
					<li><span class="sli4">10</span></li>

				</ul>

			</div>

			<div class="sdown">

				<p><span class="wocao">actives</span><a href="">More>></a></p>
				<ul>

					<li><a href=""></a></li>
					<li><a href=""> </a></li>
					<li><a href=""></a></li>
					<li><a href=""> </a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>
					<li><a href=""></a></li>

				</ul>

			</div>

		</div>

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



		<div class="modal fade" id="modal-xiugai">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
            			<h4 class="modal-biaoti">modify</h4>
					</div>
					<div class="model-body">
						<table class="comtab">
							<tr><td class="com_name">Name&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" id="name1" name=""></td><td class="com_type">Type：<input  id="type1" type="text" name=""></td></tr>
							<tr><td class="com_kunum">Number：<input id="number1" type="text" name=""></td><td class="com_tel">Prize：<input id="prize1" type="text" name=""></td></tr>
							<tr><td colspan="2"><input type="file" name="" onchange="PreviewImage1(this)" id="upload1" class="commodity_images" style="width: 100%" /><div id="imgPreview1" class="tupian1"></div></td></tr>
							<tr><td colspan="2" style="vertical-align: top;"><p  style="float: left;">Detail：</p><textarea id="detail1" class="com_detail"></textarea></td></tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal" id="ajax1">OK</button>
             			<button type="button" class="btn btn-defalut" data-dismiss="modal" id="quxiao1">CANCEL</button>
					</div>
				</div>
			</div>
		</div>


</body>
</html>