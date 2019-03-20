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
    <title>商户展示</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <style>

    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
        <!--商户展示-->
        <div class="indexcontent-right5" style="display: block;">
            <div class="indexcontent-right-main">
                <%@ include file="top.jsp" %>
                <div class="indexcontent-right-bottom" style="height: 884px;">
                    <div class="indexcontent-right-bottom-main">
                        <div class="indexcontent-right-bottom-main-header">
                            <div class="indexcontent-header-title">商户展示列表</div>
                            <div class="indexcontent-header-search">
                                <input placeholder="请输入搜索关键词">
                                <div class="search-img">
                                    <img src="${ctx }/images/SEARCH.svg">
                                </div>
                            </div>
                        </div>
                        <div class="indexcontent-right-bottom-main-content">
                            <div class="refresh">
                                <div style="border:1px solid  rgb(239,242,250);color:#fff;background:#2290FF;" onclick="location.reload()" >刷新</div>
                                <div class="labelSelet" style="width:80%;height:90px;margin-left:20px;margin-top:10px;padding:0px;">
                                    <div class="labelSelet-main">
                                        <div class="selectDiv">
                                            <p>排序方式</p>
                                            <select class="select">
                                                <option>推荐级别</option>
                                                <option>点击量</option>
                                                <option>添加时间</option>

                                            </select>
                                        </div>

                                        <div class="selectDiv">
                                            <p>产品属性</p>
                                            <select class="select">
                                                <option>新户专享</option>
                                                <option>添加时间</option>
                                                <option>点击量</option>
                                                <option>添加时间</option>
                                                <option>点击量</option>
                                            </select>
                                        </div>
                                        <div class="selectDiv">
                                            <p>筛选</p>
                                            <select class="select">
                                                <option>审核中</option>
                                                <option>添加时间</option>
                                                <option>点击量</option>
                                                <option>添加时间</option>
                                                <option>点击量</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="shopping-tab">
                                <div class="shopping-thead">
                                    <ul>
                                        <li>产品图片</li>
                                        <li>产品名称</li>
                                        <li>所属属性</li>
                                        <li>上架状态</li>
                                        <li>添加时间</li>
                                        <li>PV</li>
                                        <li>UV</li>
                                        <li>操作</li>
                                    </ul>
                                </div>
                                <div class="shopping-tbody1">

                                    <div class="shopping-tbody-items">
                                        <ul>
                                            <li>
                                                <img src="${ctx }/images/微信截图_20190307101309.png">
                                            </li>
                                            <li>速贷贷款</li>
                                            <li>新户专享</li>
                                            <li>审核中</li>
                                            <li>2019-02-23</li>
                                            <li>78</li>
                                            <li>8</li>
                                            <li>
                                                <div class="sets">
                                                    <div class="merchantsgraphics">图形数据</div>
                                                    <div class="shoppEditor">编辑</div>
                                                    <div>删除</div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>

                                </div>
                            </div>
                            <div class="indexcontent-tabPage">
                                <div class="zxf_pagediv5"><span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="zxfPagenum nextpage">2</a><a href="javascript:;" class="zxfPagenum">3</a><span>...</span><a href="javascript:;" class="nextbtn">下一页</a><span>共<b>20</b>页，</span><span>到第<input type="number" class="zxfinput" value="5">页</span><span class="zxfokbtn">确定</span></div>
                            </div>
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
                },error:function(result){
                    layer.msg(result.code);
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
            alert("获取搜索的值"+sousuo2)
            $(".shopping-tbody1").empty();
            $.ajax({
                type:"post",
                dateType:"json",
                url:"<%=basePath %>/Member/getList",
                data:{pageNo:1,pageSize:7,phone:sousuo2},
                success: function(result){
                    total2=result.total;
                    var  I=result.rows.length;
                    var o = $(".shopping-tbody1");
                    if (result.length!==0) {
                        for(var G=0;G<I;G++){
                            var D ='<div class="shopping-tbody-items">'+
                                '<ul class="ul">' +
                                '<li><img src="'+imgd+result.rows[G].img+'"/></li>'+
                                '<li>'+result.rows[G].title+'</li>' +
                                '<li>'+result.rows[G].propertyTitle+'</li>'+
                                '<li>'+result.rows[G].statusName+'</li>'+
                                '<li>'+result.rows[G].addTime+'</li>'+
                                '<li>'+result.rows[G].pv+'</li>'+
                                '<li>'+result.rows[G].uv+'</li>'+
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
                    $(".shopping-tbody1").paging(options)
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
            url:"<%=basePath %>/tenantGoods/getList",
            data:{pageNo:1,pageSize:7},
            success: function(result){
                total2=result.total;
                var  I=result.rows.length;
                var o = $(".shopping-tbody1");
                if (result.length!==0) {
                    for(var G=0;G<I;G++){
                        var D ='<div class="shopping-tbody-items">'+
                            '<ul class="ul">' +
                            '<li>'+result.rows[G].id+'</li>'+
                            '<li>'+result.rows[G].phone+'</li>' +
                            '<li>'+result.rows[G].registeredSource+'</li>'+
                            '<li>'+result.rows[G].addTime+'</li>'+
                            '<li>'+result.rows[G].loginTime+'</li>'+
                            '<li>'+result.rows[G].loginIp+'</li>'+
                            '<li>'+
                            '<div class="set">'
                            +'<div class="indexcontentEditors"  onclick="TagUpadete(this.id)" id="'+result.rows[G].id+'">编辑</div>' +
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
                $(".shopping-tbody1").paging(options)
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
            $(".shopping-tbody1").empty();
            var I=data.rows.length;
            var o = $(".shopping-tbody1");
            if (data.length!==0) {
                for(var G=0;G<I;G++){
                    var D ='<div class="shopping-tbody-items">'+
                        '<ul class="ul">' +
                        '<li>'+data.rows[G].id+'</li>'+
                        '<li>'+data.rows[G].phone+'</li>' +
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