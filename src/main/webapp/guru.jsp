<script type="text/javascript">
    $(function(){
        $('#dg').edatagrid({
            url:'${pageContext.request.contextPath}/guru/findAll',
            updateUrl:'${pageContext.request.contextPath}/guru/updateGuru',
            columns:[[
                {field:'guru_id',title:'ID',width:250},
                {field:'name',title:'上师名称',width:250},
                {field:'profile',title:'头像路径',width:250},
                {field:'sex',title:'性别',width:250},
                {field:'state',title:'状态',width:250,editor:{type:"validatebox"}}
            ]],

            fit:true,
            toolbar: [{
                iconCls: 'icon-add',
                text:'添加',
                handler: function(){
                    $('#dd').dialog({
                        title: '添加上师',
                        width: 400,
                        height: 200,
                        closed: false,
                        cache: false,
                        modal: true,

                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                text:'修改',
                handler: function(){
                    var selected = $("#dg").edatagrid('getSelected');
                    if(selected == null){
                        alert("请选中上师");
                    }else{
                        $("#modifyForm").form('load',{
                            carousel_id:selected.guru_id,
                            title:selected.name,
                            cdesc:selected.profile,
                            status:selected.sex,
                        });
                        $('#modifyDiv').dialog({
                            title: '修改上师',
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
                    var selected = $("#dg").edatagrid('getSelected');
                    alert(selected.guru_id)
                    if(selected == null){
                        alert("请选中轮播图");
                    }else{
                        $.ajax({
                            url:'${pageContext.request.contextPath}/guru/deleteGuru',
                            data:'guru_id='+selected.guru_id,
                            success:function(){
                                $("#dg").edatagrid('reload');
                            }
                        });
                    }
                }
            }],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/uploadGuru/'+rowData.profile + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>上师姓名: ' + rowData.name + '</p>' +
                    '<p>上师性别: ' + rowData.sex + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });
        $("#addForm").form({
            url:"${pageContext.request.contextPath}/guru/addGuru",
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            },
            success:function(){

                $("#dd").dialog('close');
                $("#dg").edatagrid('reload');
            }
        });
        $("#modifyForm").form({
            url:'${pageContext.request.contextPath}/guru/updateGuru',
            onSubmit: function(){
                // do some check
                // return false to prevent submit;
            },
            success:function(result){
                var result = $.parseJSON(result);
                $.message.show({title:"提示",msg:result.message});
                $("#modifyDiv").dialog('close');
                $("#dg").edatagrid('reload');
            }
        });
    });
</script>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table id="dg"></table>
<div id="dd">
	<form id="addForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>上师名称:</td>
				<td><input name="name" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>

			<tr>
				<td>性别:</td>
				<td>
					<input name="sex" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">
				</td>
			</tr>
			<tr>
				<td>状态:</td>
				<td>
					<input name="state" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px">
				</td>
			</tr>

			<tr>
				<td>头像上传:</td>
				<td><input class="easyui-filebox" style="width:300px" name="addFile"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>
<div id="modifyDiv">
	<form id="modifyForm" method="post" enctype="multipart/form-data">
		<table>

			<tr>
				<td>上师名称:</td>
				<td><input name="name" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>性别:</td>
				<td><input name="sex" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>状态:</td>
				<td><input name="state" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>


		</table>
	</form>
</div>