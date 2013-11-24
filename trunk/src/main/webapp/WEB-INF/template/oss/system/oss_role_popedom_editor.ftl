<@voc.html title="角色权限对应关系编辑" >
	
	<#-- 角色权限对应关系浏览 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>角色权限对应关系浏览</h3>
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
        				<#if role??>
	          				<tr>
		                		<td># ${role.roleId}</td>
		                		<td>${role.roleName?xml}</td>
		                		<td>${role.remark?xml}</td>
		                		<td><#if role.readOnly >只读	<#else>读写</#if></td>
		                		<td><#if role.locked >锁定<#else>未锁定</#if></td>
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
			<div> <strong>角色权限</strong>管理,为该角色分配权限,每个模块下可以多选,最后一起提交管理.</div>
		</div>
	</#if>
	
	<#-- 所有的URL分为两列,每一个组分为一个box-->
	<form action="${DOMAIN}/rolePopedom.do" method="post">
		<fieldset>
			<#list groupList as group>
				<#-- 角色权限对应关系编辑 -->
				<div class="content-box <#if group_index % 2 == 0>column-left<#else>column-right</#if>">
					<div class="content-box-header">
						<h3>${group.groupName}</h3>
					</div>
					<div class="content-box-content">
			    		<div class="tab-content default-tab">
							<table>
			        			<thead>
			          				<tr>
				        				<th><input class="check-all" type="checkbox"></th>
			            				<th>${group.groupName}</th>
			          				</tr>
			        			</thead>
			        			<tbody>
									<#list popedomMap['${group.groupId}'] as popedom>
										<tr>
											<td>
												<input name="popedomId${group.groupId}" type="checkbox" value="${popedom.popedomId}" <#if rolePopedomMap['${ popedom.popedomId }']?exists >checked="true"</#if>/>
											</td>
						                	<td>${popedom.popedomName?xml}</td>
						                </tr>
						            </#list>
				            	</tbody>
			        			<tfoot></tfoot>
							</table>
						</div>
					</div>
				</div>
				<#if group_index % 2 != 0>
					<div class="clear"></div>
				</#if>
			</#list>
			<div class="clear"></div>
			<p>
				<#-- 隐藏 -->
				<input type="hidden" name="roleId" value="<#if role?exists>${role.roleId}<#else>0</#if>" />
				<input type="hidden" name="token" value="<#if token?exists>${token?xml}</#if>" />
				<input class="button" type="submit" value="继续" />
				<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/role.do'"/>
			</p>
		</fieldset>
	</form>
	
	
	
		
</@voc.html>
