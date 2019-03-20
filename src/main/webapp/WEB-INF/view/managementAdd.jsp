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
    <title>添加管理员</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/js/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>

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
                        <div class="indexcontent-right-top">
                            <img src="${ctx }/images/Full screen button.svg">
                            <div class="indexcontent-right-top-right">
                                <img src="${ctx }/images/quit.svg">
                                <p>退出</p>
                            </div>
                        </div>
                        <div class="indexcontent-right-bottom" style="height: 837px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">添加管理员</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">管理员姓名</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员姓名(10字以内)" id="title">
                                                </div>
                                            </div>

                                            <div class="members-form-top">
                                                <div class="members-form-top-text">账号</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员姓名(以数字和英文相结合15字以内)" id="phone">
                                                </div>
                                            </div>
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">密码</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入相关密码(以数字和英文相结合15字以内)" id="pwd">
                                                </div>
                                            </div>

                                            <div class="members-form-top">
                                                <div class="members-form-top-text">管理员权限</div>
                                                <div class="members-form-top-input" style="width:20%;display: flex;align-items: center;">
                                                    <select class="select-1" >
                                                        <option grade="1" value="0">请选择</option >
                                                        <option grade="2" value="5">二级管理员</option >
                                                        <option grade="3" value="6">三级管理员</option>
                                                    </select>
                                                </div>
                                            </div>


                                            <div class="members-form-top-add" style="margin-top:50px;">
                                                <div class="members-form-top-text-add">产品图片</div>
                                                <div class="layui-upload">

                                                    <div class="layui-upload-list">
                                                        <!--预览图片-->
                                                        <img width="86" height="86" class="layui-upload-img" id="demo1">
                                                        <!--提示上传信息-->
                                                        <p id="demoText"></p>
                                                    </div>
                                                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                                                </div>
                                                <p>图片需小于100Kb,推荐宽高比为1:1，支持png.gif.png格式</p>
                                            </div>

                                            <div class="members-form-bottom">
                                                <div id="add">提交</div>
                                                <div class="back">返回</div>
                                            </div>
                                        </div></form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>

        $(document).ready(function () {
            var imgaddress = ''



            layui.use(['upload', 'jquery'], function () {
                var $ = layui.$,
                    upload = layui.upload;

                //普通图片上传
                var uploadInst = upload.render({
                    elem: '#test1'
                    , url: '<%=basePath %>/merchant/addUserInfo'
                    , before: function (obj) {//文件上传前的回调
                        //预读本地文件示例，不支持ie8
                        obj.preview(function (index, file, result) {
                            $('#demo1').attr('src', result); //图片链接（base64）直接将图片地址赋值给img的src属性
                        });
                    }
                    , done: function (res) {
                        //如果上传失败
                        if (res.code == 404) {
                            return layer.msg('上传失败');
                        } else if (res.code == 200) {

                            alert(res.items[0])
                            imgaddress = res.items[0]
                            return layer.msg('上传成功');
                        }
                        //上传成功
                    }
                    , error: function () {
                        //演示失败状态，并实现重传
                        var demoText = $('#demoText');
                        demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                        demoText.find('.demo-reload').on('click', function () {
                            uploadInst.upload();
                        });
                    }
                });
            });


            $("#add").click(function () {
                //获取选择的值
                var options=$(".select-1 option:selected"); //获取选中的项
                alert(options.val()); //拿到选中项的值
                var level=options.val();
                var title = $("#title").val();
                var phone = $("#phone").val();
                var pwd = $("#pwd").val();
                var img = ''
                if (imgaddress == '') {
                    alert("图片没有改变")
                    //图片没有改变
                    img = $("#img").val();
                } else if (imgaddress != '') {
                    //图片改变
                    img = imgaddress
                    alert("图片改变")
                }
                alert(title+"---"+phone+"---"+pwd+"---"+img+"---"+level+"---")

                if (title == ''||title==null||title==undefined || phone == ''||phone==null||phone==undefined ||  pwd == ''||pwd==null||pwd==undefined||level == 0||level==null||level==undefined) {
                    alert("请填完成信息编辑");
                } else {
                    $.ajax({
                        url: "<%=basePath %>/Manage/AddManage",
                        type: "post",
                        dataType: "json",
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify({
                            <%--id:${knAdmin.id},--%>
                            level:level,
                            title: title,
                            phone: phone,
                            pwd: pwd,
                            img: img
                        }),
                        success: function (data) {
                            if (data == 1) {
                                $(location).attr('href', '<%=basePath %>/url/MangerUrl')
                            } else if (data == 0) {
                                alert("修改失败")
                            } else {
                                alert("系统繁忙")
                            }
                        },error:function(XMLhttpServlet){
                            if (XMLhttpServlet.status==401){
                                $(location).attr('href', '<%=basePath %>/admin2/toLogin')
                            }
                        }
                    });

                }




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
      $('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);
      $('.indexcontent-right-bottom').css('height',Height1);
      var h1 = '';
      for(var i=0;i<indexData.length;i++){
          if(i==8){
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
