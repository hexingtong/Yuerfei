<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑产品属性列表</title>
    <script src="js/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="./css/common.css">
    <link rel="stylesheet" type="text/css" href="./css/font/iconfont.css">
    <style>

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
                                    <div class="indexcontent-header-title">编辑产品属性列表</div>
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

                                            <div class="members-form-top-add">
                                                <div class="members-form-top-text-add">属性名称</div>
                                                <div class="members-form-top-input-add">
                                                    <img  src="./images/shuaige.png"/>
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
          if(i==3){
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
