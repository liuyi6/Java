window.onload=function(){
	if(document.getElementById("tab1")){
		change();
	}
	if(document.getElementById("pwd1")){
		check();
	}
}
function change(){
	var otab1 = document.getElementById("tab1");
	var otab2 = document.getElementById("tab2");
	var oform1 = document.getElementById("form1");
	var oform2 = document.getElementById("form2");
	otab1.onclick  = function(){
		otab1.style.color="#e80012";
		otab2.style.color="#666666";
		oform2.style.display="none";
		oform1.style.display="block";
	}
	otab2.onclick  = function(){
		otab2.style.color="#e80012";
		otab1.style.color="#666666";
		oform1.style.display="none";
		oform2.style.display="block";
	}
}
function check(){
	var opwd1 = document.getElementById("pwd1");
	var opwd2 = document.getElementById("pwd2");
	var otips1 = document.getElementById("tips1");
	var otips2 = document.getElementById("tips2");
	opwd1.onblur = function(){
		if(opwd1.value.length<8||opwd1.value.length>12){
			otips1.innerHTML="The length of Password is between 8 and 12 ";
		}else{
			otips1.innerHTML="";
		}
	}
	opwd2.onblur = function(){
		if(opwd1.value!=opwd2.value){
			otips2.innerHTML="The two password is not identical !  Please Modify";
		}else{
			otips2.innerHTML="";
		}
	}
}