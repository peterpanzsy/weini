
    
$(document).ready( function() {        

	// sidebar menu click
	$('.templatemo-sidebar-menu li.sub a').click(function(){//一级菜单点击
//		$(".open").removeClass("open");
		$(".active").removeClass("active");
		if($(this).parent().hasClass('open')) {
			$(this).parent().removeClass('open');
		} else {
			$(this).parent().addClass('open active');
		}
	});  
	var $pathname=window.location.pathname;
	if($pathname.indexOf("/WeiNiManage/pages/adminManage")>=0){//二级菜单点击进入页面后，保持一级菜单的active效果
		$(".active").removeClass("active");
		$("#adminManage").addClass("open active");
	}
	switch($pathname){
	case "/WeiNiManage/pages/adminManage/rootAdmin.jsp":
		$("#rootAdminLi").css("background-color","#FFF");
		break;
	case "/WeiNiManage/pages/adminManage/financeAdmin.jsp":
		$("#financeAdminLi").css("background-color","#FFF");
		break;
	case "/WeiNiManage/pages/adminManage/goodAdmin.jsp":
		$("#goodAdminLi").css("background-color","#FFF");
		break;
	case "/WeiNiManage/pages/adminManage/ordinaryAdmin.jsp":
		$("#ordinaryAdminLi").css("background-color","#FFF");
		break;
		
	}	

	
}); // document.ready
