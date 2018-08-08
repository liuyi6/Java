function submitinfo(){
		var value1 = document.getElementById("account").value;
		var value2 = document.getElementById("pwd1").value$;
		var value3 = document.getElementById("pwd2").value$;
		var value4 = document.getElementById("address").value;
		var value5 = document.getElementById("tel").value;
        if(value1==""||value2==""||value3==""||value4==""||value5==""){
        	alert("Please complete information!!");
       	 	return false;
        }else{
        	var reg1 = /^[A-Za-z0-9]+$/;
        	var reg3 =/^1[34578]\d{9}$/;
        	if(reg1.test(value1)==false||reg3.test(value5)==false){
        		alert("Information format error!");
        		return false;
        	}
        	if(value2!=value3){
            	alert("The two passwords are not the same！！");
            	return false;
            }
            	return true;
        }
}

window.onload=function(){
	if(document.getElementById("pwd1")){
		check();
	}
}
function check(){
	var oac = document.getElementById("account");
	oac.onblur = function(){
		var oimg = document.getElementById("img1");
		var otip = document.getElementById("tips1");
		var value = oac.value;
		if(value == ""){
			oimg.src = "user/images/error.jpg";
			otip.innerHTML = "The account can not be null";
		}else{
			var reg = /^[A-Za-z0-9]+$/;
			if(reg.test(value)){
				oimg.src = "user/images/correct.jpg";
				otip.innerHTML = "";
			}else{
				oimg.src = "user/images/error.jpg";
				otip.innerHTML = "The account should be made up of letters and numbers";
			}
		}
	}
	var opwd1 = document.getElementById("pwd1");
	opwd1.onblur = function(){
		var oimg = document.getElementById("img2");
		var otip = document.getElementById("tips2");
		var value = opwd1.value;
		if(value == ""){
			oimg.src = "user/images/error.jpg";
			otip.innerHTML = "The password can not be null";
		}else{
			if(opwd1.value.length<3||opwd1.value.length>8){
				oimg.src = "user/images/error.jpg";
				otip.innerHTML = "The length of Password is between 3 and 8 ";
			}else{
				var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{3,8}$/;
				if(reg.test(value)){
					oimg.src = "user/images/correct.jpg";
					otip.innerHTML = "";
				}else{
					oimg.src = "user/images/error.jpg";
					otip.innerHTML = "Password is be made up of letters and numbers";
				}
			}
		}
	}
	var opwd2 = document.getElementById("pwd2");
	opwd2.onblur = function(){
		var oimg = document.getElementById("img3");
		var otip = document.getElementById("tips3");
		var value = opwd1.value;
		if(value == ""){
			oimg.src = "user/images/error.jpg";
			otip.innerHTML = "The password can not be null";
		}else{
			if(opwd1.value!=opwd2.value){
				oimg.src = "user/images/error.jpg";
				otip.innerHTML="The two password is not identical";
			}else{
				oimg.src = "user/images/correct.jpg";
				otip.innerHTML = "";
			}
		}
	}
	var oaddress = document.getElementById("address");
	oaddress.onblur = function(){
		var oimg = document.getElementById("img5");
		var otip = document.getElementById("tips5");
		var value = oaddress.value;
		if(value == ""){
			oimg.src = "user/images/error.jpg";
			otip.innerHTML = "Address can not be null";
		}else{
			oimg.src = "user/images/correct.jpg";
			otip.innerHTML = "";
		}
	}

	var otel = document.getElementById("tel");
	otel.onblur = function(){
		var oimg = document.getElementById("img6");
		var otip = document.getElementById("tips6");
		var value = otel.value;
		if(value == ""){
			oimg.src = "user/images/error.jpg";
			otip.innerHTML = "Telephone can not be null";
		}else{
			var reg =/^1[34578]\d{9}$/;
			if(reg.test(value)){
				oimg.src = "user/images/correct.jpg";
				otip.innerHTML = "";
			}else{
				oimg.src = "user/images/error.jpg";
				otip.innerHTML = "Please enter the correct phone number";
			}
		}
	}
}