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
    <title>标签展示</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <style>
        /*翻页*/
        .pagenation {
            padding: 40px 30px 60px 0;
            color: #666;
            -webkit-touch-callout:none;
            -webkit-user-select:none;
            -khtml-user-select:none;
            -moz-user-select:none;
            -ms-user-select:none;
            user-select:none;}

        .pagenation .pagenum {
            float: left;
            min-width: 30px;
            padding: 3px 5px;
            text-align: center;
            margin-right: 5px;
            cursor: pointer;
            font-size: 14px;
            border-radius: 3px;
            background: #f5f5f5;
            border: 1px solid #ddd;
            box-sizing: border-box;
        }

        .pagenation .pagenum.indexpage, .pagenation .pagenum.lastpage, .pagenation .pagenum.nextpage {
            background: rgba(255,255,255,0);
            color: #d9cfce;
        }

        .pagenation .pagenum.indexpage.active, .pagenation .pagenum.lastpage.active, .pagenation .pagenum.nextpage.active {
            background-color: #f5f5f5;
            color: #999;
        }

        .pagenation .pagenum.indexpage.active a, .pagenation .pagenum.lastpage.active a, .pagenation .pagenum.nextpage.active a {
            color: #999;
        }

        .pagenation .pagenum.pagetext, .pagenation .pagenum.totalpage {
            border-radius: 0px;
            background: rgba(255,255,255,0);
            border: none;
        }

        .pagenation .pagenum a {
            color: #999;
            text-decoration: none;
            display: block;
            width: 100%;
            height: 100%;
        }

        .pagenation .pageswiperbox {
            min-width: 35px;
            max-width: 175px;
            overflow: hidden;
            word-break: keep-all;
            white-space: nowrap;
            text-overflow: ellipsis;
            float: left;
        }

        .pagenation .pageswiper {
            width: auto;
        }

        .pagenation .pageswiper .pagenum {
            display: inline-block;
            float: none;
        }

        .pagenation .pagenum.curpage {
            background: rgba(255,255,255,0);
            color: #FE7200;
            border: none;
        }

        .pagenation .pagenum.curpage a {
            color: #FE7200;
            display: block;
            width: 100%;
        }

        .pagenation .pageinput {
            text-align: center;
            border: 1px solid #e5e5e5;
            width: 40px;
            margin: 0 3px;
            line-height: 17px;
            box-sizing: border-box;
            vertical-align: top;
        }

        .pagenation .pagesubbtn {
            background: rgba(255,255,255,0);
        }

        .pagenation .pagesubbtn a {
            color: #d9cfce;
        }

        .pagenation .pagesubbtn.active {
            background: #f5f5f5;
        }

        .pagenation .pagesubbtn a {
            color: #999;
        }
    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
<!--标签展示右边-->
            <div class="indexcontent-right4" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="${ctx }/images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="${ctx }/images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 875px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">标签展示列表</div>
                                <div class="indexcontent-header-search">
                                    <input class="sousuo" name="placeholder2" placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img src="${ctx }/images/SEARCH.svg" id="button">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh" style="display: flex;">
                                    <div class="label-editor" onclick="window.location.reload();" style="color:#fff;background:#2290FF;">刷新</div>
                                    <div class="label-add" onclick="addTag()" style="margin-left:-30px;color:#fff;background:#FF8D2F;">新增</div>
                                </div>
                                <div class="label-tab">
                                    <div class="label-thead">
                                        <ul>
                                            <li>标签名称</li>
                                            <li>添加时间</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="label-tbody">

                                    </div>

                                </div>
                                <div class="indexconten">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                //增加
                function addTag() {
                    $(location).attr('href', '<%=basePath %>/url/TagAdd')
                }
                //更新
                function TagUpadete(id) {
                    $(location).attr('href', '<%=basePath %>/url/TagEditor?id='+id+'')
                }
                //删除会员
                function Tagdelect(id){
                    //询问框
                    layer.confirm('是否删除', {
                        btn: ['是','否'] //按钮
                    }, function(){
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"${ctx }/Tag/TagDelete",
                            data:{id:id},
                            success:function(result){
                                var jsonData=JSON.parse(result);
                                if(jsonData.code=="200"){
                                    layer.msg('删除成功', {icon: 1,time: 5000});
                                    window.location.reload();
                                }else{
                                    layer.msg("删除失败")
                                }

                            },error:function(result){
                                layer.msg('错误');
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
                        $(".label-tbody").empty();
                        $.ajax({
                            type:"post",
                            dateType:"json",
                            url:"<%=basePath %>/Tag/MercjatTagList",
                            data:{pageNo:1,pageSize:7,title:sousuo2},
                            success: function(result){
                                var jsonData=JSON.parse(result);
                                total2=jsonData.items[0].total;
                                var  I=jsonData.items[0].rows.length;
                                var o = $(".label-tbody");
                                if (jsonData.length!==0) {
                                    for(var G=0;G<I;G++){
                                        var D ='<div class="label-tbody-item">' +
                                            ' <ul class="ul">' +
                                            '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                            '<li>'+jsonData.items[0].rows[G].addTime+'</li>' +
                                            '<li>'+
                                            '<div class="set">'
                                            +'<div class="labelEditor"  onclick="TagUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                            '<div class="laveidelete" onclick="Tagdelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                            '</div>'+
                                            '</li>'+
                                            '</ul>' +
                                            '</div>';
                                        var K=$(D);
                                        o.append(K);

                                    }
                                }
                                $(".label-tbody").paging(options)
                            },
                            error:function(){
                                alert("错误")
                            }
                        });
                        //ajax结束


                    })



                    //点击进入会员管理刷新页面
                    $.ajax({
                        type:"post",
                        dateType:"json",
                        url:"<%=basePath %>/Tag/MercjatTagList",
                        data:{pageNo:1,pageSize:7},
                        success: function(result){
                            var jsonData=JSON.parse(result);
                            total2=jsonData.items[0].total;
                            var  I=jsonData.items[0].rows.length;
                            var o = $(".label-tbody");
                            if (jsonData.length!==0) {
                                for(var G=0;G<I;G++){
                                    var D ='<div class="label-tbody-item">'+
                                        ' <ul class="ul">' +
                                        '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                        '<li>'+jsonData.items[0].rows[G].addTime+'</li>' +
                                        '<li>'+
                                        '<div class="set">'
                                        +'<div class="labelEditor"  onclick="TagUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                        '<div class="laveidelete" onclick="Tagdelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                        '</div>'+
                                        '</li>'+
                                        '</ul>' +
                                        '</div>';
                                    var K=$(D);
                                    o.append(K);

                                }
                            }
                            $(".label-tbody").paging(options)
                        },
                        error:function(){
                            alert("错误")
                        }
                    });
                    //ajax结束
                    var options = {
                        list:".ul",//列表标识
                        currentPage:1,//初始页（选传，默认1）
                        pageSize:5,//每页列表数
                        // listTotal:5,//列表总数（选传），不传为list总数
                        callback:function(currentPage){//翻页回调（可填，可做ajax请求）,不传为纯html切换
                            loadData2(ajaxDemo2(currentPage))
                        }
                    }

                    //会员得到数据
                    function ajaxDemo2(page,pageSize){
                        if(!pageSize)var pageSize = 7;
                        if(sousuo2==""||sousuo2.valueOf("")){
                            //没有搜索的时候
                            $.post('<%=basePath %>/Tag/MercjatTagList',{pageNo:page,pageSize:pageSize,title:sousuo2},function(data){
                                loadData2(data);
                            })

                        }else {
                            //搜索有值的时候
                            $.post('<%=basePath %>/Tag/MercjatTagList',{pageNo:page,pageSize:pageSize},function(data){
                                loadData2(data);
                            })

                        }

                    }
                    //会员拼接数据
                    function loadData2(data){
                        $(".label-tbody").empty();
                        var jsonData=JSON.parse(data);
                        var I=jsonData.items[0].rows.length;
                        var o = $(".label-tbody");
                        if (jsonData.length!==0) {
                            for(var G=0;G<I;G++){
                                var D ='<div class="label-tbody-item">' +
                                    ' <ul class="ul">' +
                                    '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                    '<li>'+jsonData.items[0].rows[G].addTime+'</li>' +
                                    '<li>'+
                                    '<div class="set">'
                                    +'<div class="labelEditor"  onclick="TagUpadete(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                    '<div class="laveidelete" onclick="Tagdelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                    '</div>'+
                                    '</li>'+
                                    '</ul>' +
                                    '</div>';
                                var K=$(D);
                                o.append(K);

                            }
                        }
                    }
                });
            </script>


</body>
</html>