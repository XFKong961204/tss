<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>

<div style="text-align: center;">
	<form id="saveUserInfoForm" class="easyui-form" method="post">
		<div style="margin-top: 70px;">
			<label for="tatle">标题:</label>
			<input class="easyui-textbox" type="text" name="tatle" data-options="required:true" />
		</div>
		<div style="margin-top: 70px;">
	        <label for="tatle">标题:</label>
	        <input class="easyui-textbox" type="text" name="tatle" data-options="required:true" />
	    </div>   
	    <div style="margin-top: 10px;">   
	        <label for="cdesc">描述:</label>
	        <input class="easyui-textbox" type="text" name="cdesc" data-options="required:true,min:1,max:140" />
	    </div>  
	     <div style="margin-top: 10px;">   
	        <label for="imgPath">路径:</label>
	        <input class="easyui-textbox" type="text" name="imgPath" data-options="required:true" />
	    </div>
		<div style="margin-top: 10px;">
			<label for="status">状态:</label>
			<input class="easyui-textbox" type="text" name="status" data-options="required:true" />
		</div>
		<div style="margin-top: 10px;">
			<label for="crateTime">时间:</label>
			<input class="easyui-datebox" type="text" name="crateTime" data-options="required:true" />
		</div>
	</form>  
</div>

