function changecolor(obj){
	var obj = document.getElementById(obj.id);
	 obj.style.color= "#E80012";
//	 window.location.href = "queryorders?pageId=1&state=0";
	 var pageId = 1;
	 var state = 0;
	 $.ajax({
		 type: "GET",
         url: "/mall/queryorders?pageId=" + pageId + "&state=" + state,
         dataType: "json",
         success:callback,
		"error":function(){
			alert("系统繁忙");
		}
     });
};

function callback(data){
	alert(1);
}