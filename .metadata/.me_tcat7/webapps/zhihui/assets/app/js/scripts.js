
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    
    $.backstretch([
                    "assets/app/images/background/1.jpg"
	              , "assets/app/images/background/2.jpg"
	              , "assets/app/images/background/3.jpg"
	             ], {duration: 3000, fade: 750});
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });
    
    $('.login-form').on('submit', function(e) {
    	
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    	
    });
    
   
    	 $("#form-password").val="";
    	
});
