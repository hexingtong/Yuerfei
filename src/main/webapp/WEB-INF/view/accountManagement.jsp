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
    <title>商户管理</title>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <style>

    </style>
</head>
<body>
    <div id="indexBox">
        <div class="indexcontent">
            <%@ include file="left.jsp" %>
            <!--超市展示右边-->
            <div class="indexcontent-right6" style="display: block;">
                <div class="indexcontent-right-main">

                    <%@ include file="top.jsp" %>

                    <div class="right-collection">
                <!--商户管理右边-->
                <div class="indexcontent-right1">
                    <div class="indexcontent-right-main">
                        <div class="indexcontent-right-top">
                            <img  src="${ctx }/images/Full screen button.svg"/>
                            <div class="indexcontent-right-top-right">
                                <img  src="${ctx }/images/quit.svg"/>
                                <p>退出</p>
                            </div>
                        </div>
                        <div class="indexcontent-right-bottom">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">商户管理列表</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">商户ID</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入商户账号"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">企业名称</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入企业名称"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">证件号码</div>
                                                <div class="members-form-top-inputs">
                                                    <input placeholder="请输入企业证件号码"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">邮箱</div>
                                                <div class="members-form-top-inputs">
                                                    <input placeholder="请输入邮箱地址"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">手机号码</div>
                                                <div class="members-form-top-inputs">
                                                    <input placeholder="请输入手机号码"/>
                                                </div>
                                            </div>

                                            <div class="members-form-tops">
                                                <div class="members-form-tops-text">营业执照</div>
                                                <div class="members-form-tops-img">
                                                    <img  src="${ctx }/images/timg.jpg"/>
                                                </div>
                                            </div>

                                            <div class="members-form-top">
                                                <div class="members-form-top-text">认证信息</div>
                                                <div class="members-form-top-inputss">
                                                    <div class="certification-icon"></div>
                                                    <div class="certification-text">已认证</div>
                                                </div>
                                            </div>



                                            <div class="members-form-bottom">
                                                <div>提交</div>
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
  $(document).ready(function(){
      var Height=$(window).height();//
      var Height1=$(window).height()-60;//
      var Width=$(window).width();
      var indexData=[
          {icon:"&#xe604",text:"欢迎来到首页"},
          {icon:"&#xe60d",text:"会员管理列表"},
          {icon:"&#xe60f",text:"商户管理列表"},
          {icon:"&#xe602",text:"产品属性列表"},
          {icon:"&#xe603",text:"标签展示列表"},
          {icon:"&#xe610",text:"商户展示列表"},
          {icon:"&#xe615",text:"超市展示列表"},
          {icon:"&#xe605",text:"推广链接列表"},
          {icon:"&#xe608",text:"管理人员列表"},
      ];
      console.log(Height+'+'+Width);
      $('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);
      $('.indexcontent-right-bottom').css('height',Height1);
      var h1 = '';
      for(var i=0;i<indexData.length;i++){
          if(i==2){
              h1 += '<div class="indexcontent-left-item active">'+
                      '<div class="indexcontent-left-item-left">'+
                      '<i class="iconfont">'+indexData[i].icon+'</i>'+
                      '</div>'+
                      '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                      '<div class="indexcontent-left-item-right">'+
                      '<i class="iconfont">&#xe912</i>'+
                      '</div>'+
                      '</div>';
          }else{
              h1 += '<div class="indexcontent-left-item grey">'+
                      '<div class="indexcontent-left-item-left">'+
                      '<i class="iconfont">'+indexData[i].icon+'</i>'+
                      '</div>'+
                      '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                      '<div class="indexcontent-left-item-right">'+
                      '<i class="iconfont">&#xe912</i>'+
                      '</div>'+
                      '</div>';
          };

      };
      $('.indexcontent-left-list-main').append(h1);

      /*点击左边切换右边*/
      $('.indexcontent-left-list-main>div').on('click',function(){
          var index=$(this).index();
          console.log(index);
          window.location.href="index.html?id="+index;
      })

  });

    $('.back').on('click',function(){
        window.location.href="index.jsp";
    })


</script>
</body>
</html>
