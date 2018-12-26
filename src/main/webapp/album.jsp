<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function(){
		$('#tree').treegrid({    
		    url:'${pageContext.request.contextPath}/album/findAll',
		    idField:'id',
		    treeField:'title',
		    columns:[[
		        {title:'名称',field:'title',width:250},
		        {title:'下载路径',field:'downPath',width:500},    
		        {title:'章节大小',field:'size',width:250},    
		        {title:'章节时长',field:'duration',width:250}    
		    ]],
		    toolbar: [{
				iconCls: 'icon-lock',
				text:'专辑详情',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');

					if(obj == null){
						alert("您未选中");
					}else if(obj.author == null){
						alert("请选择专辑");
					}else{

					    $("#detailCover").attr('src','${pageContext.request.contextPath}/uploadAlbum/'+obj.cover).attr('width','300px');
                        $("#detailTitle").empty();
                        $("#detailTitle").append('<font>'+obj.title+'<font>');
                        $("#detailCount").empty();
                        $("#detailCount").append('<font>'+obj.counts+'<font>');
                        $("#detailScore").empty();
                        $("#detailScore").append('<font>'+obj.score+'<font>');
                        $("#detailAuthor").empty();
                        $("#detailAuthor").append('<font>'+obj.author+'<font>');
                        $("#detailBroadcast").empty();
                        $("#detailBroadcast").append('<font>'+obj.broadcast+'<font>');
                        $("#detailBrief").empty();
                        $("#detailBrief").append('<font>'+obj.brief+'<font>');
                        $("#detailPublishTime").empty();
                        $("#detailPublishTime").append('<font>'+obj.publisDate+'<font>');
                        $('#detail').dialog({
						    title: '专辑详情',    
						    width: 600,    
						    height: 600,    
						    closed: false,
						    cache: false,
						    modal: true

						});

					}
				}
			},'-',{
				iconCls: 'icon-add',
				text:'添加专辑',
				handler: function(){
					$('#addAlbumDiv').dialog({    
					    title: '添加专辑',    
					    width: 600,    
					    height: 300,    
					    closed: false,    
					    cache: false,    
					    modal: true,
					}); 
				}
			},'-',{
				iconCls: 'icon-add',
				text:'添加章节',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');
					if(obj == null){
						alert("您未选中");
					}else if(obj.author == null){
						alert("请选择专辑");
					}else{
						$("#albumId").textbox('setValue',obj.id);
						$("#addChapterDiv").dialog({    
						    title: '添加章节',    
						    width: 600,    
						    height: 300,    
						    closed: false,    
						    cache: false,    
						    modal: true   
						});
					}
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'下载章节',
				handler: function(){
					var obj = $("#tree").treegrid('getSelected');
					alert(obj.title)
					if(obj == null){
						alert("您未选中");
					}else if(obj.author != null){
						alert("请选择章节");
					}else{
						//不能用ajax，用ajax不会报错，但是不会进入controller
						location.href='${pageContext.request.contextPath}/chapter/downloadChapter?title='+obj.title
					}
				}
			}],
			fit:true,

		});
		$('#addAlbumForm').form({    
		    url:'${pageContext.request.contextPath}/album/addAlbum',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(){    
		        $("#addAlbumDiv").dialog("close");
		        $("#tree").treegrid("reload");
		    }

		});
		$('#addChapterForm').form({    
		    url:'${pageContext.request.contextPath}/chapter/addChapter',    
		    onSubmit: function(){    
		        // do some check    
		        // return false to prevent submit;    
		    },    
		    success:function(){    
		        $("#addChapterDiv").dialog("close");
		        $("#tree").treegrid("reload");
		    }    
		});
	});
</script>
<table id="tree" style="width:600px;height:400px"></table>  
<div id="detail" align="center">
	<table>
		<tr>
			<td colspan="2"><img id="detailCover"/></td>
		</tr>
		<tr>
			<td>专辑名称：</td>
			<td><span id="detailTitle"></span></td>
		</tr>
		<tr>
			<td>章节数量：</td>
			<td><span id="detailCount"></span></td>
		</tr>
		<tr>
			<td>专辑得分：</td>
			<td><span id="detailScore"></span></td>
		</tr>
		<tr>
			<td>专辑作者：</td>
			<td><span id="detailAuthor"></span></td>
		</tr>
		<tr>
			<td>播音员：</td>
			<td><span id="detailBroadcast"></span></td>
		</tr>
		<tr>
			<td>专辑简介：</td>
			<td><span id="detailBrief"></span></td>
		</tr>
		<tr>
			<td>上架时间：</td>
			<td><span id="detailPublishTime"></span></td>
		</tr>
	</table>
</div> 
<div id="addAlbumDiv" align="center">
	<form id="addAlbumForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>专辑名称：</td>
				<td><input name="title" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑得分：</td>
				<td><input name="score" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑作者：</td>
				<td><input name="author" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>章节数量</td>
				<td><input name="counts" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>播音员：</td>
				<td><input name="broadcast" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>专辑简介：</td>
				<td><input name="brief" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>上架时间：</td>
				<!-- 后台接受到的是string类型，所以要么用string接受，要么在实体类配置注解 -->
				<td><input name="publisDate" id="dd"  type= "text" class= "easyui-datebox" editable="false"> </input>   </td>
			</tr>
			<tr>
				<td>专辑图片：</td>
				<td><input name="addFile" class="easyui-filebox" style="width:300px"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>
<div id="addChapterDiv" align="center">
	<form id="addChapterForm" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>专辑ID：</td>
				<td><input id="albumId" name="a_id" class="easyui-textbox" data-options="iconCls:'icon-search'" style="width:300px"> </td>
			</tr>
			<tr>
				<td>音频上传：</td>
				<td><input name="addFile" class="easyui-filebox" style="width:300px"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"/></td>
			</tr>
		</table>
	</form>
</div>    