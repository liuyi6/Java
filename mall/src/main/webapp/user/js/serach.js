$(function () {
	
	$("#serach").click(function(){
		var type = jQuery("#select  option:selected").text();
		var content = document.getElementById("text").value; 
		if(content != null){
			if(type=="product"){
				window.open("productSerach?content="+content,"_self");
			}else{
				window.open("shopSerach?content="+content,"_self");
			}
		}else{
			window.open("index.jsp","_self");
		}
	});
});