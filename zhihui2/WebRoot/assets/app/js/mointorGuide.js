function selectAll(){
	
	$("table :checkbox:first").change(function(){
		$(this).closest("table")
			.find(":checkbox:not(:first)")
			.prop("checked",this.checked);
	});
}

var mydata;
function startrange(){
	//alert("执行关闭操作");
	var dataurl;
	var mytime=$("#mytime").val();
	dataurl={"muguidemid":mydata,"mytime":mytime};
	

	 $.ajax({
		 cache: true,
		 	type: "post",
	        url: '../myarealsen_Mylsen',
	        data: dataurl,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function (data) {
	        	//要注意谷歌浏览器内存的问题
	            alert("推送完毕!");
	       	 $("#mm").modal('hide');
	            }
	        });
	 
}
function startR(){
	var s='';
	$('input[name="luzhiCheck"]:checked').each(function(){ 
		s+=$(this).val()+',';
		
		});
		mydata=s;
//		var args={"shangchuan2":s};
		if(s == ""){
			alert("请选择导游");
			return false;
		}else{
			$("#myid2").val(mydata);
			$("#mm").modal();
			
		}
}
