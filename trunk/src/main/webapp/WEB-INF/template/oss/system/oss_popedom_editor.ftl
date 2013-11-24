<@voc.html title="权限编辑" >
	
	<#-- 权限编辑 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>权限编辑</h3>
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
    			<form action="${DOMAIN}/popedom!editor.do" method="post">
    				<fieldset>
    					<p>
							<label>权限名</label>
							<input class="text-input small-input" type="text" name="popedomName" value="<#if popedomName?exists>${popedomName?xml}<#elseif popedom?exists>${popedom.popedomName?xml}</#if>">
						</p>
    					<p>
							<label>所属分组</label>
							<select name="groupId" class="small-input">
								<#list groups as group>
									<#if (popedom?exists && group.groupId==popedom.groupId ) || (groupId?exists && group.groupId==groupId) >
										<option value="${group.groupId}" selected="selected" >${group.groupName?xml}</option>
									<#else>
										<option value="${group.groupId}">${group.groupName?xml}</option>
									</#if>
								</#list>
							</select>
						</p>
    					<p>
							<label>显示状态</label>
							<select name="hide" id="hide" class="small-input">
								<#if (hide?exists && hide == 1) || (popedom?exists && popedom.hide) >
									<option value="1" selected="selected">隐藏</option>
									<option value="0" >显示</option>
								<#else>
									<option value="1" >隐藏</option>
									<option value="0" selected="selected">显示</option>
								</#if>
							</select>
						</p>
    					<p>
							<label>锁定状态</label>
							<select name="locked" id="locked" class="small-input">
								<#if (locked?exists && locked == 1) || (popedom?exists && popedom.locked) >
									<option value="1" selected="selected">锁定</option>
									<option value="0" >未锁定</option>
								<#else>
									<option value="1" >锁定</option>
									<option value="0" selected="selected">未锁定</option>
								</#if>
							</select>
						</p>
    					<p>
							<label>授权地址</label>
							<textarea id="URI" name="URI" rows="2" style="width:100%;"><#if URI?exists>${URI?xml}<#elseif popedom?exists>${popedom.URI?xml}</#if></textarea>
						</p>
    					<p>
							<label>备注</label>
							<textarea id="remark" name="remark" rows="2" style="width:100%;"><#if remark?exists>${remark?xml}<#elseif popedom?exists>${popedom.remark!xml}</#if></textarea>
						</p>
						<p>
							<#-- 隐藏 -->
							<input type="hidden" id="popedomId" name="popedomId" value="<#if popedom?exists>${popedom.popedomId}<#else>0</#if>" />
							<input type="hidden" name="token" value="<#if token?exists>${token?xml}</#if>" />
							<input class="button" type="submit" value="继续" />
							<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/popedom.do'"/>
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
