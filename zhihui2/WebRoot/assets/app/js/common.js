		$(document).click(function(e){
			var $menu=$(e.target).parent().attr("id");
			var $index=$menu.substr(4,1);
			var list="#list"+$index;
			if($(list).css("display")=="none"){
				$(list).css("display","block");
			}else{
				$(list).css("display","none");
			}
			$menuitemli=$('.menuitem li');
			$aBefore=$('.tree .submenu .menuitem li a:before');
	  		$aBefore.css("height",$menuitemli.css("height"));
	  		// $liBefore=$('.tree .submenu .menuitem li:before');
	  		// $tmp=$menuitemli.css("height");
	  		// $tmp=$tmp.substr(0,$tmp.length-2);
	  		// $height1=parseInt($tmp)/2;
	  		// $liBefore.css("margin-top","19px");
	  		
		});
		$(document).ready(function(){
	  		$height=$(document).height();
	  		$mainHeight=$('#main-content');
	  		if($mainHeight.css("height")<$height){
	  			$mainHeight.css("height",$height);
	  		}else{
	  			$mainHeight.css("height",$height);
	  		}

	  		$submenu=$('.submenu');
	  		$menuitem=$('.menuitem')
	  		$menuitemli=$('.menuitem li');
	  		$menuWidth=$submenu.css("width");
	  		$menuitemli.css("width",$menuWidth);
	  		// $aBefore=$('.tree .submenu .menuitem li a:before');
	  		// $aBefore.css("height",$menuitemli.css("height"));
	  		// alert($menuitemli.css("height"));
	  		

	  		
	  		
	  		
	  		
	  	});
		
		$('#checkedAll').click(function(){
			if(this.checked){
			 $('[name=checkboxt]:checkbox').attr('checked',"true");
			 }else{
			$('[name=checkboxt]:checkbox').attr('checked',"false");
			}
		}); 
		
		$.extend($.fn.validatebox.defaults.rules, {
		    
			mobile: {// 验证手机号码
	            validator: function (value) {
	                return /^(13|15|18)\d{9}$/i.test(value);
	            },
	            message: '手机号码格式不正确'
	        }
		    
		});
