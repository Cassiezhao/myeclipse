<%@page import="chris.pojo.Total"%>
<%@page import="chris.bean.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:if test="#session.pb==null">
	<c:redirect url="../findAll_Guide?i=2"></c:redirect>
</s:if>
<s:if test="#session.gjing1==null">
<c:redirect url="../findAll_Guide?i=2"></c:redirect>
</s:if>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<!-- 百度地图 -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=DGNFeh22K1TSexlaulHV9vA4l7NK91Hu"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
<title>在线导游</title>

<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script><script
	type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css" type="text/css"></link>
<style type="text/css">
#container {
	height: 400px;
	width: 100%;
}

#container2 {
	height: 400px;
	width: 100%;
}

#r-result {
	width: 100%;
}

#r-result2 {
	width: 100%;
}

.panel-body{
 padding:0px;
}
.datagrid{
	margin-bottom:0px;
}
.datagrid-pager{
	background-color:#ffffff;
	margin-left:auto;
}

</style>
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok7").addClass("active");
	})
</script>
<script type="text/javascript" src="../HZRecorder.js"></script>
<script type="text/javascript" src="guideOnline.js"></script>
<script type="text/javascript" src="../assets/js/jquery.timers.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery.timers.js"></script></head>

<body>
	<jsp:include page="../common2.jsp"/>
			<!--slide bar end-->


			<!-- main start-->
			<div id="main-content" class="main-content col-md-10"
				style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
				<div class="main-content-title">

					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span><a
							href="../index.jsp" style="padding-left:10px;">首页</a>
						</li>

						<li>在线导游</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;position:relative;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							在线导游 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>
						
						<font style="float:right;font-size:10px; position:absolute; bottom:0;right:0;">
							<a  onclick="mCal()">消息(2)</a>
						</font>

					</div>
					
					
					<!-- /.page-header -->
					<div class="row">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="myTab">
										<li class="active"><a data-toggle="tab" href="#home">
												在线导游 </a></li>
										<li role="presentation"><a data-toggle="tab" href="#pos">
												导游位置 </a></li>
										<li><a data-toggle="tab" href="#profile"> 客流热图 </a></li>
									</ul>


									<div class="tab-content" style="">
										<div id="home" class="tab-pane in active">
											<form action=" " method="post">
												<table class="table table-bordered table-hover fontsize">
													<tr class="guideinfotitle"
														style="border-bottom-width: 2px;">
														<th><input type="checkbox" id="aa" onclick="changeState(this.checked)"/></th>
														<th>导游图片</th>
														<th>导游姓名</th>
														<th>导游编号</th>
														<th>导游机编号</th>
														<th>经度</th>
														<th>维度</th>
														<th>携带人数</th>
														
													</tr>
													
													<s:iterator value="#session.pb.pagelist" var="pp">
														<s:if test="#pp.state==1">
															<tr>
																<td><input type="checkbox" name="fuxuan" value="${pp.guidem.guidemid}" />
																</td>
																<td><img style="width:50px;height:50px;" src="../files/${pp.photo}"></td>
																<td>${pp.guidename}</td>
																<td>${pp.guidenum }</td>
																<td>${pp.guidem.guidemnum }</td>
																<td>${pp.jingdu }</td>
																<td>${pp.weidu }</td>
																<td>${pp.youkeMnum }</td>
															</tr>
															
														</s:if>
														
													</s:iterator>
													
												</table>
												</form>
												<div class="btnright" style="margin-top:20px;float:center">
													
														<button id="btn_confirm" class="btn btn-primary btn-sm "
															type="button" onclick="gosd()">推送消息</button>
													
															<button id="btn_confirm2" class="btn btn-primary btn-sm "
															type="button" onclick="gosd2()">推送语音</button>
												</div>
											<div align="center">
												<div  id="pp" class="easyui-pagination" style="border:1px solid #ccc" data-options="
												total: <%=session.getAttribute("total") %>,pageSize:5">
												</div>
												</div>
												</div>
															<!--  -->

										<div id="pos" class="tab-pane">

											<div class="row">
												<div class="col-md-12">
													<div style="width:20%;float:left;">

														<!-- form表单 -->
														<form action="" id="chrisform" style="overflow-y:scroll;height:400px;">
															<ul class="list-group">
																<s:iterator value="#session.pb.pagelist" var="pp2">
																	<s:if test="#pp2.state==1">
																		<li class="list-group-item"><span> <input
																				id="check1" name="checkbox" value="${pp2.guidenum}"
																				type="checkbox" style="vertical-align:top;" /> <span
																				style="vertical-align:middle;">${pp2.guidename}</span>
																		</span></li>
																	</s:if>
																</s:iterator>

															</ul>
														</form>
													</div>


													<div style="74%;float:left;padding-left:10px;">
														<div>
															这里显示即将出现的经纬度<br> <input type="text" maxlength="100"
																size="100" id="show"></input>
														</div>
														<div id="container2"></div>
														<div id="r-result2">
															<input type="button" onclick="openHeatmap();"
																value="显示热力图" /><input type="button"
																onclick="closeHeatmap();" value="关闭热力图" />
														</div>
													</div>

												</div>
											</div>

										</div>

										<div id="profile" class="tab-pane">
											<!-- 显示热力图 -->
											<div id="container"></div>
											<div id="r-result">
												<input type="button" onclick="openHeatmap();" value="显示热力图" /><input
													type="button" onclick="closeHeatmap();" value="关闭热力图" />
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /span -->
						</div>
						<!-- row end-->
						<!--main content end-->


						<!--row end-->
					</div>
					<!--row end-->
			
				</div>
			</div>
			<div id="dd" >
				<form id="form3" action="../tui_Tuisong" method="post" > 
					<textarea   style="width:320px;height:100px;resize:none;" name="myword"/></textarea>
				<input type="hidden" name="hei"  id="myisd"/>
				
				<div style="padding-top:20px;padding-right:20%;">
					<button type="button" class="btn btn-primary " style="margin-right:10px;" onclick="this.form.submit()">
  						<span class="glyphicon glyphicon-ok"></span>确定
					</button>				
				</div></form>
				
			</div>
			
			<div id="dd2" >
		      <!--    <audio controls autoplay></audio>-->
		        <form action="../shangchuan_textAction" method="post" id="yinpin" >
			        <button onclick="startRecording()" type="button" value="录音" class="btn btn-success" style="margin-right:10px;">
			        	<span class="glyphicon glyphicon-record">录音</span>
			        </button>
			        <button class="btn btn-danger" onclick="stopRecording()" type="button" value="停止" style="margin-right:10px;">
			        	<span class="glyphicon glyphicon-pause">停止</span>
			        </button>
		        	<button onclick="uploadAudio()" type="button" value="提交" class="btn btn-info">
		        		<span class="glyphicon glyphicon-ok">提交</span>
		        	</button>
		        	 <!--         <input onclick="playRecording()" type="button" value="播放" />-->
		        </form>
		       	
    		</div>
			
			
			<!--消息提醒diaolog-->
					<div id="messageCall" style="top:90px; text-align:center">
					<table id="dg" class="easyui-datagrid" style="width:420px;height:274px;"
							toolbar="#toolbar" pagination="true" fitColumns="false"
							rownumbers="true"  singleSelect="true">
						<thead>
							<tr>
								<th field="flag" width="60px">
									标记
								</th>
								<th field="from" width="80px">
									来自
								</th>
								<th field="time" width="80px">
									时间
								</th>
								<th field="message" width="60px;">
									消息
								</th>
								<th field="remove" width="60px;">
									删除
								</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>未读</td>
								<td>sx0001</td>
								<td>2017/02/18</td>
								<td>
								<!--	glyphicon glyphicon-remove
								-->
									<span class="glyphicon glyphicon-volume-up" aria-hidden="true" onclick="openAudio()"></span>
								</td>
								<td>
									<span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="" style="color:red"></span>
								</td>
							</tr>
							<tr>
								<td>已读</td>
								<td>sx0002</td>
								<td>2017/02/18</td>
								<td>
									<span class="glyphicon glyphicon-volume-up" aria-hidden="true" onclick="openAudio()"></span>
								</td>
								<td>
									<span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="" style="color:red"></span>
								</td>
							</tr>
						</tbody>
					</table>
					
				  </div>
					<!--消息提醒end---->
			
				<div class="oAudio">
					<audio controls="controls" height="700" width="100" style="margin-top:30px;">
					    <source src="http://demo.mimvp.com/html5/take_you_fly.ogg" />
					    <source src="http://demo.mimvp.com/html5/take_you_fly.mp3" />
					    <source src="http://demo.mimvp.com/html5/take_you_fly.wav" />
					</audio>
										
				</div>
			<div class="dialogParent" >
				<audio controls="controls" height="700" width="100" style="margin-top:30px;">
					    <source src="http://demo.mimvp.com/html5/take_you_fly.ogg" />
					    <source src="http://demo.mimvp.com/html5/take_you_fly.mp3" />
					    <source src="http://demo.mimvp.com/html5/take_you_fly.wav" />
					</audio>
			</div>
				<!--历史数据-->
				<div id="hDate" style="top:90px; text-align:center">
					<table id="dg" class="easyui-datagrid" style="width:420px;height:274px;"
							toolbar="#toolbar" pagination="true" fitColumns="false"
							rownumbers="true"  singleSelect="true">
						<thead>
							<tr>
								<th field="from" width="95px">
									来自
								</th>
								<th field="time" width="95px">
									时间
								</th>
								<th field="message" width="75px;">
									监听数据
								</th>
								<th field="remove" width="75px;">
									删除
								</th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
								
								<td>sx0001</td>
								<td>2017/02/18</td>
								<td>
								<!--	glyphicon glyphicon-remove
								-->
									<span class="glyphicon glyphicon-volume-up" aria-hidden="true" onclick="openAudio()"></span>
								</td>
								<td>
									<span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="" style="color:red"></span>
								</td>
							</tr>
							<tr>
								
								<td>sx0002</td>
								<td>2017/02/18</td>
								<td>
									<span class="glyphicon glyphicon-volume-up" aria-hidden="true" onclick="openAudio()"></span>
								</td>
								<td>
									<span class="glyphicon glyphicon-remove" aria-hidden="true" onclick="" style="color:red"></span>
								</td>
							</tr>
						</tbody>
					</table>
					
				  </div>
					<!--消息提醒end---->
		
		
<script type="text/javascript">



	$(function(){
		
		
		$('#messageCall').dialog({
						closed : true,
		});
		
		$('#hDate').dialog({
						closed : true,
		});
		
		$(".dialogParent").dialog({
						closed : true,
		});
	});

	
	
	function openAudio(){
		$('.oAudio').dialog({
						title : '播放音频',
						width : 300,
						height : 100,
						closed : false,
						cache : true,
						href : '',
						modal : true
					});
		
		
	}
	
	function mCal(){
		$('#messageCall').dialog({
						title : '消息',
						width : 424,
						height : 300,
						closed : false,
						cache : true,
						href : '',
						modal : true
					});
		
	}
	
	function hDate(){
		$('#hDate').dialog({
						title : '历史数据',
						width : 424,
						height : 300,
						closed : false,
						cache : true,
						href : '',
						modal : true
					});
		
	}
	
	
	
</script>
			
 <script>
		var a=0;
        var recorder;

        var audio = document.querySelector('audio');

        function startRecording() {
            HZRecorder.get(function (rec) {
                recorder = rec;
                recorder.start();
                alert("已经开始录音");
            });
        }

        function stopRecording() {
        alert("已暂停");
        
            recorder.stop();
            
        }

        function playRecording() {
        alert("播放录音");
             recorder.play(audio);
             
        }

        function uploadAudio() {
        
            recorder.upload("../shangchuan_textAction", function (state, e) {
                switch (state
                ) {
                    case 'uploading':
                        //var percentComplete = Math.round(e.loaded * 100 / e.total) + '%';
                        break;
                    case 'ok':
                        //alert(e.target.responseText);
                        alert("上传成功");
                        break;
                    case 'error':
                        alert("上传失败");
                        break;
                    case 'cancel':
                        alert("上传被取消");
                        break;
                }
            });
            
        }

    </script>
<script type="text/javascript">

	function changeState(isChecked){
		var ch=document.getElementsByTagName("input");
		for(var i=0; i<ch.length;i++){
			if(ch[i].type == "checkbox"){
				ch[i].checked=isChecked;
			}
		}
	}
 	$('#dd').dialog({
						closed : true,
					});
					$('#dd2').dialog({
						closed : true,
					});
 $('#pp').pagination({
	    total:<%=session.getAttribute("total") %>,
	    pageNumber:<%=session.getAttribute("page") %>,
	    pageSize:<%=session.getAttribute("rows") %>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../findAll_Guide?i=2&page=" + pageNumber+"&rows="+pageSize;
    	}
    });
</script>
			<script type="text/javascript">
				J(function() {
					J('#cal1').calendar({
						format : 'yyyy年MM月dd日'
					});
					J('#cal2').calendar({
						format : 'yyyy年MM月dd日'
					});
				});
			</script>
</body>

<script type="text/javascript">
			
			
			 var s=''; 
			 var s1='';
			 var s2='';
			function gosd() {
			
		  		$('input[name="fuxuan"]:checked').each(function(){ 
		    		s+=$(this).val()+',';
					
					});
					var args={"shangchuan2":s};
					if(s == ""){
						alert("请选择导游");
						return false;
					}
					else alert("已选择导游，请发送消息或推送语音");
					$("#myisd").val(s);
							$('#dd').dialog({
								title : '推送消息',
								width : 400,
								height : 200,
								closed : false,
								iconCls:'icon-save',
								cache : true,
								href : '',
								modal : true
							});
							s="";
			}
			
			function gosd2() {
			$('input[name="fuxuan"]:checked').each(function(){ 
    		s1+=$(this).val()+',';
			});
			
			var args={"shangchuan2":s1};
			if(s1 == ""){
				alert("请选择导游");
				return false;
			}
			
			$.ajax({
                cache: true,
                type: "POST",
                url:"../shuju_textAction",
                data:args,// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                	
                }
            });
						s1="";
					$('#dd2').dialog({
						title : '推送语音',
						width : 300,
						height : 100,
						closed : false,
						iconCls:'icon-save',
						cache : true,
						href : '',
						modal : true
					});
			//使用ajax传递数据
			}
			
			//数据传送
			function gosd3() {
			$('input[name="fuxuan"]:checked').each(function(){ 
    		s2+=$(this).val()+',';
			});
			
			var args={"shangchuan2":s2};
			if(s2 == ""){
				alert("请选择导游");
				return false;
			}else{
				$('.oAudio').dialog({
								title : '数据监听',
								width : 300,
								height : 100,
								closed : false,
								
								cache : true,
								href : '',
								modal : true
							});
			}
				
			}
			
			
			

	// 选择或者反选 checkbox  
	function CheckSelect(thisform) {
		// 遍历 form  
		for ( var i = 0; i < thisform.elements.length; i++) {
			// 提取控件  
			var checkbox = thisform.elements[i];
			// 检查是否是指定的控件  
			if (checkbox.name === "groupCheckbox"
					&& checkbox.type === "checkbox"
					&& checkbox.checked === false) {
				// 正选  
				checkbox.checked = true;
			} else if (checkbox.name === "groupCheckbox"
					&& checkbox.type === "checkbox"
					&& checkbox.checked === true) {
				// 反选  
				checkbox.checked = false;
			}
		}
	}
</script>
<script type="text/javascript">
	var shuju;
	$(function() {
		$('input:checkbox[name="checkbox"]').on('change', function() {
			if ($('input:checkbox:checked').val()) {
				$.ajax({
					cache : true,
					type : "POST",
					url : "../checkbox_Guide",
					data : $('#chrisform').serialize(),// 你的formid
					async : false,

					success : function(data2) {
						$("#show").attr("value", data2);
						var data3 = JSON.parse(data2); 
						map2.enableScrollWheelZoom();
						map2.addOverlay(heatmapOverlay2);
						heatmapOverlay2.setDataSet({
							data : data3,
							max : 100
						});
						heatmapOverlay2.show();
					}
				});
			}
		});
	});
	var map = new BMap.Map("container"); // 创建地图实例
	var map2 = new BMap.Map("container2");
	var jing1 =<%=session.getAttribute("gjing1")%>
	var wei1 =<%=session.getAttribute("gwei1")%>
	var point = new BMap.Point(jing1, wei1);
	var point2 = new BMap.Point(jing1, wei1);
	map.centerAndZoom(point, 16); // 初始化地图，设置中心点坐标和地图级别
	map2.centerAndZoom(point2, 16);
	map.enableScrollWheelZoom(); // 允许滚轮缩放
	map2.enableScrollWheelZoom();
	map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
	map2.enableDragging();
	map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
	map2.enableDoubleClickZoom();
	map.enableKeyboard();//启用键盘上下左右键移动地图
	map2.enableKeyboard();

	//向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({
		anchor : BMAP_ANCHOR_TOP_LEFT,
		type : BMAP_NAVIGATION_CONTROL_LARGE
	});
	map.addControl(ctrl_nav);
	map2.addControl(ctrl_nav);
	//向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({
		anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
		isOpen : 1
	});
	map.addControl(ctrl_ove);
	map2.addControl(ctrl_ove);
	//向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_BOTTOM_LEFT
	});
	map.addControl(ctrl_sca);
	map2.addControl(ctrl_sca);

	var points =<%=session.getAttribute("initdata")%>
	if (!isSupportCanvas()) {
		alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~')
	}

	heatmapOverlay = new BMapLib.HeatmapOverlay({
		"radius" : 25
	});
	heatmapOverlay2 = new BMapLib.HeatmapOverlay({
		"radius" : 25
	});
	map.addOverlay(heatmapOverlay);
	map2.addOverlay(heatmapOverlay2);
	 
	
	heatmapOverlay.setDataSet({
		data : points,
		max : 100
	});
	/* heatmapOverlay2.setDataSet({
		data : points,
		max : 100
	}); */
	
	
	
	//是否显示热力图
	function openHeatmap() {
		heatmapOverlay.show();
		heatmapOverlay2.show();
	}
	function closeHeatmap() {
		heatmapOverlay.hide();
		heatmapOverlay2.hide();
	}
	closeHeatmap();

	//详细的参数,可以查看heatmap.js的文档 https://github.com/pa7/heatmap.js/blob/master/README.md
	//参数说明如下:
	/* visible 热力图是否显示,默认为true
	 * opacity 热力的透明度,1-100
	 * radius 势力图的每个点的半径大小   
	 * gradient  {JSON} 热力图的渐变区间 . gradient如下所示
	 *	{
			.2:'rgb(0, 255, 255)',
			.5:'rgb(0, 110, 255)',
			.8:'rgb(100, 0, 255)'
		}
		其中 key 表示插值的位置, 0~1. 
		    value 为颜色值. 
	 */

	function setGradient() {
		/*格式如下所示:
		{
			0:'rgb(102, 255, 0)',
		 	.5:'rgb(255, 170, 0)',
		 	1:'rgb(255, 0, 0)'
		}*/
		var gradient = {};
		var colors = document.querySelectorAll("input[type='color']");
		colors = [].slice.call(colors, 0);

		colors.forEach(function(ele) {
			gradient[ele.getAttribute("data-key")] = ele.value;
		});

		heatmapOverlay.setOptions({
			"gradient" : gradient
		});
	}

	//判断浏览区是否支持canvas
	function isSupportCanvas() {
		var elem = document.createElement('canvas');
		return !!(elem.getContext && elem.getContext('2d'));
	}
</script>
</html>