<@voc.html title="群组编辑" >
	
	<#-- 用户编辑 -->
	<div class="content-box">
		<div class="content-box-header">
			<h3>用户编辑</h3>
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
    			<form action="${DOMAIN}/user!editor.do" method="post">
    				<fieldset>
    					<p>
							<label>邮件地址</label>
							<input type="text" id="email" class="text-input small-input" name="email" value="<#if email?exists>${email?xml}<#elseif user?exists>${user.email?xml}</#if>" />
						</p>
    					<p>
							<label>真实姓名</label>
							<input type="text" id="realName" name="realName" class="text-input small-input" value="<#if realName?exists>${realName?xml}<#elseif user?exists>${user.realName?xml}</#if>"  />
						</p>
    					<p>
							<label>锁定状态</label>
							<select class="small-input" name="locked">
								<#if (locked?exists && locked == 1) || (user?exists && user.locked) >
									<option value="1" selected="selected">锁定</option>
									<option value="0" >未锁定</option>
								<#else>
									<option value="1" >锁定</option>
									<option value="0" selected="selected">未锁定</option>
								</#if>
							</select>
						</p>
    					<p>
							<label>备注信息</label>
							<textarea id="remark" name="remark" rows="2" style="width:100%;"><#if remark?exists>${remark?xml}<#elseif user?exists>${user.remark?xml}</#if></textarea>
						</p>
						<p>
							<#-- 隐藏 -->
							<input type="hidden" id="userId" name="userId" value="<#if user?exists>${user.userId}<#else>0</#if>" />
							<input type="hidden" name="token" value="<#if token?exists>${token?xml}</#if>" />
							<input class="button" type="submit" value="继续" />
							<input class="button" type="button" value="返回" onClick="window.location='${DOMAIN}/user.do'"/>
						</p>
    				</fieldset>
    			</from>
			</div>
		</div>
	</div>
	
	<#if user?exists>
		<div class="content-box">
			<div class="content-box-header">
				<h3>用户预览</h3>
			</div>
			<div class="content-box-content">
	    		<div class="tab-content default-tab">
	      			<table>
	        			<thead>
	          				<tr>
	            				<th>用户编号</th>
	            				<th>邮件地址</th>
	            				<th>真实姓名</th>
	            				<th>锁定状态</th>
	            				<th>只读状态</th>
	            				<th>备注信息</th>
	          				</tr>
	        			</thead>
	        			<tbody>
	          				<tr>
		                		<td># ${user.userId}</td>
		                		<td>${user.email?xml}</td>
		                		<td>${user.realName?xml}</td>
		                		<td><#if user.locked >锁定<#else>未锁定</#if></td>
		                		<td><#if user.readOnly >只读	<#else>读写</#if></td>
		                		<td>${user.remark?xml}</td>
		              		</tr>
		            	</tbody>
	        			<tfoot></tfoot>
					</table>
				</div>
			</div>
		</div>
	</#if>
</@voc.html>
