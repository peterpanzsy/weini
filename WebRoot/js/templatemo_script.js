
    
$(document).ready( function() {        

	// sidebar menu click
	$('.templatemo-sidebar-menu li.sub a').click(function(){
//		$(".open").removeClass("open");
		$(".active").removeClass("active");
		if($(this).parent().hasClass('open')) {
			$(this).parent().removeClass('open');
		} else {
			$(".active").removeClass("active");
			$(this).parent().addClass('open active');
		}
	});  
	var $pathname=window.location.pathname;
	if($pathname.indexOf("/WeiNiManage/pages/adminManage")>=0){
		$(".active").removeClass("active");
		$("#adminManage").addClass("open active");
	}
		

	
}); // document.ready
