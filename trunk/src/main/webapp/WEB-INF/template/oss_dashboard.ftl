<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${CSS_BASE_URL}/reset.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${CSS_BASE_URL}/style.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="${CSS_BASE_URL}/invalid.css" type="text/css" media="screen" />
	
	<#-- *************************  网站模板JS   *********************** -->
	<script type="text/javascript" src="${JS_BASE_URL}/jquery-1.8.1.js"></script>
	<script type="text/javascript" src="${JS_BASE_URL}/jquery.wysiwyg.js"></script>
	<script type="text/javascript" src="${JS_BASE_URL}/jquery.configuration.js"></script>
	<script type="text/javascript" src="${JS_BASE_URL}/facebox.js"></script>
</head>
<body>
	<div id="body-wrapper">
		<div id="sidebar">
			<div id="sidebar-wrapper">
				<div id="profile-links">
					您好, <a href="javascript:;" title="登录用户"><#if OSS_CONTEXT??>${OSS_CONTEXT.user.realName}<#else>游客</#if></a>, 欢迎进入系统.<br /><br />
        			<a target="_blank" href="http://www.vernon.com" title="进入XXX">进入XXX</a> |
        			<a href="${DOMAIN}/logout.do" title="退出" target="allFrame">退出</a> 
        		</div>
        
				<ul id="main-nav">
					<li><a href="template.jsp" target="mainFrame" class="nav-top-item index-fresh current"> 欢迎页面 </a></li>
					<#if groups?exists>
						<#list groups as group>
							<#if popedomsMap['${group.groupId}']?exists && (popedomsMap['${group.groupId}']?size > 0) >
								<li><a href="javascript:;" class="nav-top-item" name="${group.groupId}">${group.groupName?xml}</a>
									<ul>
										<#list popedomsMap['${group.groupId}'] as popedom >
											<li><a href="${DOMAIN + popedom.URI}" target="mainFrame">${popedom.popedomName?xml}</a></li>
										</#list>
									</ul>
								</li>
							</#if>
						</#list>
					</#if>
				</ul>

				<div id="messages" style="display: none">
					<h3>99 条消息</h3>
					<p>
						<strong>2012-04-13</strong> Vernon
					</p>
					<form action="#" method="post">
						<h4>新信息</h4>
						<fieldset>
							<textarea class="textarea" name="textfield" cols="79" rows="5"></textarea>
						</fieldset>
						<fieldset>
							<select name="dropdown" class="small-input">
								<option value="option1">发送...</option>
								<option value="option2">每个人</option>
								<option value="option3">管理员</option>
								<option value="option4">戴静</option>
							</select> <input class="button" type="submit" value="发送" />
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>