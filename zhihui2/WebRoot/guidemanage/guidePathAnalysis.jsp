<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
	<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8"/>
    <title>导游上下线情况</title>
    <style type="text/css">
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
</style>

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=DGNFeh22K1TSexlaulHV9vA4l7NK91Hu&services=true"></script>
    
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
		<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok8").addClass("active");
	})
</script>
  </head>
  
  <body>	
	<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				
				
				<!-- main start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  			  
							<li>
								<a href="guideOnlineMessage.jsp">上下线详情</a>
							</li>
							<li>导游路径分析</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								导游路径分析
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
							</font>
							
						</div>
						<!-- /.page-header -->
						
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					
					<div class="col-md-12">	
						<!-- 路径图 -->
						<!--百度地图容器-->
  <div style="width:100%;height:560px;border:#ccc solid 1px;" id="dituContent"></div>
						<!-- table end -->
					</div>
					<!--col 12 end-->
					
				</div>
			</div>	
		<!--row end-->						
		
		</div>
	</div>
	
	
	<script type="text/javascript">

    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addPolyline();//向地图中添加线
    }
    
    //创建地图函数：
    function createMap(){
    	var jingdu=<%=session.getAttribute("jingdu")%>
    	var weidu=<%=session.getAttribute("weidu")%>
       var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(jingdu,weidu);//定义一个中心点坐标
        map.centerAndZoom(point,16);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
		
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});	
	map.addControl(ctrl_nav);
	
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:1});
	map.addControl(ctrl_ove);
	
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
	
    
//标注线数组
	var a=<%=session.getAttribute("shuai") %>;
    var plPoints =a;
		 
		 
    //向地图中添加线函数
    function addPolyline(){
		
		for(var i=0;i<plPoints.length;i++)
		{
			var json = plPoints[i];
			
			var points = [];
			
			for(var j=0;j<json.points.length;j++){
				
				var p1 = json.points[j].lng;
				var p2 = json.points[j].lat;
				
				points.push(new BMap.Point(p1,p2));
			}
			
			//style:,weight:4,color:"#f00",opacity:0.6,
			var line = new BMap.Polyline(points,{strokeStyle:"solid",strokeWeight:"5",strokeColor:"#00A",strokeOpacity:"0.6"});
			
			map.addOverlay(line);
		}
	}
    
    initMap();//创建和初始化地图
</script>
  </body>
</html>