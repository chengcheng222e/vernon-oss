<@voc.html title="群组管理" >
	
	<#-- 群组管理 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>群组管理</h3>
			<span class="align-right"><h3><a href="${DOMAIN}/group!editor.do">新建</a></h3></span>
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
	        			<div> 群组管理,提供 <strong>群组建立</strong> / <strong>修改</strong> / <strong>删除</strong> 的管理功能.</div>
	      			</div>
      			</#if>
      			<table>
        			<thead>
          				<tr>
            				<th>分组编号</th>
            				<th>分组名</th>
            				<th>分组备注</th>
            				<th>读写状态</th>
            				<th>显示状态</th>
            				<th>基本操作</th>
          				</tr>
        			</thead>
        			<tbody>
        				<#if (groups?exists && groups?size > 0 )>
	        				<#list groups as group>
		          				<tr>
			                		<td># ${group.groupId}</td>
			                		<td>${group.groupName?xml}</td>
			                		<td>${group.remark?xml}</td>
			                		<td><#if group.readOnly >只读<#else>读写</#if></td>
			                		<td><#if group.hide >隐藏<#else>显示</#if></td>
			                		<td>
			                  			<a href="${DOMAIN}/group!editor.do?groupId=${group.groupId}">编辑</a>|
										<a href="javascript:;" onclick="confirmPrompt('您确认删除 (${group.groupName?xml}) 分组?本次操作不可恢复.','${DOMAIN}/group!remove.do?groupId=${group.groupId}');">删除</a>
									</td>
			              		</tr>
	        				</#list>
        				<#else>
							<tr>
								<td colspan="7">
									&nbsp;你要查看的分组列表为空
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
