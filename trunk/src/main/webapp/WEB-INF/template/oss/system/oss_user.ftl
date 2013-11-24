<#assign oss=JspTaglibs["/WEB-INF/tld/vernon_oss_taglibs.tld"]>
<@voc.html title="用户管理" >
	
	<#-- 用户管理 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>用户管理</h3>
			<span class="align-right"><h3><a href="${DOMAIN}/user!editor.do">新建</a></h3></span>
		</div>
		<div class="content-box-content">
    		<div class="tab-content default-tab">
    			<#if ERROR_MESSAGE??>
	      			<div class="notification error png_bg"> 
	      				<a href="javascript:;" class="close">
	      					<img src="${IMG_BASE_URL}/icons/cross_grey_small.png" title="消息提醒" alt="关闭" />
	      				</a>
	        			<div> ${ERROR_MESSAGE} </div>
	      			</div>
      			<#else>
      				<div class="notification information png_bg"> 
	      				<a href="javascript:;" class="close">
	      					<img src="${IMG_BASE_URL}/icons/cross_grey_small.png" title="消息提醒" alt="关闭" />
	      				</a>
	        			<div> 用户管理,提供权限系统 
	        				<strong>用户建立</strong> / 
	        				<strong>修改</strong> / 
	        				<strong>删除</strong> / 
	        				<strong>锁定</strong> /
	        				<strong>重设密码</strong> /
	        				<strong>用户角色编辑</strong> /
	        				的管理功能.</div>
	      			</div>
      			</#if>
      			<table>
        			<thead>
          				<tr>
            				<th>用户编号</th>
            				<th>邮件地址</th>
            				<th>真实姓名</th>
            				<th>密码</th>
            				<th>备注信息</th>
            				<th>读写状态</th>
            				<th>锁定状态</th>
            				<th>基本操作</th>
          				</tr>
        			</thead>
        			<tbody>
        				<#if (users?exists && users.list?size > 0 )>
							<#list users.list as user>
		          				<tr>
			                		<td># ${user.userId}</td>
			                		<td>${user.email?xml}</td>
			                		<td>${user.realName?xml}</td>
			                		<td>${user.password?xml}</td>
			                		<td>${user.remark?xml}</td>
			                		<td><#if user.readOnly >只读	<#else>读写</#if></td>
			                		<td><#if user.locked >锁定<#else>未锁定</#if></td>
			                		<td>
										<a href="${DOMAIN}/user!editor.do?userId=${user.userId}" >编辑</a>|
										<a href="javascript:;" onclick="confirmPrompt('您确认删除(${user.email?xml})用户吗?本次操作不可恢复.','${DOMAIN}/user!remove.do?userId=${user.userId}');">删除</a>|
										<#if user.locked >
											<a href="javascript:;" onclick="confirmPrompt('您确认解锁(${user.email?xml})用户吗?','${DOMAIN}/user!unlock.do?userId=${user.userId}');">解锁</a>|
										<#else>
											<a href="javascript:;" onclick="confirmPrompt('您确认锁定(${user.email?xml})用户吗?','${DOMAIN}/user!lock.do?userId=${user.userId}');">锁定</a>|
										</#if>
										<a href="javascript:;" onclick="confirmPrompt('您确认重置(${user.email?xml})用户的密码吗?','${DOMAIN}/user!passwordReset.do?userId=${user.userId}');">重置密码</a>|
										<a href="${DOMAIN}/userRole.do?userId=${user.userId}">用户角色编辑</a>
									</td>
			              		</tr>
	        				</#list>
        				<#else>
							<tr>
								<td colspan="7">
									&nbsp;你要查看的角色列表为空
								</td>
							</tr>
						</#if>
	            	</tbody>
        			<tfoot></tfoot>
				</table>
			</div>
		</div>
	</div>
	<#-- ***************** 分页 **************** -->
	<@oss.pagination href="user.do" data="users" />
</@voc.html>
