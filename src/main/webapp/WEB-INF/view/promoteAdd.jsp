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
    <title>新增推广链接产品</title>
    <script src='https://libs.baidu.com/jquery/1.10.2/jquery.min.js'></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <style>

    </style>
</head>
<body>
<div id="indexBox">
    <div class="indexcontent">
        <%@ include file="left.jsp" %>
        <div class="right-collection">
            <!--会员管理右边-->
            <div class="indexcontent-right1">

                <div class="indexcontent-right-main">
                    <%@ include file="top.jsp" %>

                    <div class="indexcontent-right-bottom" style="height: 875px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">新增推广链接</div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <form>
                                    <div class="members-form">

                                        <div class="members-form-top">
                                            <div class="members-form-top-text">渠道名称</div>
                                            <div class="members-form-top-inputs">
                                                <input id="title" placeholder="请输入产品名称(20字以内)">
                                            </div>
                                        </div>

                                        <div class="members-form-top" style="margin-top:80px;">
                                            <div class="members-form-top-text">网址链接</div>
                                            <div class="members-form-top-input">
                                                <input id="url"  placeholder="请输入要生成短链接的网址链接(文字60字以内)">
                                            </div>
                                        </div>


                                        <div class="members-form-bottom">
                                            <div id="sub">提交</div>
                                            <div class="back">返回</div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script>
    /**点击提交
     * */

    $("#sub").click(function() {
        var title=$("#title").val();
        var url=$("#url").val();
        alert("title"+title);
            alert("url的值"+url);
                $.post('${ctx }/friend/insertFriend',{title:title, longUrl:url},function (res) {
                        var jsonData=JSON.parse(res);
                        if(jsonData.code=="200") {
                            layer.msg("上传成功!")
                            window.history.go(-1);
                        }else{
                            layer.msg("上传失败！")
                        }
                    })



        })





    $(document).ready(function() {
        var Height = $(window).height();//
        var Height1 = $(window).height() - 60;//
        var Width = $(window).width();
        $('#indexBox').css('width', Width);
        $('#indexBox').css('height', Height);
        $('.indexcontent-right-bottom').css('height', Height1);


        $('.back').on('click', function () {
            window.history.back(-1);
        })
    })

</script>
</body>
</html>
