
$('#btnQuery').click(function(){
//	function removeAllSpace(str){
//		return str.replace(/\s+/g,"");
//	}
	var $op=$("#searchClass option:selected").val();
	var $queryValue=$("#queryValue").val();
	var $location=window.location.href;
	$location=$location.substring(0,$location.lastIndexOf('/'));
	$location=$location.substring(0,$location.lastIndexOf('/'));
	$queryValue=$queryValue.replace(/\s+/g,"");
	if($queryValue.length==0){
		//输入查询内容
		alert("请输入查询内容");
	}
	else{
		if($op==1){
		
		window.location.href=$location+'/queryByname/'+$queryValue;
	 	}
		else if($op==0){
		window.location.href=$location+'/queryById/'+$queryValue;
		}
		else{
			//请选择查询选项
			alert("请选择查询选项");
		}
	}
	

})
