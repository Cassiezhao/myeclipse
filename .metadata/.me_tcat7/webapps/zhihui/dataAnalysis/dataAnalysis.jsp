<%@page import="chris.pojo.pingjiafen"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>数据分析</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />


<script type="text/javascript" src="../assets/app/js/search.js"></script>
<link rel="stylesheet" href="../assets/app/css/search.css" />
<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
<script type="text/javascript"
	src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
<!-- 百度地图 -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=DGNFeh22K1TSexlaulHV9vA4l7NK91Hu"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/library/Heatmap/2.0/src/Heatmap_min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#list2").css('display', 'none');
		$("#list3").css('display', 'none');
		$("#list6").css('display', 'none');
		$("#list9").css('display', 'none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu10").addClass("active");

	});
</script>
<style type="text/css">
.but {
	display: inline-block;
	position: relative;
	margin: 10px;
	padding: 0 20px;
	text-align: center;
	text-decoration: none;
	font: bold 12px/25px Arial, sans-serif;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, .22);
	-webkit-border-radius: 30px;
	-moz-border-radius: 30px;
	border-radius: 30px;
	-webkit-box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	-moz-box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	box-shadow: 1px 1px 1px rgba(0, 0, 0, .29), inset 1px 1px 1px
		rgba(255, 255, 255, .44);
	-webkit-transition: all 0.15s ease;
	-moz-transition: all 0.15s ease;
	-o-transition: all 0.15s ease;
	-ms-transition: all 0.15s ease;
	transition: all 0.15s ease;
}

.blue {
	color: #3399cc;
	background: #70c9e3; /* Old browsers */
	background: -moz-linear-gradient(top, #70c9e3 0%, #39a0be 100%);
	/* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #70c9e3),
		color-stop(100%, #39a0be) ); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #70c9e3 0%, #39a0be 100%);
	/* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #70c9e3 0%, #39a0be 100%);
	/* Opera 11.10+ */
	background: -ms-linear-gradient(top, #70c9e3 0%, #39a0be 100%);
	/* IE10+ */
	background: linear-gradient(top, #70c9e3 0%, #39a0be 100%); /* W3C */
}
</style>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-35" data-genuitec-path="/zhihui2/WebRoot/dataAnalysis/dataAnalysis.jsp">
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->

	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-35" data-genuitec-path="/zhihui2/WebRoot/dataAnalysis/dataAnalysis.jsp">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a>
				</li>

				<li>数据分析</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					数据分析 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
				</font>

			</div>
			<!-- 图表4个div start -->
			<div style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<table>
					<tr>
					当前在线人数为:${zaixianrenshu}<br>	<td style="width:540px;height:200px;text-align:center">
							<div id="img1" style="width:540px;height:200px"></div></td>
						<td style="width:540px;height:235px;text-align:center">
							<div id="img2" style="width:540px;height:200px"></div>
							<div style="padding-top:10px;width:180px;margin:auto;">
								<!-- 点击按钮事件js处理在代码最后一行 -->
								<button class="but " style="color:#000000" id="but1">本日</button>

								<button class="but blue" id="but2" style="color:#000000">本月</button>

							</div></td>
					</tr>
					<tr>
						<td style="width:540px;height:400px;">
							<div id="img3"
								style="width:350px;height:200px;margin:auto;float:left"></div>
							<div style="float:left;padding-left:0px;">
								           游客总人数：<input type="button" id="myperson"
								value="${pjlei.myperson }" readonly="readonly"
									style="background-color:#ffffff;height:26px;border:none" /><br>
									
									实际评价次数：<input type="button" value="${pjlei.pingjia }" id="pjcs"
									readonly="readonly"  
									style="background-color:#ffffff;height:26px;border:none"/><br> 
									
									评价比例:<input type="button"
									id="rare" value="${pjlei.rare }" readonly="readonly" 
									style="background-color:#ffffff;height:26px;border:none"/><br>
									
									评价平均分：<input id="areas" type="button" value="${pjlei.sumarea }"
									readonly="readonly" 
									style="background-color:#ffffff;height:26px;border:none"/><br> 
							</div>
							<div style="padding-top:10px;width:180px;margin:auto;">
								<button class="but " style="color:#000000" id="but3">本日</button>

								<button class="but blue" id="but4" style="color:#000000">本月</button>
							</div></td>
						<td style="width:540px;height:400px;text-align:center">
							<div id="img4"
								style="width:350px;height:200px;margin:auto;float:left"" >
							</div>
							<div style="float:left;padding-left:0px;">
									平均带团时间:<input type="button" value="${avertime}分钟" id="avertime"
									readonly="readonly" 
									style="background-color:#ffffff;height:26px;border:none"
									/><br> 
							</div>
							<div style="padding-top:10px;width:180px;margin:auto;">
								<button class="but " style="color:#000000" id="but5">本日</button>

								<button class="but blue" id="but6" style="color:#000000">本月</button>

							</div>
						</td>
					</tr>
				</table>

			</div>
			<!-- 图表4个div end-->
			<!--row end-->

		</div>
	</div>
	<script type="text/javascript">
		var map = new BMap.Map("img1"); // 创建地图实例
		var jing1 =
	<%=session.getAttribute("gjingdu")%>
		var wei1 =
	<%=session.getAttribute("gweidu")%>
		var point = new BMap.Point(jing1, wei1);
		map.centerAndZoom(point, 16); // 初始化地图，设置中心点坐标和地图级别
		map.enableScrollWheelZoom(); // 允许滚轮缩放
		map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
		map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
		map.enableKeyboard();//启用键盘上下左右键移动地图

		//向地图中添加缩放控件
		var ctrl_nav = new BMap.NavigationControl({
			anchor : BMAP_ANCHOR_TOP_LEFT,
			type : BMAP_NAVIGATION_CONTROL_LARGE
		});
		map.addControl(ctrl_nav);
		//向地图中添加缩略图控件
		var ctrl_ove = new BMap.OverviewMapControl({
			anchor : BMAP_ANCHOR_BOTTOM_RIGHT,
			isOpen : 1
		});
		map.addControl(ctrl_ove);
		//向地图中添加比例尺控件
		var ctrl_sca = new BMap.ScaleControl({
			anchor : BMAP_ANCHOR_BOTTOM_LEFT
		});
		map.addControl(ctrl_sca);

		var points =
	<%=session.getAttribute("datas")%>
		//var points = JSON.parse(point); 
		if (!isSupportCanvas()) {
			alert('热力图目前只支持有canvas支持的浏览器,您所使用的浏览器不能使用热力图功能~');
		}

		heatmapOverlay = new BMapLib.HeatmapOverlay({
			"radius" : 25
		});
		map.addOverlay(heatmapOverlay);

		heatmapOverlay.setDataSet({
			data : points,
			max : 100
		});
		heatmapOverlay.show();

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

	<script type="text/javascript">
		var dom = document.getElementById("img2");
		var myChart1 = echarts.init(dom);
		var app = {};
		var heihei =
	<%=session.getAttribute("datapingjia")%>
		;
		option = null;
		app.title = '坐标轴刻度与标签对齐';
		option = {
			color : [ '#3398DB' ],
			title : {
				text : '各时间段客流量分析',
				x : 'center'
			},
			tooltip : {
				trigger : 'axis',
				axisPointer : { // 坐标轴指示器，坐标轴触发有效
					type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
				}
			},
			grid : {
				left : '3%',
				right : '4%',
				bottom : '3%',
				containLabel : true
			},
			xAxis : [ {
				type : 'category',
				data : [ '8:00-10:00', '10:00-12:00', '12:00-14:00',
						'14:00-16:00', '16:00-18:00', '18:00-20:00' ],
				axisTick : {
					alignWithLabel : true
				}
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '游客人数',
				type : 'bar',
				barWidth : '60%',

				data : heihei,
			} ]
		};

		if (option && typeof option === "object") {
			myChart1.setOption(option, true);
		}
	</script>
	<script type="text/javascript">
		
	<%int a[] = (int[]) session.getAttribute("fenji");%>
		;
		var dom = document.getElementById("img3");
		var myChart2 = echarts.init(dom);
		var app = {};
		option = null;
		app.title = '环形图';

		option = {
			title : {
				text : '评价星级占比',

				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : [ {
					value :
	<%=a[0]%>
		,
					name : '1级'
				}, {
					value :
	<%=a[1]%>
		,
					name : '2级'
				}, {
					value :
	<%=a[2]%>
		,
					name : '3级'
				}, {
					value :
	<%=a[3]%>
		,
					name : '四级'
				}, {
					value :
	<%=a[4]%>
		,
					name : '五级'
				} ],
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};
		if (option && typeof option === "object") {
			myChart2.setOption(option, true);
		}
	</script>
	<script type="text/javascript">
		
	<%int b[] = (int[]) session.getAttribute("dtsj");%>
		;
		var dom = document.getElementById("img4");
		var myChart3 = echarts.init(dom);
		var app = {};
		option = null;
		app.title = '环形图';
		option = {
			title : {
				text : '带团时间比例',

				x : 'center'
			},
			tooltip : {
				trigger : 'item',
				formatter : "{a} <br/>{b} : {c} ({d}%)"
			},
			legend : {
				orient : 'vertical',
				left : 'left',
				data : [ '一级', '二级', '三级', '四级', '五级' ]
			},
			series : [ {
				name : '访问来源',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '60%' ],
				data : [ {
					value :
	<%=b[0]%>
		,
					name : '30分'
				}, {
					value :
	<%=b[1]%>
		,
					name : '60分'
				}, {
					value :
	<%=b[2]%>
		,
					name : '90分'
				}, {
					value :
	<%=b[3]%>
		,
					name : '120分'
				}, {
					value :
	<%=b[4]%>
		,
					name : '高于120分'
				} ],
				itemStyle : {
					emphasis : {
						shadowBlur : 10,
						shadowOffsetX : 0,
						shadowColor : 'rgba(0, 0, 0, 0.5)'
					}
				}
			} ]
		};

		if (option && typeof option === "object") {
			myChart3.setOption(option, true);
		}
	</script>

	<script type="text/javascript">
		$(function() {
			$("#but1").click(
					function() {

						$("#but2").removeClass("blue");
						$("#but1").addClass("blue");
						$.ajax({
							cache : true,
							type : "POST",
							url : "../keliuliang?ssh=0",
							data : null,// 你的formid
							async : false,
							error : function(request) {
								alert("请求错误");
							},
							success : function(data) {
								var heihei = eval(data);
								//alert(heihei);
								option = {
									color : [ '#3398DB' ],
									title : {
										text : '各时间段客流量分析',
										x : 'center'
									},
									tooltip : {
										trigger : 'axis',
										axisPointer : { // 坐标轴指示器，坐标轴触发有效
											type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
										}
									},
									grid : {
										left : '3%',
										right : '4%',
										bottom : '3%',
										containLabel : true
									},
									xAxis : [ {
										type : 'category',
										data : [ '8:00-10:00', '10:00-12:00',
												'12:00-14:00', '14:00-16:00',
												'16:00-18:00', '18:00-20:00' ],
										axisTick : {
											alignWithLabel : true
										}
									} ],
									yAxis : [ {
										type : 'value'
									} ],
									series : [ {
										name : '游客人数',
										type : 'bar',
										barWidth : '60%',
										data : heihei,
									} ]
								};
								myChart1.hideLoading();
								// 为echarts对象加载数据
								myChart1.setOption(option);
							}
						});
					});
			$("#but2").click(
					function() {
						$("#but1").removeClass("blue");
						$("#but2").addClass("blue");
						$.ajax({
							cache : true,
							type : "POST",
							url : "../keliuliang?ssh=1",
							data : null,// 你的formid
							async : false,
							error : function(request) {
								alert("请求错误");
							},
							success : function(data) {
								var heihei = eval(data);
								//alert(heihei);
								option = {
									color : [ '#3398DB' ],
									title : {
										text : '各时间段客流量分析',
										x : 'center'
									},
									tooltip : {
										trigger : 'axis',
										axisPointer : { // 坐标轴指示器，坐标轴触发有效
											type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
										}
									},
									grid : {
										left : '3%',
										right : '4%',
										bottom : '3%',
										containLabel : true
									},
									xAxis : [ {
										type : 'category',
										data : [ '8:00-10:00', '10:00-12:00',
												'12:00-14:00', '14:00-16:00',
												'16:00-18:00', '18:00-20:00' ],
										axisTick : {
											alignWithLabel : true
										}
									} ],
									yAxis : [ {
										type : 'value'
									} ],
									series : [ {
										name : '游客人数',
										type : 'bar',
										barWidth : '60%',
										data : heihei,
									} ]
								};
								myChart1.hideLoading();
								// 为echarts对象加载数据
								myChart1.setOption(option);
							}
						});
					});

			$("#but3")
					.click(
							function() {
								$("#but4").removeClass("blue");
								$("#but3").addClass("blue");
								$
										.ajax({
											cache : true,
											type : "POST",
											url : "../xingji?ssh=3",
											data : null,// 你的formid
											async : false,
											error : function(request) {
												alert("请求错误");
											},
											success : function(data) {
												//改变value值

												var array = eval('(' + data
														+ ')');

												$("#areas").val(array.sumarea);
												$("#pjcs").val(array.pingjia);
												$("#rare").val(array.rare);
												$("#myperson").val(
														array.myperson);

												option = {
													title : {
														text : '评价星级占比',

														x : 'center'
													},
													tooltip : {
														trigger : 'item',
														formatter : "{a} <br/>{b} : {c} ({d}%)"
													},
													legend : {
														orient : 'vertical',
														left : 'left',
														data : [ '直接访问',
																'邮件营销', '联盟广告',
																'视频广告', '搜索引擎' ]
													},
													series : [ {
														name : '访问来源',
														type : 'pie',
														radius : '55%',
														center : [ '50%', '60%' ],
														data : [
																{
																	value : array.shuzu[0],
																	name : '1级'
																},
																{
																	value : array.shuzu[1],
																	name : '2级'
																},
																{
																	value : array.shuzu[2],
																	name : '3级'
																},
																{
																	value : array.shuzu[3],
																	name : '四级'
																},
																{
																	value : array.shuzu[4],
																	name : '五级'
																} ],
														itemStyle : {
															emphasis : {
																shadowBlur : 10,
																shadowOffsetX : 0,
																shadowColor : 'rgba(0, 0, 0, 0.5)'
															}
														}
													} ]
												};
												myChart2.hideLoading();
												// 为echarts对象加载数据
												myChart2.setOption(option);
											}
										});

							});
			$("#but4")
					.click(
							function() {
								$("#but3").removeClass("blue");
								$("#but4").addClass("blue");
								$
										.ajax({
											cache : true,
											type : "POST",
											url : "../xingji?ssh=4",
											data : null,// 你的formid
											async : false,
											error : function(request) {
												alert("请求错误");
											},
											success : function(data) {
												//改变value值
												var array = eval('(' + data
														+ ')');
												//alert(array);
												$("#areas").val(array.sumarea);
												$("#pjcs").val(array.pingjia);
												$("#rare").val(array.rare);
												$("#myperson").val(
														array.myperson);
												option = {
													title : {
														text : '评价星级占比',

														x : 'center'
													},
													tooltip : {
														trigger : 'item',
														formatter : "{a} <br/>{b} : {c} ({d}%)"
													},
													legend : {
														orient : 'vertical',
														left : 'left',
														data : [ '直接访问',
																'邮件营销', '联盟广告',
																'视频广告', '搜索引擎' ]
													},
													series : [ {
														name : '访问来源',
														type : 'pie',
														radius : '55%',
														center : [ '50%', '60%' ],
														data : [
																{
																	value : array.shuzu[0],
																	name : '1级'
																},
																{
																	value : array.shuzu[1],
																	name : '2级'
																},
																{
																	value : array.shuzu[2],
																	name : '3级'
																},
																{
																	value : array.shuzu[3],
																	name : '四级'
																},
																{
																	value : array.shuzu[4],
																	name : '五级'
																} ],
														itemStyle : {
															emphasis : {
																shadowBlur : 10,
																shadowOffsetX : 0,
																shadowColor : 'rgba(0, 0, 0, 0.5)'
															}
														}
													} ]
												};
												myChart2.hideLoading();
												// 为echarts对象加载数据
												myChart2.setOption(option);
											}
										});
							});

			$("#but5").click(function() {
				$("#but6").removeClass("blue");
				$("#but5").addClass("blue");
				$.ajax({
					cache : true,
					type : "POST",
					url : "../dtsjbl?ssh=5",
					data : null,// 你的formid
					async : false,
					error : function(request) {
						alert("请求错误");
					},
					success : function(data) {
						//改变value值
						var array = eval('(' + data + ')');
						//alert(array);
						$("#avertime").val(array.avertime);
						option = {
							title : {
								text : '带团时间比例',

								x : 'center'
							},
							tooltip : {
								trigger : 'item',
								formatter : "{a} <br/>{b} : {c} ({d}%)"
							},
							legend : {
								orient : 'vertical',
								left : 'left',
								data : [ '一级', '二级', '三级', '四级', '五级' ]
							},
							series : [ {
								name : '访问来源',
								type : 'pie',
								radius : '55%',
								center : [ '50%', '60%' ],
								data : [ {
									value :
	array.shijianzhanbi[0]
		,
									name : '30分'
								}, {
									value :
	array.shijianzhanbi[1]
		,
									name : '60分'
								}, {
									value :
	array.shijianzhanbi[2]
		,
									name : '90分'
								}, {
									value :
	array.shijianzhanbi[3]
		,
									name : '120分'
								}, {
									value :
	array.shijianzhanbi[4]
		,
									name : '高于120分'
								} ],
								itemStyle : {
									emphasis : {
										shadowBlur : 10,
										shadowOffsetX : 0,
										shadowColor : 'rgba(0, 0, 0, 0.5)'
									}
								}
							} ]
						};
						myChart3.hideLoading();
						// 为echarts对象加载数据
						myChart3.setOption(option);
					}
				});
			});
			$("#but6").click(function() {
				$("#but5").removeClass("blue");
				$("#but6").addClass("blue");
				$.ajax({
					cache : true,
					type : "POST",
					url : "../dtsjbl?ssh=6",
					data : null,// 你的formid
					async : false,
					error : function(request) {
						alert("请求错误");
					},
					success : function(data) {
						//改变value值
						var array = eval('(' + data + ')');
						//alert(array);
						$("#avertime").val(array.avertime);
						option = {
							title : {
								text : '带团时间比例',

								x : 'center'
							},
							tooltip : {
								trigger : 'item',
								formatter : "{a} <br/>{b} : {c} ({d}%)"
							},
							legend : {
								orient : 'vertical',
								left : 'left',
								data : [ '一级', '二级', '三级', '四级', '五级' ]
							},
							series : [ {
								name : '访问来源',
								type : 'pie',
								radius : '55%',
								center : [ '50%', '60%' ],
								data : [ {
									value :
	array.shijianzhanbi[0]
		,
									name : '30分'
								}, {
									value :
	array.shijianzhanbi[1]
		,
									name : '60分'
								}, {
									value :
	array.shijianzhanbi[2]
		,
									name : '90分'
								}, {
									value :
	array.shijianzhanbi[3]
		,
									name : '120分'
								}, {
									value :
	array.shijianzhanbi[4]
		,
									name : '高于120分'
								} ],
								itemStyle : {
									emphasis : {
										shadowBlur : 10,
										shadowOffsetX : 0,
										shadowColor : 'rgba(0, 0, 0, 0.5)'
									}
								}
							} ]
						};
						myChart3.hideLoading();
						// 为echarts对象加载数据
						myChart3.setOption(option);
					}
				});
			});

		});
	</script>


</body>
</html>
