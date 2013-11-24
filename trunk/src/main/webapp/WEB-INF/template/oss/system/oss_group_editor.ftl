<@voc.html title="群组编辑" >
	
	<#-- 群组编辑 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>群组编辑</h3>
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
    			<form action="${DOMAIN}/group!editor.do" method="post">
    				<fieldset>
    					<p>
							<label>分组名</label>
							<input type="text" id="groupName" class="text-input small-input" name="groupName" value="<#if groupName?exists>${groupName?xml}<#elseif group?exists>${group.groupName?xml}</#if>" />
						</p>
    					<p>
							<label>显示状态</label>
							<select class="small-input" name="hide">
								<#if (hide?exists && hide == 1) || (group?exists && group.hide) >
									<option value="1" selected="selected">隐藏</option>
									<option value="0" >显示</option>
								<#else>
									<option value="1" >隐藏</option>
									<option value="0" selected="selected">显示</option>
								</#if>
							</select>
						</p>
    					<p>
							<label>备注信息</label>
							<textarea id="remark" name="remark" rows="2" style="width:100%;"><#if remark?exists>${remark?xml}<#elseif group?exists>${group.remark?xml}</#if></textarea>
						</p>
						<p>
							<#-- 隐藏 -->
							<input type="hidden" id="groupId" name="groupId" value="<#if group?exists>${group.groupId}<#else>0</#if>" />
							<input type="hidden" id="token" name="token" value="<#if token?exists>${token?xml}</#if>" />
							<input class="button" type="submit" value="继续" />
							<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/group.do'"/>
						</p>
    				</fieldset>
    			</from>
			</div>
		</div>
	</div>
	
	<#if group?exists >
		<div class="content-box">
			<div class="content-box-header">
				<h3>群组预览</h3>
			</div>
			<div class="content-box-content">
	    		<div class="tab-content default-tab">
	      			<table>
	        			<thead>
	          				<tr>
	            				<th>分组编号</th>
	            				<th>分组名</th>
	            				<th>显示状态</th>
	            				<th>读写状态</th>
	            				<th>备注信息</th>
	          				</tr>
	        			</thead>
	        			<tbody>
	          				<tr>
		                		<td># ${group.groupId}</td>
		                		<td>${group.groupName?xml}</td>
		                		<td><#if group.hide >隐藏<#else>显示</#if></td>
		                		<td><#if group.readOnly >只读	<#else>读写</#if></td>
		                		<td>${group.remark?xml}</td>
		              		</tr>
		            	</tbody>
	        			<tfoot></tfoot>
					</table>
				</div>
			</div>
		</div>
	</#if>
</@voc.html>
