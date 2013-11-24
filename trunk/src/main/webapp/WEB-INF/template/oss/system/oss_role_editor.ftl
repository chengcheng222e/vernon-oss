<@voc.html title="角色编辑" >
	
	<#-- 角色编辑 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>角色编辑</h3>
		</div>
		<div class="content-box-content">
    		<div class="tab-content default-tab">
    			<#if ERROR_MESSAGE??>
	    			<div class="notification error png_bg"> 
	      				<a href="javascript:;" class="close">
	      					<img src="${IMG_BASE_URL}/icons/cross_grey_small.png" title="消息提醒" alt="关闭" />
	      				</a>
	        			<div>${ERROR_MESSAGE}</div>
	      			</div>
      			</#if>
    			<form action="${DOMAIN}/role!editor.do" method="post">
    				<fieldset>
    					<p>
							<label>角色名</label>
							<input class="text-input small-input" type="text" name="roleName" value="<#if roleName?exists>${roleName?xml}<#elseif role?exists>${role.roleName?xml}</#if>">
						</p>
    					<p>
							<label>锁定状态</label>
							<select class="small-input" name="locked">
								<#if (locked?exists && locked == 1) || (role?exists && role.locked) >
									<option value="1" selected="selected">锁定</option>
									<option value="0" >未锁定</option>
								<#else>
									<option value="1" >锁定</option>
									<option value="0" selected="selected">未锁定</option>
								</#if>
							</select>
						</p>
    					<p>
							<label>备注</label>
							<textarea name="remark" style="width:50%;"><#if remark?exists>${remark?xml}<#elseif role?exists>${role.remark?xml}</#if></textarea>
						</p>
						<p>
							<#-- 隐藏 -->
							<input type="hidden" name="roleId" value="<#if role?exists>${role.roleId}<#else>0</#if>" />
							<input type="hidden" name="token" value="<#if token?exists>${token?xml}</#if>" />
							<input class="button" type="submit" value="继续" />
							<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/role.do'"/>
						</p>
    				</fieldset>
    			</from>
			</div>
		</div>
	</div>
	
	<#if role?exists>
		<div class="content-box">
			<div class="content-box-header">
				<h3>用户角色预览</h3>
			</div>
			<div class="content-box-content">
	    		<div class="tab-content default-tab">
	      			<table>
	        			<thead>
	          				<tr>
	            				<th>角色编号</th>
	            				<th>角色名</th>
	            				<th>角色备注</th>
	            				<th>读写状态</th>
	            				<th>锁定状态</th>
	          				</tr>
	        			</thead>
	        			<tbody>
	          				<tr>
		                		<td># ${role.roleId}</td>
		                		<td>${role.roleName?xml}</td>
		                		<td>${role.remark?xml}</td>
		                		<td><#if role.readOnly >只读	<#else>读写</#if></td>
		                		<td><#if role.locked >锁定<#else>未锁定</#if></td>
		              		</tr>
		            	</tbody>
	        			<tfoot></tfoot>
					</table>
				</div>
			</div>
		</div>
	</#if>
</@voc.html>
