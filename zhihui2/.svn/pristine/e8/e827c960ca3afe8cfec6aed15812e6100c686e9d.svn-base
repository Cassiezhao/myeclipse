$(document).ready(function(){		
$('#icon').click(function(){
	$('.search-info').css('display','block');
	$('.search-icon').css('display','none');
	});
$('#query').click(function(){
	$choice=$(".selectway").val();
	if($("#searchInfo").val()==""){
		alert("搜索数据不能为空！");
	}
	else{
		$('.search-info').css('display','none');
		$('.search-icon').css('display','block');
		if($choice==1){
			window.location.href=$path+"/queryByGuideName/"+$("#searchInfo").val();
		}else if($choice==2){
			window.location.href=$path+"/queryByGuideNumber/"+$("#searchInfo").val();
		}else if($choice==3){
			window.location.href=$path+"/queryByOrderId/"+$("#searchInfo").val();
		}else{
			window.location.href=$path+"/queryByGuideMachineNumber/"+$("#searchInfo").val();
		}
	}
	});				
})