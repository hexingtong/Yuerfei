<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<%--<% String path = request.getContextPath(); %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>管理人员</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script src="${ctx }/js/paging.js" type="text/javascript" charset="utf-8"></script>
    <style>

    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
            <div class="indexcontent-right8" style="display: block;">
        <div class="indexcontent-right-main">
            <%@ include file="top.jsp" %>
            <div class="indexcontent-right-bottom" style="height: 875px;">
                <div class="indexcontent-right-bottom-main">
                    <div class="indexcontent-right-bottom-main-header">
                        <div class="indexcontent-header-title">管理人员列表</div>
                        <div class="indexcontent-header-search">
                            <input placeholder="请输入搜索关键词" name="placeholder2">
                            <div class="search-img">
                                <img src="${ctx }/images/SEARCH.svg" id="button">
                            </div>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom-main-content">
                        <div class="refresh" style="align-items: center">
                            <div class="managementAdd" style=" width:90%;margin:0 auto;height:50px;background:#EFF3FA;color:#2290FF;" id="add">
                                <img src="${ctx }/images/十字.png">
                                <div>新增</div>
                            </div>
                        </div>
                        <div class="management-tab">
                            <div class="management-thead">
                                <ul>
                                    <li>管理员头像</li>
                                    <li>姓名</li>
                                    <li>账号</li>
                                    <li>管理员权限</li>
                                    <li>添加时间</li>
                                    <li>最后一次登录IP</li>
                                    <li>最后一次登录时间</li>
                                    <li>操作</li>
                                </ul>
                            </div>
                            <div class="management-tbody1">
                                <%--<div class="management-tbody-item">--%>

                                <%--</div>--%>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
            <script>


                //调到新增
                $("#add").click(function () {
                    $(location).attr('href', '<%=basePath %>/Manage/toAdd')
                });

                function TagUpadete(id,name) {
                    window.location.href="<%=basePath %>Manage/toEdit?id="+id;
                  //  $(location).attr('href', '<%=basePath %>/Manage/toEdit?id='+id+'')
                }
                // function Up() {
                //     windows.location.person.reload();
                // }
                //
                //删除会员
                function Tagdelect(id){
                    //询问框
                    layer.confirm('是否删除', {
                        btn: ['是','否'] //按钮
                    }, function(){
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"${ctx }/GoodsAttribute/delete",
                            data:{id:id},
                            success:function(result){

                                if(result==1){
                                    layer.msg('删除成功', {icon: 1,time: 5000});
                                    window.location.reload();
                                }
                                if(resul==0){
                                    layer.msg('删除失败')
                                }
                            },error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }
                            }
                        })
                    }, function(){

                    });
                }
                $(document).ready(function(){

                    var total2=0;
                    //数据框的值
                    var sousuo2="";
                    //
                    var imgd2="http://47.92.53.177:8080/Yuerfei/"
                    var imgd='<%=basePath %>';
                    //点击按钮
                    $('#button').click(function(){
                        sousuo2=$("input[name='placeholder2']").val();
                        alert("获取搜索的值"+sousuo2)
                        $(".management-tbody1").empty();
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"<%=basePath %>/Manage/getManageList",
                            data:{pageNo:1,pageSize:7,phone:sousuo2},
                            success: function(result){

                                total2=result.total;
                                var  I=result.rows.length;
                                var o = $(".management-tbody1");
                                if (result.length!==0) {
                                    for(var G=0;G<I;G++){
                                        var D ='<div class="management-tbody-item">'+
                                            '<ul class="ul">' +
                                            '<li><img src="'+imgd+result.rows[G].img+'"/></li>'+
                                            '<li>'+result.rows[G].title+'</li>' +
                                            '<li>'+result.rows[G].phone+'</li>'+
                                            '<li>'+result.rows[G].roleName+'</li>'+
                                            '<li>'+result.rows[G].addTime+'</li>'+
                                            '<li>'+result.rows[G].loginIp+'</li>'+
                                            '<li>'+result.rows[G].loginTime+'</li>'+
                                            '<li>'
                                            +'<div class="managementEditor"  onclick="TagUpadete(this.id,this.name)"  id="'+result.rows[G].id+'">编辑</div>' +
                                            '</li>'+
                                            '</ul>'+
                                            '</div>';
                                        var K=$(D);
                                        biaoshi=false;
                                        o.append(K);

                                    }
                                }
                                $(".management-tbody1").paging(options)
                            },
                            error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }
                            }
                        });
                        //ajax结束


                    })

                    var options = {
                        list:".ul",//列表标识
                        currentPage:1,//初始页（选传，默认1）
                        pageSize:5,//每页列表数
                        //listTotal:5,//列表总数（选传），不传为list总数
                        callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换

                            loadData2(ajaxDemo2(currentPage))
                        }
                    }

                    //点击进入会员管理刷新页面
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/Manage/getManageList",
                        data:{pageNo:1,pageSize:7},
                        success: function(result){
                            total2=result.total;
                            var  I=result.rows.length;
                            var o = $(".management-tbody1");
                            if (result.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="management-tbody-item">'+
                                        '<ul class="ul">' +
                                        '<li><img src="'+imgd+result.rows[G].img+'"/></li>'+
                                        '<li>'+result.rows[G].title+'</li>' +
                                        '<li>'+result.rows[G].phone+'</li>'+
                                        '<li>'+result.rows[G].roleName+'</li>'+
                                        '<li>'+result.rows[G].addTime+'</li>'+
                                        '<li>'+result.rows[G].loginIp+'</li>'+
                                        '<li>'+result.rows[G].loginTime+'</li>'+
                                        '<li>'
                                        +'<div class="managementEditor"  onclick="TagUpadete(this.id,this.name)"  id="'+result.rows[G].id+'">编辑</div>' +
                                        '</li>'+
                                        '</ul>'+
                                        '</div>';
                                    var K=$(D);
                                    biaoshi=false;
                                    o.append(K);

                                }
                            }
                            $(".management-tbody1").paging(options)
                        },
                        error:function(XMLhttpServlet){
                            if (XMLhttpServlet.status==401){
                                $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                            }
                        }
                    });
                    //ajax结束


                    //会员得到数据
                    function ajaxDemo2(page,pageSize){
                        if(!pageSize)var pageSize = 7;
                            //搜索有值的时候
                            $.post('<%=basePath %>/Manage/getManageList',{pageNo:page,pageSize:pageSize},function(data){
                                loadData2(data);
                            })



                    }
                    //会员拼接数据
                    function loadData2(data){
                        console.log("callback")
                        $(".management-tbody1").empty();
                        var I=data.rows.length;
                        var o = $(".management-tbody1");
                        if (data.length!==0) {
                            for(var G=0;G<I;G++){
                                var D ='<div class="management-tbody-item">'+
                                    '<ul class="ul">' +
                                    '<li><img src="'+imgd+data.rows[G].img+'"/></li>'+
                                    '<li>'+data.rows[G].title+'</li>' +
                                    '<li>'+data.rows[G].phone+'</li>'+
                                    '<li>'+data.rows[G].roleName+'</li>'+
                                    '<li>'+data.rows[G].addTime+'</li>'+
                                    '<li>'+data.rows[G].loginIp+'</li>'+
                                    '<li>'+data.rows[G].loginTime+'</li>'+
                                    '<li>'
                                    +'<div class="managementEditor"  onclick="TagUpadete(this.id,this.name)"  id="'+data.rows[G].id+'">编辑</div>' +
                                    '</li>'+
                                    '</ul>'+
                                    '</div>';
                                var K=$(D);
                                biaoshi=false;
                                o.append(K);
                            }
                        }
                    }
                });


            </script>
</body>
</html>