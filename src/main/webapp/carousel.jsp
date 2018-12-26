<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function(){
		$('#cdg').datagrid({
		    url:'${pageContext.request.contextPath}/carousel/findAll',
		    columns:[[    
		        {field:'title',title:'轮播图名称',width:250},
		        {field:'status',title:'轮播图状态',width:250},    
		        {field:'imgPath',title:'路径',width:250},
		        {field:'cdesc',title:'轮播图详情',width:250}
		    ]],
		    fit:true,
		    toolbar: [{
				iconCls: 'icon-add',
				text:'添加',
				handler: function(){
					$('#cdd').dialog({
					    title: '添加轮播图',    
					    width: 400,    
					    height: 200,    
					    closed: false,    
					    cache: false,    
					    modal: true   
					}); 
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'修改',
				handler: function(){
					var selected = $("#cdg").datagrid('getSelected');
					if(selected == null){
						alert("请选中轮播图");
					}else{
						$("#cmodifyForm").form('load',{
							carousel_id:selected.carousel_id,
                            title:selected.title,
							cdesc:selected.cdesc,
							status:selected.status,
						});
						$('#cmodifyDiv').dialog({
						    title: '修改轮播图',    
						    width: 400,    
						    height: 200,
						    closed: false,
						    cache: false,    
						    modal: true   
						});
					}
				}
			},'-',{
				iconCls: 'icon-error',
				text:'删除',
				handler: function(){
					var selected = $("#cdg").datagrid('getSelected');
					alert(selected.carousel_id)
					if(selected == null){
						alert("请选中轮播图");
					}else{
						$.ajax({
							url:'${pageContext.request.contextPath}/carousel/deleteCarousel',
							data:'carousel_id='+selected.carousel_id,
							success:function(){
								$("#cdg").datagrid('reload');
							}
						});
					}
				}
			}],
			view: detailview, 
			detailFormatter: function(rowIndex, rowData){ 
				return '<table><tr>' + 
				'<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/'+rowData.imgPath + '" style="height:50px;"></td>' +
				'<td style="border:0">' + 
				'<p>轮播图简介: ' + rowData.cdesc + '</p>' +
				'<p>轮播图状态: ' + rowData.status + '</p>' + 
				'</td>' + 
				'</tr></table>'; 
				} 

		});
		$("#caddForm").form({
		    url:"${pageContext.request.contextPath}/carousel/addCarousel",
		    onSubmit: function(){
		        // do some check
		        // return false to prevent submit;
		    },
		    success:function(){
		        $("#cdd").dialog('close');
		        $("#cdg").datagrid('reload');
		    }
		});
		$("#cmodifyForm").form({
		    url:'${pageContext.request.contextPath}/carousel/modifyCarousel',
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(){    
		        $("#cmodifyDiv").dialog('close');
		        $("#cdg").datagrid('reload');
		    }    
		});
	});
</script>
<table id="cdg"></table>
<div id="cdd">
	<form id="caddForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>轮播图名称:</td>
				<td><input name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>轮播图描述:</td>
				<td><input name="cdesc" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>轮播图状态:</td>
				<td>
					<select id="aa" class="easyui-combobox" name="status" style="width:200px;">
					    <option value="on">正在展示</option>
					    <option value="off">已下架</option>
					</select>
				</td>
			</tr>

			<tr>
				<td>轮播图上传:</td>
				<td><input class="easyui-filebox" style="width:300px" name="addFile"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>
<div id="cmodifyDiv">
	<form id="cmodifyForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>轮播图ID:</td>
				<td><input name="carousel_id" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px" readonly> </td>
			</tr>
			<tr>
				<td>轮播图名称:</td>
				<td><input name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>轮播图描述:</td>
				<td><input name="cdesc" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>轮播图状态:</td>
				<td>
					<select id="cc" class="easyui-combobox" name="status" style="width:200px;">   
					    <option value="on">正在展示</option>   
					    <option value="off">已下架</option>  
					</select>  
				</td>
			</tr>
			<tr>
				<td>轮播图上传:</td>
				<td><input class="easyui-filebox" style="width:300px" name="addFile"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div> 