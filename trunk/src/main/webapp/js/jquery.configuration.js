$(document).ready(function(){
	// 手风琴菜单栏
	$("#main-nav li ul").hide(); // 将id="main-nav"下的li的ul全部隐藏
	$("#main-nav li a.current").parent().find("ul").slideToggle("slow"); // 三种预定速度之一的字符串("slow", "normal", or "fast")或表示动画时长的毫秒数值(如：1000)
	
	// 给默认打开的a标签加上点击事件
	$("#main-nav li a.current").parent().find("ul").children().click(
		function(){
			$(this).siblings().children().removeClass("current");
			$(this).children().addClass("current");
		}
	);
	
	$("#main-nav li a.nav-top-item").click( 
		function () {
			// 给a标签添加事件
			$(this).next().children().click(function(){
				$(this).siblings().children().removeClass("current");
				$(this).children().addClass("current");
			});
			/**
			 * 1. $(this).parent().siblings():找出除去当前的li,与自己同辈的元素.
			 * 2. slideUp:正常的隐藏
			 */
			$(this).parent().siblings().find("ul").slideUp("normal");
			$(this).next().slideToggle("normal"); // 滑动子选项
			$(this).addClass("current");// 添加当前css
			$(this).parent().siblings().find("a").removeClass("current");//删掉其他含有current
			return false;
		}
	);
	
	
	$("#main-nav li a.index-fresh").click( // 首页选项
		function () {
			top.location.href=(top.location.href); // 不做任何操作,返回自己本页信息
			return false;
		}
	); 

    // 当鼠标放在菜单栏文字的左右移动效果
	$("#main-nav li .nav-top-item").hover(
		function () {
			$(this).stop().animate({ paddingRight: "25px" }, 200);// 鼠标放上去,右边距为 25px
		}, 
		function () {
			$(this).stop().animate({ paddingRight: "15px" });// 鼠标移开,右边距为 25px
		}
	);

    // 内容盒子
	$(".content-box-header h3").css({ "cursor":"s-resize" }); // 鼠标放上去有上下移动的样子
	$(".closed-box .content-box-content").hide(); // 隐藏内容
	// $(".closed-box .content-box-tabs").hide(); 
	
	$(".content-box-header h3").click( 
		function () {
		  $(this).parent().next().toggle(); // 如果是隐藏的,切换成显示,如果是显示,切换成隐藏
		  $(this).parent().parent().toggleClass("closed-box"); // 存在就删除,不存在就添加
		  $(this).parent().find(".content-box-tabs").toggle(); 
		}
	);

    // 进入页面默认
	$('.content-box .content-box-content div.tab-content').hide(); 
	$('ul.content-box-tabs li a.default-tab').addClass('current'); 
	$('.content-box-content div.default-tab').show(); 
	
	$('.content-box ul.content-box-tabs li a').click( // 表单
		function() { 
			$(this).parent().siblings().find("a").removeClass('current'); 
			$(this).addClass('current');
			var currentTab = $(this).attr('href'); 
			$(currentTab).siblings().hide(); 
			$(currentTab).show(); 
			return false; 
		}
	);

    // 关闭
	$(".close").click(
		function () {
			$(this).parent().fadeTo(400, 0, function () { 
				$(this).slideUp(400);
			});
			return false;
		}
	);

    // 给偶数行
	$('tbody tr:even').addClass("alt-row"); 

    // 全选
	$('.check-all').click(
		function(){
			$(this).parent().parent().parent().parent().find("input[type='checkbox']").attr('checked', $(this).is(':checked'));   
		}
	);

    // a标签rel属性包含modal
	$('a[rel*=modal]').facebox(); 

	$(".wysiwyg").wysiwyg(); 

});
  
  
  