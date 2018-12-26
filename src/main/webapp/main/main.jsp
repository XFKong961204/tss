<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
    <script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>

    <script type="text/javascript">
        $(function(){
            //发送ajax 请求用来获取数据库菜单
            $.post("${pageContext.request.contextPath}/menu/findMenu",function(result){
                //遍历一级菜单
                $.each(result,function(i,menu){
                    //遍历二级菜单
                    var content = "<div style='margin-top:5px;text-align:center;background:#eee;border-radius:10px;'>";
                    console.log(result);
                    $.each(menu.menus,function(j,child){
                        console.log(menus)
                        var json = JSON.stringify(child)
                        content += "<a onClick='addTabs("+json+");' class='easyui-linkbutton' data-options=\"iconcls:'"+child.iconCls+"',plain:true\" style='width:90%;border:1px #95B8E7 solid;'>"+child.title+"</a>";
                    });
                    content+="</div>";
                    //添加菜单
                    $("#menus").accordion('add',{
                        title:menu.title,
                        iconCls:menu.iconCls,
                        content:content,
                    });
                });
            },"JSON");

        });

        //点击菜单添加选项卡
        function addTabs(child){
            //添加前判断是否存在不存在添加
            if(!$("#tabs").tabs('exists',child.title)){
                //添加选项卡
                $("#tabs").tabs('add',{
                    title:child.title,
                    iconCls:child.iconCls,
                    closable:true,
                    href:"${pageContext.request.contextPath}"+child.href,
                    tools:[
                        {
                            iconCls:'icon-mini-refresh',
                            handler:function(){
                                //获取当前选中的选项卡
                                var tab = $("#tabs").tabs('getSelected');
                                console.log(tab);
                                //刷新面板数据表格
                                tab.find("table[class='datagrid-f']").datagrid('load');

                            }
                        }
                    ]
                });
            }else{//存在选中
                $("#tabs").tabs('select',child.title);
            }


        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login.realName} &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/logout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menus" class="easyui-accordion" data-options="fit:true">

    </div>
</div>
<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
</body>
</html>