<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑管理员</title>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/upload.css">
    <style>
        /*å¤´åƒ*/
        /**************账户设置**********************/
        .user-img-wrap{
            /* padding: .5rem; */
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
                <div class="indexcontent-left-list">
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
                        <div class="indexcontent-right-bottom">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">编辑管理员</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form" style="margin:20px auto;">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">管理员姓名</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员姓名(10字以内)"/>
                                                </div>
                                            </div>

                                            <div class="members-form-top">
                                                <div class="members-form-top-text">账号</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员姓名(以数字和英文相结合15字以内)"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">密码</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入相关密码(以数字和英文相结合15字以内)"/>
                                                </div>
                                            </div>

                                            <div class="members-form-top">
                                                <div class="members-form-top-text">管理员权限</div>
                                                <div class="members-form-top-input" style="border:none;background:#fff;display: flex;align-items: center;font-size:14px;color:#2290FF;">
                                                    <p>超级管理员</p>
                                                </div>
                                            </div>

                                            <div class="members-form-top-add">
                                                <div class="members-form-top-text-add">头像图片</div>
                                                <div class="members-form-top-input-add">
                                                    <img  src="./images/shuaige.png"/>
                                                </div>
                                            </div>


                                            <div class="members-form-top-add">
                                                <div class="members-form-top-text-add">修改头像图片</div>
                                                <div class="members-form-top-input-add user-img-wrap" id="header_thumb">
                                                    <form enctype="multipart/form-data" method="post">
                                                        <span class="thumb user-img"><img src="./images/十字.png" class="needsclick" alt=""></span>
                                                        <input type="file" name="fileToUpload" class="file-to-upload file-loading" accept="image/*"/>
                                                    </form>
                                                </div>
                                                <p>图片需小于100Kb,推荐宽高比为1:1，支持png.gif.png格式</p>
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
          {icon:"./images/home-1.svg",text:"欢迎来到首页"},
          {icon:"./images/member-1.svg",text:"会员管理列表"},
          {icon:"./images/commercial tenant-1.svg",text:"商户管理列表"},
          {icon:"./images/attributa-1.svg",text:"产品属性列表"},
          {icon:"./images/label-1.svg",text:"标签展示列表"},
          {icon:"./images/merchant display-1.svg",text:"商户展示列表"},
          {icon:"./images/supermarket-1.svg",text:"超市展示列表"},
          {icon:"./images/referral  link.svg",text:"推广链接列表"},
          {icon:"./images/merchant display.svg",text:"管理人员列表"},
      ];
      console.log(Height+'+'+Width);
      $('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);
      $('.indexcontent-right-bottom').css('height',Height1);
      var h1 = '';
      for(var i=0;i<indexData.length;i++){
          if(i==8){
              h1 += '<div class="indexcontent-left-item active">'+
                      '<div class="indexcontent-left-item-left">'+
                      '<img src="'+indexData[i].icon+'"/>'+
                      '</div>'+
                      '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                      '<div class="indexcontent-left-item-right">'+
                      '<img src="./images/跳转 前往 右箭头 向右 下一步 线性 .png"/>'+
                      '</div>'+
                      '</div>';
          }else{
              h1 += '<div class="indexcontent-left-item grey">'+
                      '<div class="indexcontent-left-item-left">'+
                      '<img src="'+indexData[i].icon+'"/>'+
                      '</div>'+
                      '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                      '<div class="indexcontent-left-item-right">'+
                      '<img src="./images/跳转 前往 右箭头 向右 下一步 线性  (1).png"/>'+
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
        window.history.back(-1);
    })


</script>
</body>
</html>
