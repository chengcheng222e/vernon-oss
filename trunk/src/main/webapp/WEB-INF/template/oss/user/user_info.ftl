<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- *************************  网站模板CSS  *********************** -->
		<link rel="stylesheet" href="<%=basePath %>css/reset.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath %>css/main.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="<%=basePath %>css/invalid.css" type="text/css" media="screen" />
		
		<!-- *************************  网站模板JS   *********************** -->
		<script type="text/javascript" src="<%=basePath %>js/jquery-1.8.1.js"></script>
		<script type="text/javascript" src="<%=basePath %>js/jquery.configuration.js"></script>
	</head>
	<body>
		<div id="body-wrapper">
			<div id="main-content">
		    
		    	<div class="content-box">
					<div class="content-box-header">
						<h3>新建博客</h3>
						<div class="clear"></div>
					</div>
				
					<div class="content-box-content">
						<div class="tab-content default-tab" >
							<form action="#" method="post">
			            		<fieldset>
			            			<p>
			              				<label>标题</label>
			              				<input class="text-input medium-input" type="text" id="large-input" name="large-input" placeholder="请输入标题"/>
			            			</p>
						            <p>
			              				<label>类型</label>
			              				<select name="dropdown" class="small-input">
			              					<s:iterator value="#request.categorys" id="category">
			              						<option value="<s:property value="#category.value"/>"><s:property value="#category.remark"/></option>
			              					</s:iterator>
			              				</select>
			            			</p>
						            <p>
						              	<input class="button" type="submit" value="提交" />
						            </p>
			            		</fieldset>
		            			<div class="clear"></div>
		          			</form>
		        		</div>
					</div>
		    	</div>
		    	<div class="clear"></div>
		    	<jsp:include page="/footer.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
