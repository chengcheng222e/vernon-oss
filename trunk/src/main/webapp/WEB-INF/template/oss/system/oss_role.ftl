<@voc.html title="用户角色" >
	
	<#-- 角色管理 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>用户角色管理</h3>
			<span class="align-right"><h3><a href="${DOMAIN}/role!editor.do">新建</a></h3></span>
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
	        			<div> 角色管理,提供权限系统 <strong>角色建立</strong> / <strong>修改</strong> / <strong>删除</strong> / <strong>锁定</strong>的管理功能.</div>
	      			</div>
      			</#if>
      			<table>
        			<thead>
          				<tr>
            				<th>角色编号</th>
            				<th>角色名</th>
            				<th>角色备注</th>
            				<th>读写状态</th>
            				<th>锁定状态</th>
            				<th>基本操作</th>
          				</tr>
        			</thead>
        			<tbody>
        				<#if (roles?exists && roles?size > 0 )>
	        				<#list roles as role>
		          				<tr>
			                		<td># ${role.roleId}</td>
			                		<td>${role.roleName?xml}</td>
			                		<td>${role.remark?xml}</td>
			                		<td><#if role.readOnly >只读	<#else>读写</#if></td>
			                		<td><#if role.locked >锁定<#else>未锁定</#if></td>
			                		<td>
			                  			<a href="${DOMAIN}/role!editor.do?roleId=${role.roleId}" title="编辑">编辑</a> | 
			                  			<a href="${DOMAIN}/role!remove.do?roleId=${role.roleId}" title="删除">删除</a> | 
										<#if role.locked >
											<a href="javascript:;" onclick="confirmPrompt('您确定解锁(${role.remark?xml})角色?','${DOMAIN}/role!unlock.do?roleId=${role.roleId}')">解锁</a> |
										<#else>
											<a href="javascript:;" onclick="confirmPrompt('您确定锁定(${role.remark?xml})角色?','${DOMAIN}/role!lock.do?roleId=${role.roleId}')">锁定</a> | 
										</#if>
			                  			<a href="${DOMAIN}/rolePopedom.do?roleId=${role.roleId}" title="角色权限编辑">角色权限编辑</a> 
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
</@voc.html>
