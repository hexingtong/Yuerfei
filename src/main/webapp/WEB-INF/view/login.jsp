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
    <title>登录</title>
    <%--<script src="${ctx }/js/jquery.min.js"></script>--%>
    <link rel="stylesheet" type="text/css" href="http://cdn.amazeui.org/amazeui/2.4.2/css/amazeui.min.css"/>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript" src="${ctx }/js/amazeui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <style>
          input[type=checkbox]{
              margin: 50px;
              /*同样，首先去除浏览器默认样式*/
              -webkit-appearance: none;
              -moz-appearance: none;
              appearance: none;
              /*编辑我们自己的样式*/
              position: relative;
              width: 20px;
              height: 20px;
              background: transparent;
              border:1px solid #fff;
              -webkit-border-radius: 4px;
              -moz-border-radius: 4px;
              border-radius: 4px;
              outline: none;
              cursor: pointer;
          }
        input[type=checkbox]:after{
            content: '√';
            position: absolute;
            display: block;
            width: 100%;
            height: 100%;
            background: rgb(35,141,255);
            color: #fff;
            text-align: center;
            line-height: 18px;
            /*增加动画*/
            -webkit-transition: all ease-in-out 300ms;
            -moz-transition: all ease-in-out 300ms;
            transition: all ease-in-out 300ms;
            /*利用border-radius和opacity达到填充的假象，首先隐藏此元素*/
            -webkit-border-radius: 20px;
            -moz-border-radius: 20px;
            border-radius: 20px;
            opacity: 0;
        }
        input[type=checkbox]:checked:after{
            -webkit-border-radius: 0;
            -moz-border-radius: 0;
            border-radius: 0;
            opacity: 1;
        }
        ::-webkit-input-placeholder { /* WebKit browsers */
            color: #fff;
            font-size: 16px;
        }

        ::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: #fff;
            font-size: 16px;
        }

        :-ms-input-placeholder { /* Internet Explorer 10+ */
            color: #fff;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div id="loginBox">
        <div class="loginContent">
            <div class="loginContent-top">
                <div class="loginContent-top-left">
                    <div class="loginContent-top-left-main">
                        <div class="loginContent-top-left-top">
                            <img class="left-img1" src="${ctx }/images/微信截图_20190305152805.png"/>
                        </div>
                        <div class="loginContent-top-left-bottom">
                            <img class="left-img1" src="${ctx }/images/微信截图_20190305152813.png"/>
                        </div>
                    </div>
                </div>
                <div class="loginContent-top-right">
                    <div class="loginContent-top-right-main">

                            <div class="divInput">
                                <input name="code" id="code" placeholder="请输入您的帐号" />
                            </div>
                            <div class="divInput">
                                <input name="pwd1" id="pwd1" placeholder="请输入您的密码"/>
                            </div>
                            <div class="divBtn" onclick="sign()">
                                <button >登录</button>
                            </div>
                            <%--<div class="divRadio">--%>
                                <%--<input type="checkbox" />--%>
                              <%--<p>下次自动登录</p>--%>
                            <%--</div>--%>

                    </div>
                </div>
            </div>
            <div class="loginContent-bottom">
                <div class="loginContent-bottom-top">
                    <img class="left-img1" src="${ctx }/images/微信截图_20190305165132.png"/>
                </div>
                <div class="loginContent-bottom-bottom">
                    <img class="left-img1" src="${ctx }/images/微信截图_20190305165307.png"/>
                </div>
            </div>
        </div>
    </div>
<script>

    function sign(){
        var user_account=document.getElementById("code").value;
        var user_password=document.getElementById("pwd1").value;
       // alert("<%=basePath %>/admin/loginhoutai");
        if (user_account==""||user_account==null) {
            alert("账号不能为空")
            return;
        }

        if (user_password==""||user_password==null) {
            alert("密码不能为空")
            return;
        }
  if(user_account!=null&&user_password!=null){
          $.ajax({
              type:"post",
              dateType:"json",
              url:"<%=basePath %>admin2/login2",
              data:{userName:user_account,pwd:user_password},
              success: function(data){
                  var jsonData=JSON.parse(data);
                //  alert(data)
                  if(jsonData=="null"){
                      alert("传入有误")
                  }else if (jsonData=="fail2"){
                      alert("密码不匹配")
                  }else if(jsonData=="fail"){
                      alert("没有该数据")
                  }else if (jsonData.items=="no"){
                      alert("没有该权限")
                  }
                  else if(jsonData=="suse"){
                      window.location.href=("<%=basePath %>/admin2/index");
                  }


              },
              error:{

              }


          });




  }




    }



  $(document).ready(function(){
    var Height=$(window).height();//浏览器当前窗口可视区域高度;
    var Width=$(window).width();
      console.log(Height+'+'+Width);
    $('#loginBox').css('width',Width);
      $('#loginBox').css('height',Height);

    /*  $.ajax({
          url: 'http://shopapi3.daoyunkj.com/api/index.php?act=member_draw',
          type:"GET",
          data: '',
          success: function(data){
              console.log(data);
              if(data.code == 1) {
                  var integral=data.data.user_score;
                  var count=data.data.count;
                  username=data.data.username;
                  $('.header_bottom-left').find('span').html(integral+'积分');
                  $('.header_bottom-right').find('span').html(count)
                  var array=data.data.jackpot;
                  var hl = '';
                  for (var i=0;i<array.length;i++){
                      hl += '<div class="shan" data-id="'+array[i].id +'">'+'<span>'+array[i].title +'</span>'+'<img src='+ array[i].imageUrl +' width="50%" />'+'</div>';

                  }
                  $('.lt').prepend(hl)
              }
          }
      });*/
  });


</script>
</body>
</html>
