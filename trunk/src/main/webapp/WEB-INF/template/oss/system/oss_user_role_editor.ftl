<@voc.html title="用户角色对应关系编辑" >
	
	<#-- 用户角色对应关系浏览 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>用户角色对应关系浏览</h3>
		</div>
		<div class="content-box-content">
    		<div class="tab-content default-tab">
      			<table>
        			<thead>
          				<tr>
            				<th>用户编号</th>
            				<th>邮件地址</th>
            				<th>锁定状态</th>
            				<th>读写状态</th>
            				<th>真实姓名</th>
            				<th>备注</th>
          				</tr>
        			</thead>
        			<tbody>
        				<#if user??>
	          				<tr>
		                		<td># ${user.userId}</td>
		                		<td>${user.email?xml}</td>
		                		<td>${user.remark?xml}</td>
		                		<td><#if user.locked >锁定<#else>未锁定</#if></td>
		                		<td><#if user.readOnly >只读	<#else>读写</#if></td>
		                		<td>${user.realName?xml}</td>
		              		</tr>
						</#if>
	            	</tbody>
        			<tfoot></tfoot>
				</table>
			</div>
		</div>
	</div>
	
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
			<div> <strong>用户角色</strong>管理,为该用户赋予角色.可以多选,最后一起提交.</div>
		</div>
	</#if>
	
	<#-- 用户角色管理 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>用户角色管理</h3>
		</div>
		<div class="content-box-content">
    		<div class="tab-content default-tab">
				<form action="${DOMAIN}/userRole.do" method="post">
					<fieldset>
						<table>
		        			<thead>
		          				<tr>
			        				<th><input class="check-all" type="checkbox"></th>
		            				<th>用户角色</th>
		          				</tr>
		        			</thead>
		        			<tbody>
								<#list roles as role>
									<tr>
										<td>
											<input name="roleId" type="checkbox" value="${role.roleId}" <#if userRoleMap['${role.roleId}']?exists >checked="true"</#if>/>
										</td>
						               	<td>${role.roleName?xml}</td>
						            </tr>
								</#list>
				            </tbody>
		        			<tfoot></tfoot>
						</table>
					</div>
				</div>
			</div>
			<p>
				<#-- 隐藏 -->
				<input type="hidden" id="userId" name="userId" value="<#if user?exists>${user.userId}</#if>" />
				<input type="hidden" name="token" value="<#if token?exists>${token?xml}</#if>" />
				<input class="button" type="submit" value="继续" />
				<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/user.do'"/>
			</p>
		</fieldset>
	</form>
	
	
	
		
</@voc.html>
