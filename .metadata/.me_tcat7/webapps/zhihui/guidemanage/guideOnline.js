
var urlll;
var myid;
var myi;
var j;
function mylistener(a){
	myid=a;
	var args2={"myid":a};
	$.ajax({
        cache: true,
        type: "POST",
        url:"../mylsen_Mylsen",
        data:args2,// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	var array = eval('(' + data + ')');
        	if(array.success!=1){
        		alert("监听失败，当前用户正在被监听");
        	}else{
        		alert("监听成功，开始监听");
        		
        		
        		var i=0;
        		
        		$('body').everyTime('8s','A',function() {
        			if(1==i){
        				$('body').stopTime('A');
        				
        			}else{
        				i++;
        				//判断服务器下是否有该url
        				$.ajax({
        			        cache: true,
        			        type: "POST",
        			        url:"../jiance_Mylsen",
        			        data:args2,// 你的formid
        			        async: false,
        			        error: function(request) {
        			            alert("Connection error");
        			        },
        			        success: function(url) {
        			        	var myurl = eval('(' + url + ')');
        			        	//alert(myurl.success);
        			        	urlll=myurl.success;
        			        	myuri=myurl.myi;
        			        	
        			        }
        				});
        				if(0==urlll){
        					alert("资源尚未准备好");
        				}else{
        				//下载成功应当有返回值
        				$('.oAudio').dialog({
    						title : '播放音频',
    						width : 300,
    						height : 140,
    						closed : false,
    						cache : true,
    						href : '',
    						modal : true
    					});
            			
        				 j=parseInt(myuri)+1;
        				alert(j);
        				var audio=document.getElementById("audio");
            			audio.src="../files/"+urlll+"/"+parseInt(myuri)+".mp3";
            			audio.play();
            			audio.onended=function(){
            				audio.src="../files/"+urlll+"/"+j+".mp3";
            				audio.play();
            				j++;
            			}
            			$('.oAudio').dialog({
            				
            			    onClose:function(){
            			    
            			    	alert("进入关闭"+myid);
            			    	audio=null;
            			    	mylistenerst(myid);
            			    }
            			});
        			}
        			}
        			
        		});
        		var index = layer.load(1, {
        			shade: [0.1,'#fff'] //0.1透明度的白色背景
        			});
        			setTimeout(function(){
        			layer.close(index);
        			}, 7000);
        			//<source src="../files/100002_C2A4/1.mp3" />
        	}
        	
        }
    });
}
function myconti(){
	alert(j+"heihei::"+urlll);
	var audio=document.getElementById("audio");
	audio.src="../files/"+urlll+"/"+j+".mp3";
	audio.play();
	audio.onended=function(){
		audio.src="../files/"+urlll+"/"+j+".mp3";
		audio.play();
		j++;
	}
}
function mylistenerst(a){
	alert("结束标记"+a);
	var args2={"myid":a};
	$.ajax({
        cache: true,
        type: "POST",
        url:"../mylsop_Mylsen",
        data:args2,// 你的formid
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	var array = eval('(' + data + ')');
        	if(array.success==1){
        		alert("完成停止");
        	}else{
        		alert("停止失败");
        	}
        	
        }
    });
	
}