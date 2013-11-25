<#-- 头尾   -->
<#macro html title="XXX后台运营管理" refresh="false" time=3 href="" >
	<!DOCTYPE html> 
	<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta http-equiv="keywords" content="" />
			<meta name="description" content=""/>
		  	<title>${title!"XXX后台运营管理"}</title>
			<#-- *************************  网站模板CSS  *********************** -->
			<link rel="stylesheet" href="${CSS_BASE_URL}/reset.css" type="text/css" media="screen" />
			<link rel="stylesheet" href="${CSS_BASE_URL}/main.css" type="text/css" media="screen" />
			<link rel="stylesheet" href="${CSS_BASE_URL}/invalid.css" type="text/css" media="screen" />
			
			<#-- *************************  网站模板JS   *********************** -->
			<script type="text/javascript" src="${JS_BASE_URL}/jquery-1.8.1.js"></script>
			<script type="text/javascript" src="${JS_BASE_URL}/jquery.wysiwyg.js"></script>
			<script type="text/javascript" src="${JS_BASE_URL}/jquery.configuration.js"></script>
			<script type="text/javascript" src="${JS_BASE_URL}/facebox.js"></script>
		</head>
			
		<body>
			<div id="body-wrapper">
				<div id="main-content">
					<#nested />
				</div> 
				<#include "../../oss_default_footer.ftl" />
			</div>
		</body>
	</html> 
</#macro>