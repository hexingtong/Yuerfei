<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language=    "java" %>
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
            <div class="right-collection">
                <!--会员管理右边-->
                <div class="indexcontent-right1">
                    <div class="indexcontent-right-main">
                                <%@ include file="top.jsp" %>
                                <div class="indexcontent-right-bottom" style="height: 837px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">会员管理列表</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">会员账号</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入会员账号20字以内" value="${knadmin.phone}" name="title">
                                                </div>
                                            </div>
                                            <div class="members-form-bottom">
                                                <div id="sub" onclick="Tagtijiao">提交</div>
                                                <div class="back" onClick="javascript :history.back(-1);">返回</div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<script>
    $('#sub').click(function(){
        Tagtijiao();
    })

    function Tagtijiao(){
        var title=$("input[name='title']").val();
        var id=${param.id }
        if(title!=null&&title!=""){
            $.ajax({
                type:"post",
                dateType:"json",
                url:"${ctx }/Member/updateAdmin",
                data:{phone:title,id:id},
                success:function(result){
                    if(result.code==1){
                        layer.msg("修改成功！")
                        window.location.href="${ctx }/url/MeberUrl";
                    }else if(result.code==0){
                        layer.msg("修改失败！")
                    }
                },
                error:function(){
                    layer.msg("修改失败！")
                }
            });
        }else{
            layer.msg("请输入值！")
        }
    }
</script>
</body>
</html>
