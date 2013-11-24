<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<#-- *************************  网站模板CSS  *********************** -->
		<link rel="stylesheet" href="${CSS_BASE_URL}/reset.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="${CSS_BASE_URL}/style.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="${CSS_BASE_URL}/invalid.css" type="text/css" media="screen" />
	</head>


	<body id="login">
		<div id="login-wrapper" class="png_bg">
	  		<div id="login-top"></div>

	  		<div id="login-content">
	    		<form action="${DOMAIN}/login.do" method="post">
	      			<div class="notification information png_bg">
	      				<div>
		      				<#if ERROR_MESSAGE?exists>
		      					${ERROR_MESSAGE}
		      				<#else>
		      					欢迎来到XXX后台运营管理系统
		      				</#if>
	        			</div>
	      			</div>
	      			<p>
	        			<label>邮箱</label>
	        			<input class="text-input" type="text" name="email" value="${email!''}"/>
	      			</p>
	      			<div class="clear"></div>
	      			
	      			<p>
	        			<label>密码</label>
	        			<input class="text-input" type="password" name="password" value="${password!''}"/>
	      			</p>
	      			<div class="clear"></div>
	      			
	     			 <p id="remember-password">
	        			<input type="checkbox" checked="checked" />
	        			记住我
	        		</p>
	      			<div class="clear"></div>
	      			
	      			<p>
	        			<input class="button" type="submit" value="登录" />
	      			</p>
	    		</form>
			</div>
		</div>
		<#-- *************************  网站模板JS   *********************** -->
		<script type="text/javascript" src="${JS_BASE_URL}/jquery-1.8.1.js"></script>
		<script type="text/javascript" src="${JS_BASE_URL}/jquery.configuration.js"></script>
</body>
</html>
