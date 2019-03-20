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
    <title>编辑商户展示列表</title>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/upload.css">
    <link rel="stylesheet" type="text/css" href="./css/font/iconfont.css">
    <style>
        /*å¤´åƒ*/
        /**************账户设置**********************/
        .user-img-wrap{
            padding: .5rem;
            overflow: hidden;
            display: flex;
            align-items: center;
        }
        .user-img-wrap .file-to-upload{
            display: none !important;
        }

        .user-img{
            width:3rem;
            height:3rem;
            margin-right: .2rem;
        }
        .user-img img{
            width:3rem;
            height:3rem;
            border-radius: 50%;
        }
        .shop-name{
            font-weight: bold;
            color: #050505;
            display: block;
            font-size: 1rem;
        }
        select{
            border:none;
            height:30px;
            width:30px;
            background:rgb(237,243,252);
            color:rgb(36,143,246);
        }
        .selects{
            width:250px;
            height:30px;
            color:#4BA5FF;
            background: #B2D8FF;
        }
    </style>
</head>
<body>
    <div id="indexBox">
        <div class="indexcontent">
            <div class="indexcontent-left">
                <div class="indexcontent-left-header">
                    <img class="left-img1" src="./images/logo.svg"/>
                </div>
                <div class="indexcontent-left-face">
                    <div>
                        <img class="left-img1" src="./images/head portrait.svg"/>
                    </div>
                </div>
                <div class="indexcontent-left-list" style="height:1200px;">
                    <div class="indexcontent-left-list-main">

                    </div>
                </div>
            </div>
            <div class="right-collection">
                <!--会员管理右边-->
                <div class="indexcontent-right1">
                    <div class="indexcontent-right-main">
                        <div class="indexcontent-right-top">
                            <img  src="./images/Full screen button.svg"/>
                            <div class="indexcontent-right-top-right">
                                <img  src="./images/quit.svg"/>
                                <p>退出</p>
                            </div>
                        </div>
                        <div class="indexcontent-right-bottom" style="height:1400px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">编辑商户展示列表</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">属性名称</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员只能姓名(10字以内)"/>
                                                </div>
                                            </div>

                                            <div class="members-form-top-add" style="margin-top:50px;">
                                                <div class="members-form-top-add-left">
                                                    <div class="shop-form-top-text-add">属性名称</div>
                                                    <div class="shop-form-top-input-add user-img-wrap" id="header_thumb">
                                                        <form enctype="multipart/form-data" method="post">
                                                            <span class="thumb user-img"><img src="./images/十字.png" class="needsclick" alt=""></span>
                                                            <input type="file" name="fileToUpload" class="file-to-upload file-loading" accept="image/*"/>
                                                        </form>
                                                    </div>
                                                </div>
                                                <div class="members-form-top-add-right">
                                                    <div class="lines">
                                                        <p>产品额度</p>
                                                        <div class="linesInput">
                                                            <input placeholder="请输入额度" />
                                                        </div>
                                                        <span>元</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="shopDate">
                                                <div class="shopDate-left">
                                                    <div class="shopDate-title">产品日期</div>
                                                    <div class="shopDate-cloose">
                                                        <div class="date">
                                                            <form name="form1" method="post" action="">
                                                                <select name="month"></select>
                                                            </form>
                                                        </div>
                                                        <p>月</p>
                                                        <div class="date" style="margin-left:40px;">
                                                            <form name="form1" method="post" action="">
                                                                <select name="month"></select>
                                                            </form>
                                                        </div>
                                                        <div class="date_"></div>
                                                        <div class="date">
                                                            <form name="form1" method="post" action="">
                                                                <select name="day"></select>
                                                            </form>
                                                        </div>
                                                        <p>月</p>
                                                    </div>
                                                </div>
                                                <div class="shopDate-right">
                                                    <div class="lines">
                                                        <p>产品利率</p>
                                                        <div class="linesInput">
                                                            <input placeholder="请输入利率" />
                                                        </div>
                                                        <span>%</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="shopAttribute">
                                                <div class="shopDate-left">
                                                    <div class="lines">
                                                        <div class="shopDate-title">产品日期</div>
                                                        <div class="shopDate-clooses">
                                                            <select class="selects">
                                                                <option>新户专享</option>
                                                                <option>添加时间</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="shopDate-right">
                                                    <div class="lines">
                                                        <div class="shopDate-title">标签名称</div>
                                                        <div class="shopDate-clooses">
                                                            <select class="selects">
                                                                <option>请选择</option>
                                                                <option>精选</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="describeAttribute">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">产品描述</div>
                                                    <div class="describe-clooses">
                                                        <input placeholder="请输入相关产品描述(16个字以内)" />
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="productDetails">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">产品详情</div>
                                                    <div class="product-texts">
                                                        <div class="product-text">
                                                            <div class="product-text-main">
                                                                <div class="product-text-top">
                                                                    <div class="product-text-top-left">
                                                                        <p>企业认证</p>
                                                                        <div><input placeholder="输入相关描述" /></div>
                                                                    </div>
                                                                    <div class="product-text-top-left">
                                                                        <p style="margin-left:10px;">客服电话</p>
                                                                        <div><input placeholder="输入客服电话" /></div>
                                                                    </div>
                                                                </div>
                                                                <div class="product-textarea">
                                                                    <div class="productText-text-top-left">
                                                                        <p>产品详情</p>
                                                                        <div>
                                                                            <textarea placeholder="输入相关描述"></textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="sorting">
                                                <div class="sorting-lefts">
                                                    <div class="sorting-title">产品描述</div>
                                                    <div class="sorting-clooses">
                                                        <div class="sorting-p">默认点击最高</div>
                                                        <div class="sorting-clooses-main">
                                                            <div class="sorting-clooses-main-top">
                                                                <p>审核状态</p>
                                                                <select class="select-2">
                                                                    <option>请选择</option>
                                                                    <option>精选</option>
                                                                </select>
                                                            </div>
                                                            <div class="sorting-clooses-main-bottom">
                                                                <p>原因</p>
                                                                <input/>
                                                            </div>
                                                            <p style="color:red;font-size: 14px;">*审核失败需写原因</p>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                            <div class="members-form-bottoms">
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
    <script src="js/Calender.js"></script>
    <script type="text/javascript" src="js/upload/upload.js"></script>
    <script>
        $(document).ready(function () {
            $("#header_thumb").fileUpload({
                "url": "savetofile.php",
                "file": "fileToUpload",
                "uploadComplete": function (data) {
                    //回调函数，data就是后台返回的json
                    console.log(data);
                },
                "uploadFailed": null
            });
        });
    </script>
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
      /*$('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);*/
     /* $('.indexcontent-right-bottom').css('height',Height1);*/
      var h1 = '';
      for(var i=0;i<indexData.length;i++){
          if(i==5){
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
