<@voc.html title="界面管理" >
	<#list ossGroups as group>
				<#-- 界面管理-->
				<div class="content-box">
					<div class="content-box-header">
						<h3>${group.groupName}</h3>
						<span class="align-right"><h3><a href="${DOMAIN}/popedom!editor.do?groupId=${group.groupId}">新建[${group.groupName}]入口</a></h3></span>
					</div>
					<div class="content-box-content">
			    		<div class="tab-content default-tab">
							<table>
			        			<thead>
			          				<tr>
			            				<th>权限编号</th>
										<th>权限名称</th>
										<th>授权地址</th>
										<th>读写状态</th>
										<th>锁定状态</th>
										<th>显示状态</th>
										<th>基本操作</th>
			          				</tr>
			        			</thead>
			        			<tbody>
									<#list popedomMap['${ group.groupId }'] as popedom>
										<tr>
											<td># ${popedom.popedomId}</td>
											<td>${popedom.popedomName?xml}</td>
											<td>${popedom.URI?xml}</td>
											<td><#if popedom.readOnly >只读<#else>读写</#if></td>
											<td><#if popedom.locked >锁定<#else>未锁定</#if></td>
											<td><#if popedom.hide >隐藏<#else>显示</#if></td>
											<td>
												<a href="${DOMAIN}/popedom!editor.do?popedomId=${popedom.popedomId}">编辑</a>|
												<a href="javascript:;" onclick="confirmPrompt('您确认删除(${popedom.popedomName?xml})权限?本次操作不可恢复!','${DOMAIN}/popedom!remove.do?popedomId=${popedom.popedomId}');">删除</a>|
												<#if popedom.locked >
													<a href="javascript:;" onclick="confirmPrompt('您确认解锁(${popedom.popedomName?xml})权限?','${DOMAIN}/popedom!unlock.do?popedomId=${popedom.popedomId}');">解锁</a>
												<#else>
													<a href="javascript:;" onclick="confirmPrompt('您确认锁定(${popedom.popedomName?xml})权限?','${DOMAIN}/popedom!lock.do?popedomId=${popedom.popedomId}');">锁定</a>
												</#if>
											</td>
										</tr>
						            </#list>
				            	</tbody>
			        			<tfoot></tfoot>
							</table>
						</div>
					</div>
				</div>
			</#list>
	
	
</@voc.html>
