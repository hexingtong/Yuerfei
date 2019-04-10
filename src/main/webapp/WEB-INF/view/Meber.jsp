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
    <title>会员管理</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script src="${ctx }/js/paging.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--会员管理右边-->
<div class="indexcontent-right1">
    <div class="indexcontent-right-main">
        <%@ include file="top.jsp" %>






        <div class="indexcontent-right-bottom">
            <div class="indexcontent-right-bottom-main">
                <div class="indexcontent-right-bottom-main-header">
                    <div class="indexcontent-header-title">会员管理列表</div>
                    <div class="indexcontent-header-search">
                        <input placeholder="请输入搜索关键词" name="placeholder2"/>
                        <div class="search-img">
                            <img src="${ctx }/images/SEARCH.svg" id="button"/>
                        </div>
                    </div>
                </div>


                <div class="indexcontent-right-bottom-main-content">
                    <div class="refresh">
                        <div style="border:1px solid  rgb(239,242,250);color:#fff;background:#2290FF;" onclick="location.reload()" >刷新</div>
                    </div>
                    <div class="indexcontent-tab">
                        <div class="indexcontent-thead">
                            <ul>
                                <li>唯一ID</li>
                                <li>会员账号</li>
                                <li>注册来源</li>
                                <li>注册账号</li>
                                <li>最后登录时间</li>
                                <li>最后登录IP</li>
                                <li>操作</li>
                            </ul>
                        </div>
                        <div class="indexcontent-tbody">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

            <script>

                function TagUpadete(id) {
                    $(location).attr('href', '<%=basePath %>/Member/toEdit?id='+id+'')
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
                            url:"${ctx }/Member/deleteAdmin",
                            data:{id:id},
                            success:function(result){

                                if(result.code==1){
                                    layer.msg('删除成功', {icon: 1,time: 5000});
                                    window.location.reload();
                                }
                                if(result.code==0){
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

                    //点击按钮
                    $('#button').click(function(){
                        sousuo2=$("input[name='placeholder2']").val();
                        $(".indexcontent-tbody").empty();
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"<%=basePath %>/Member/getList",
                            data:{pageNo:1,pageSize:7,phone:sousuo2},
                            success: function(result){
                                total2=result.total;
                                var  I=result.rows.length;
                                var o = $(".indexcontent-tbody");
                                if (result.length!==0) {
                                    for(var G=0;G<I;G++){
                                        var D ='<div class="indexcontent-tbody-item">'+
                                            '<ul class="ul">' +
                                            '<li>'+result.rows[G].id+'</li>'+
                                            '<li>'+result.rows[G].adminPhone+'</li>' +
                                            '<li>'+result.rows[G].registeredSource+'</li>'+
                                            '<li>'+result.rows[G].addTime+'</li>'+
                                            '<li>'+result.rows[G].loginTime+'</li>'+
                                            '<li>'+result.rows[G].loginIp+'</li>'+
                                            '<li>'+
                                            '<div class="set">'
                                            +'<div class="indexcontentEditors"  onclick="TagUpadete(this.id)"  id="'+result.rows[G].id+'">编辑</div>' +
                                            '<div onclick="Tagdelect(this.id)" id="'+result.rows[G].id+'">删除</div>' +
                                            '</div>'+
                                            '</li>'+
                                            '</ul>'+
                                            '</div>';
                                        var K=$(D);
                                        biaoshi=false;
                                        o.append(K);

                                    }
                                }
                                $(".indexcontent-tbody").paging(options)
                            },
                            error:function(XMLhttpServlet){
                                if (XMLhttpServlet.status==401){
                                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                                }
                            }
                        });
                        //ajax结束


                    })



                //点击进入会员管理刷新页面
                $.ajax({
                    type:"post",
                    dateType:"json",
                    url:"<%=basePath %>/Member/getList",
                    data:{pageNo:1,pageSize:7},
                    success: function(result){


                        total2=result.total;
                        var  I=result.rows.length;
                        var o = $(".indexcontent-tbody");
                        if (result.length!==0) {
                            for(var G=0;G<I;G++){
                                var D ='<div class="indexcontent-tbody-item">'+
                                    '<ul class="ul">' +
                                    '<li>'+result.rows[G].id+'</li>'+
                                    '<li>'+result.rows[G].adminPhone+'</li>' +
                                    '<li>'+result.rows[G].registeredSource+'</li>'+
                                    '<li>'+result.rows[G].addTime+'</li>'+
                                    '<li>'+result.rows[G].loginTime+'</li>'+
                                    '<li>'+result.rows[G].loginIp+'</li>'+
                                    '<li>'+
                                    '<div class="set">'
                                    +'<div class="indexcontentEditors"  onclick="TagUpadete(this.id)"  id="'+result.rows[G].id+'">编辑</div>' +
                                    '<div onclick="Tagdelect(this.id)" id="'+result.rows[G].id+'">删除</div>' +
                                    '</div>'+
                                    '</li>'+
                                    '</ul>'+
                                    '</div>';
                                var K=$(D);
                                biaoshi=false;
                                o.append(K);

                            }
                        }
                        $(".indexcontent-tbody").paging(options)
                    },
                    error:function(XMLhttpServlet){
                        if (XMLhttpServlet.status==401){
                            $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                        }
                    }
                });
                //ajax结束
                var options = {
                    list:".ul",//列表标识
                    currentPage:1,//初始页（选传，默认1）
                    pageSize:5,//每页列表数
                    //listTotal:5,//列表总数（选传），不传为list总数
                    callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换

                        loadData2(ajaxDemo2(currentPage))
                    }
                }

                //会员得到数据
                function ajaxDemo2(page,pageSize){
                    if(!pageSize)var pageSize = 7;
                    if(sousuo2==""||sousuo2.valueOf("")){
                        //没有搜索的时候
                        $.post('<%=basePath %>/Member/getList',{pageNo:page,pageSize:pageSize,phone:sousuo2},function(data){
                            loadData2(data);
                        })

                    }else {
                        //搜索有值的时候
                        $.post('<%=basePath %>/Member/getList',{pageNo:page,pageSize:pageSize},function(data){
                            loadData2(data);
                        })

                    }

                }
                //会员拼接数据
                function loadData2(data){
                    console.log("callback")
                    $(".indexcontent-tbody").empty();
                    var I=data.rows.length;
                    var o = $(".indexcontent-tbody");
                    if (data.length!==0) {
                        for(var G=0;G<I;G++){
                            var D ='<div class="indexcontent-tbody-item">'+
                                '<ul class="ul">' +
                                '<li>'+data.rows[G].id+'</li>'+
                                '<li>'+data.rows[G].adminPhone+'</li>' +
                                '<li>'+data.rows[G].registeredSource+'</li>'+
                                '<li>'+data.rows[G].addTime+'</li>'+
                                '<li>'+data.rows[G].loginTime+'</li>'+
                                '<li>'+data.rows[G].loginIp+'</li>'+
                                '<li>'+
                                '<div class="set">'
                                +'<div class="indexcontentEditors"  onclick="TagUpadete(this.id)" id="'+data.rows[G].id+'">编辑</div>' +
                                '<div  onclick="Tagdelect(this.id)" id="'+data.rows[G].id+'">删除</div>' +
                                '</div>'+
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