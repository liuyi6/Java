$().ready(function(){
	if($(".li1a").hasClass("navon")){
			$(".area").css("display","block");
		}
	$(".bigbig").mouseenter(function(){
		var bb = $(this).attr("id");
		if(bb!="index"){
			$(".li1a").addClass("navon")
		}
		if($(".li1a").hasClass("navon")){
			$(".area").css("display","block");
		}
	})

	$(".bigbig").mouseleave(function(){
		var bb = $(this).attr("id");
		if(bb!="index"){
			$(".li1a").removeClass("navon")
		}
		if($(".li1a").hasClass("navon")){
			$(".area").css("display","block");
		}else{
			$(".area").css("display","none");
		}
	})


	$(".area li").mouseenter(function(){
		var bb = "#"+$(this).attr("class");
		$(bb).css("display","block");
	})

	$(".area li").mouseleave(function(){
		var bb = "#"+$(this).attr("class");
		$(bb).css("display","none");
	})

	$('.flexslider').flexslider({
		directionNav: true,
		pauseOnAction: false, 

	});

	$(".ulWrap li").mouseenter(function(){
		$(this).find("div").slideDown();

	})
	$(".ulWrap li").mouseleave(function(){
		$(this).find("div").slideUp();
	})

	$(".ulWrap1 li").mouseenter(function(){
		$(this).find("div").slideDown();
	})
	$(".ulWrap1 li").mouseleave(function(){
		$(this).find("div").slideUp();
	})
	jQuery(".multipleColumn").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:4});
	jQuery(".multipleColumn1").slide({titCell:".hd1 ul",mainCell:".bd1 ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:2});
	jQuery(".multipleColumn2").slide({titCell:".hd2 ul",mainCell:".bd2 ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:3});
})

$().ready(function(){
	$(".applyul li").each(function(){
		if($(this).hasClass("con")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".applyul li").mouseenter(function(){
		$(".applyul li").each(function(k,v){
			if($(v).hasClass("con")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("con")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("con");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".applyul1 li").each(function(){
		if($(this).hasClass("con")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".applyul1 li").mouseenter(function(){
		$(".applyul1 li").each(function(k,v){
			if($(v).hasClass("con")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("con")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("con");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".applyul2 li").each(function(){
		if($(this).hasClass("con")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".applyul2 li").mouseenter(function(){
		$(".applyul2 li").each(function(k,v){
			if($(v).hasClass("con")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("con")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("con");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".applyul3 li").each(function(){
		if($(this).hasClass("con")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".applyul3 li").mouseenter(function(){
		$(".applyul3 li").each(function(k,v){
			if($(v).hasClass("con")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("con")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("con");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".xuanxian span").each(function(){
		if($(this).hasClass("static")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".xuanxian span").mouseenter(function(){
		$(".xuanxian span").each(function(k,v){
			if($(v).hasClass("static")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("static")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("static");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".xuanxian1 span").each(function(){
		if($(this).hasClass("static")){
			var iidd = "."+$(this).attr("id");
			$(iidd).css("display","block");
		}
	})

	$(".xuanxian1 span").mouseenter(function(){
		$(".xuanxian1 span").each(function(k,v){
			if($(v).hasClass("static")){
				var iidd = "."+$(v).attr("id");
				$(v).removeClass("static")
				$(iidd).css("display","none");
			}
		})
		$(this).addClass("static");
		var iidd = "."+$(this).attr("id");
		$(iidd).css("display","block");
	})

	$(".ul_item .tr4:lt(15):even").css("background-color","#f8f8f8");
	$(".ul_item .tr4:gt(14):lt(15):even").css("background-color","#f8f8f8");
	$(".ul_item .tr4:gt(29):lt(15):even").css("background-color","#f8f8f8");
	$(".ul_item .tr4:gt(44):lt(15):even").css("background-color","#f8f8f8");

	$(".sidebtn b").click(function(){
		if($(this).attr("id")=="open"){
			$(".byby").css("right","-190px");
			$(this).attr("style","background-position:-30px 0px;");
			$(this).attr("id","off");
		}else{
			$(".byby").css("right","0px");
			$(this).attr("style","background-position:0px 0px;");
			$(this).attr("id","open");
			
		}
		
	})

	$(".contr_ul li").mouseenter(function(){
		var cc = $(this);
		$(this).find("p").click(function(){
			cc.remove();
		})
	})

	$(".empty").click(function(){
		$(".contr_ul").empty();
	})

	$(".mosth2 ul li").mouseenter(function(){
		$(".mosth2 ul li a").css("color","#6e6e6e");
		$(this).find("a").css("color","#03b8b3");
		$(".bigxx").css("display","none");
		var lalala = "."+$(this).attr("id");
		$(lalala).css("display","block");
	})

	$(".delete").click(function(){
		var lili = "."+$(this).attr("id");
		$(lili).remove();
	})

	$(".xiugai").click(function(){
		var lili = $(this).attr("id")+"1";
		$("#modal-xiugai").attr("shuxing",lili);
	})

	$("#ajax1").click(function(){
		var url;/* 你把你的后台放进来做处理*/
		var args = {"name":$(".com_name input").val(),"type":$(".com_type input").val(),"kunumber":$(".com_kunumber input").val(),"prize":$(".com_tel input").val(),"path":$("#imgPreview1 #img1").attr("src")};
		$.getJSON(url,args,function(date){
			var name = date.name;
			var type = date.type;
			var prize  = date.prize;
			var kunumber = date.kunumber;
			var path = date.path;
			var cl = $("#modal-xiugai").attr("shuxing");
			var lili = "."+cl.substr(0,cl.length-1);
			$(lili).find("img").attr("src",path);
			$(lili).find("h2").innerHTML=name;
			$(lili).find(".commodity_1tel").innerHTML=tel;
			$(lili).find(".td11").innerHTML="商品类别："+type;
			$(lili).find(".td2").innerHTML="库存量："+kunumber;
			$("#modal-xiugai").attr("shuxing","");
		});
	})
	$("#quxiao").click(function(){
		var cl = $("#modal-xiugai").attr("shuxing","");
	})

	$(".commodity_submit").click(function(){
		var name = $(".commodity_name").val();
		var price = $(".commodity_prize").val();
		var type = $(".commodity_type").val();
		var kunumber = $(".commodity_number").val();
		//var path=$("#imgPreview #img1").attr("src");
		var path = $('#upload').get(0).files[0];
		
		

		var shopId=getCookie("shopId");
		
		var form = new FormData();
        form.append("name", name);
        form.append("type",type);
        form.append("kunumber",kunumber);
        form.append("path", path);
        form.append("shopId",shopId);
        form.append("price",price);
        
        var args = {"name":name,"type":type,"kunumber":kunumber,"shopId":shopId,"price":price};
		var url="/mall/product/addProduct.do" ;
        
		$.ajax({
			url:url,
			type:"post",
			data:form,
			contentType:false,
			processData: false,
			dataType:"json",
			success:function(date){
				var name = date.name;
				var type = date.type;
				var price  = date.price ;
				var kunumber = date.kunumber;
				var path = date.path;
				$(".commodity_name").val("");
				$(".commodity_type").val("");
				$(".commodity_prize").val("");
				$(".commodity_number").val("");
				$(".commodity_images").val("");
				$("#imgPreview").empty();
				$(".sleft ul").prepend("<li class='"+name+"'><a><img src='"+path+"'/></a><div class='oooo'><a><h2>"+name+"</h2></a><p>Shop_id:"+shopId+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class='commodity_1tel'>Price:"+price+"</span></p><table><tr><td class='td11'>Type："+type+"</td><td class='td2'>Number："+kunumber+"</td><td class='td3'>好评率：100%</td></tr><tr><td class='td11'>Comments：0</td><td class='td2'> Sales：0</td></tr></table></div><div class='pppp'></div></li>");

				return false;
				}
			});
		
		
	})

    $(".reg").click(function(){
        $("#chushi").css("display","none");
        $("#regis").css("display","block");
        return false;
    })

})







		