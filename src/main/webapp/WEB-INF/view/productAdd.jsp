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
    <title>添加产品属性列表</title>
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
                        <%@ include file="top.jsp" %>
                        <div class="indexcontent-right-bottom" style="height: 837px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">添加产品属性列表</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">属性名称</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员只能姓名(10字以内)" id="title">
                                                </div>
                                            </div>

                                            <div class="members-form-top-add" style="margin-top:100px;">
                                                <div class="members-form-top-text-add">产品图片</div>
                                                <div class="layui-upload">

                                                    <div class="layui-upload-list">
                                                        <!--预览图片-->
                                                        <img width="86" height="86" class="layui-upload-img" id="demo1" >
                                                        <!--提示上传信息-->
                                                        <p id="demoText"></p>
                                                    </div>
                                                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                                                </div>
                                                <p>图片需小于100Kb,推荐宽高比为1:1，支持png.gif.png格式</p>
                                            </div>


                                            <div class="members-form-bottom">
                                                <div id="add">提交</div>
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
    <script type="text/javascript" src="js/upload/upload.js"></script>
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
                var title = $("#title").val();
                var img = ''
                if (imgaddress != '') {
                    //图片改变
                    img = imgaddress
                }

                if (title == ''||title==null||title==undefined ||  img == ''||img==null||img==undefined) {
                   layer.msg("请填完成信息编辑");
                } else {
                    $.ajax({
                        url: "<%=basePath %>/GoodsAttribute/addAttribute",
                        type: "post",
                        dataType: "json",
                        contentType: 'application/json;charset=UTF-8',
                        data: JSON.stringify({
                            title: title,
                            img: img
                        }),
                        success: function (data) {
                            if (data == 1) {
                                $(location).attr('href', '<%=basePath %>/url/goodsAuthbuteUrl')
                            } else if (data == 0) {
                                layer.msg("修改失败")
                            } else {
                                layer.msg("系统繁忙")
                            }
                        }
                    });

                }




            });













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

      $('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);
      $('.indexcontent-right-bottom').css('height',Height1);



      /*点击左边切换右边*/
      $('.indexcontent-left-list-main>div').on('click',function(){
          var index=$(this).index();
          console.log(index);
          window.location.href="index.html?id="+index;
      })

  });




</script>
</body>
</html>
