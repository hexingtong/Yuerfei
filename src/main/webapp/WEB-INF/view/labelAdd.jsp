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
    <title>标签新增</title>
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
                    <!--标签右边-->
                    <div class="indexcontent-right1">
                        <div class="indexcontent-right-main">
                            <div class="indexcontent-right-top">
                                <img src="${ctx }/images/Full screen button.svg">
                                <div class="indexcontent-right-top-right">
                                    <img src="${ctx }/images/quit.svg">
                                    <p>退出</p>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom" style="height: 884px;">
                                <div class="label-right-bottom-main">
                                    <div class="indexcontent-right-bottom-main-header">
                                        <div class="indexcontent-header-title">标签新增</div>
                                    </div>
                                    <div class="indexcontent-right-bottom-main-content">
                                        <form>
                                            <div class="members-form">
                                                <div class="members-form-top">
                                                    <div class="members-form-top-text">标签名称</div>
                                                    <div class="members-form-top-input">
                                                        <input name="placeholder2" placeholder="请输入标签名称20字以内">
                                                    </div>
                                                </div>
                                                <div class="members-form-bottom">
                                                    <div id="button">提交</div>
                                                    <div class="back" onclick="javascript :history.back(-1);">返回</div>
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
    $('#button').click(function() {
        var titlename=$("input[name='placeholder2']").val();
        var biaoshi=true;
        if (titlename == "" || titlename == null || titlename == undefined) {
            biaoshi=false;
            layer.msg("产品名称不能为空！");
        }
        // if (urlname == "" || urlname == null || urlname == undefined) {
        //     biaoshi=false;
        //     layer.msg("网站链接不能为空！")
        // }
        if(titlename.length>=20){
            biaoshi=false;
            layer.msg("产品名称大于或等于20")
        }
        // if(urlname.length>=60){
        //     biaoshi=false;
        //     layer.msg("网站链接大于或等于60")
        // }
        if(biaoshi==true){
            $.ajax({
                type:"post",
                dateType:"json",
                url:"${ctx }/Tag/MercjatTagListIncrease",
                data:{title:titlename},
                success:function(result){
                    var jsonData=JSON.parse(result);
                    if(jsonData.code=="200"){
                        layer.msg("增加成功！");
                        window.history.go(-1);
                    }
                },
                error:function (result) {
                    layer.msg("增加失败！");
                    window.history.go(-1);
                }
            });

     }


    })
  $(document).ready(function() {
      var Height = $(window).height();//
      var Height1 = $(window).height() - 60;//
      var Width = $(window).width();
      $('#indexBox').css('width', Width);
      $('#indexBox').css('height', Height);
      $('.indexcontent-right-bottom').css('height', Height1);

  })


</script>
</body>
</html>
