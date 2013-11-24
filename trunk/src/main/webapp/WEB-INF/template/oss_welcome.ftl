<@voc.html title="欢迎页面" >
	<#if OSS_CONTEXT??>
	<ul class="shortcut-buttons-set">
		<li>
 			<a class="shortcut-button" href="#">
  				<span> 
      				<img src="${IMG_BASE_URL}/icons/pencil_48.png" alt="icon" />
      				<br />
       	 			写下 
   	 			</span>
  	 		</a>
  		</li>
  
	    <li>
			<a class="shortcut-button" href="#">
				<span> 
					<img src="${IMG_BASE_URL}/icons/paper_content_pencil_48.png" alt="icon" />
					<br />
		        	新建
		        </span>
	        </a>
	    </li>
 
 		<li>
	      	<a class="shortcut-button" href="#">
	      		<span> 
	      			<img src="${IMG_BASE_URL}/icons/image_add_48.png" alt="icon" />
	      			<br />
	        		下载图片 
	        	</span>
	        </a>
 		</li>
 
		<li>
 			<a class="shortcut-button" href="#" >
 				<span> 
      				<img src="${IMG_BASE_URL}/icons/clock_48.png" alt="icon" />
      				<br />
        			添加事件
   				</span>
   			</a>
 		</li>
 
		<li>
			<a class="shortcut-button" href="#messages" rel="modal">
 				<span> 
 					<img src="${IMG_BASE_URL}/icons/comment_48.png" alt="icon" />
 					<br />
   					打开模板 
   				</span>
   			</a>
 		</li>
	</ul>
	<div class="clear"></div>  
	</#if> 
</@voc.html>
