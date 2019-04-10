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
    <title>标签修改</title>
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
            <%--<div class="right-collection">--%>
                <%@ include file="left.jsp" %>
                <div class="right-collection">
                    <!--标签修改右边-->
                    <div class="indexcontent-right1">
                        <div class="indexcontent-right-main">
                                        <%@ include file="top.jsp" %>
                            <div class="indexcontent-right-bottom" style="height: 884px;">
                                <div class="label-right-bottom-main">
                                    <div class="indexcontent-right-bottom-main-header">
                                        <div class="indexcontent-header-title">标签展示列表</div>
                                    </div>
                                    <div class="indexcontent-right-bottom-main-content">
                                            <div class="members-form">
                                                <div class="members-form-top">
                                                    <div class="members-form-top-text">标签名称</div>
                                                    <div class="members-form-top-input">
                                                        <input name="title" type="text" value="${kntag.title}" placeholder="请输入标签名称20字以内">
                                                    </div>
                                                </div>
                                                <input type="hidden" id="tagid" value="${kntag.id}" >
                                                <div class="members-form-bottom">
                                                    <div id="sub" onclick="Tagtijiao" >提交</div>
                                                    <div class="back" onclick="javascript :history.back(-1);">返回</div>
                                                </div>
                                            </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <%--</div>--%>
    </div>

<script>

    $('#sub').click(function(){
        Tagtijiao();
    })


    function Tagtijiao(){
        var title=$("input[name='title']").val();
        var id=$("#tagid").val();
        if(title!=null&&title!=""){
        $.ajax({
               type:"post",
               dateType:"json",
               url:"${ctx }/Tag/MercjatTagListUpadete",
               data:{title:title,id:id},
               success:function(result){
                   var jsonData=JSON.parse(result);
                   if(jsonData.code=="200"){
                    layer.msg("修改成功！");
                       window.history.go(-1);
                   }else {
                       layer.msg("修改失败!")
                   }
               },
               error:function(){
                   layer.msg("错误！")
               },error:function(XMLhttpServlet){
                if (XMLhttpServlet.status==401){
                    $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                }
            }
           });
        }else{
            layer.msg("请输入值！")
        }
    }

  $(document).ready(function() {
      var Height = $(window).height();//
      var Height1 = $(window).height() - 60;//
      var Width = $(window).width();
      console.log(Height + '+' + Width);
      $('#indexBox').css('width', Width);
      $('#indexBox').css('height', Height);
      $('.indexcontent-right-bottom').css('height', Height1);
  })

</script>
</body>
</html>
