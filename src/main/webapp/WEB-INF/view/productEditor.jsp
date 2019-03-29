<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<%--<% String path = request.getContextPath(); %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String imgd2 = "http://47.92.53.177:8080/Yuerfei/";
%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>编辑产品属性列表</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/js/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>

    <style>

  .members-form-top-add{
      margin-top: 200px;
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
                                    <div class="indexcontent-header-title">编辑产品属性列表</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">属性名称</div>
                                                <div class="members-form-top-input">
                                                    <input placeholder="请输入管理员只能姓名(10字以内)" value="${property.title}" id="title" >
                                                </div>
                                            </div>

                                            <div class="members-form-top-add">
                                                <div class="members-form-top-text-add" >属性图片</div>
                                                <div class="layui-upload">

                                                    <div class="layui-upload-list">
                                                        <!--预览图片-->
                                                        <img width="86" src="<%=basePath %>${property.img}" height="86" class="layui-upload-img" id="demo1" >
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

<script>
  $(document).ready(function(){

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
          var title = $("#title").val();
          var img = ''
          var id=${property.id}
          if (imgaddress != '') {
              //图片改变
              img = imgaddress
              alert("图片改变")
          }


          if (title == ''||title==null||title==undefined ||  img == ''||img==null||img==undefined) {
              alert("请填完成信息编辑");
          } else {
              $.ajax({
                  url: "<%=basePath %>/GoodsAttribute/updateAttribute",
                  type: "post",
                  dataType: "json",
                  data: {
                      id:id,
                      title: title,
                      img: img
                  },
                  success: function (data) {
                      if (data.code == 1) {
                          $(location).attr('href', '<%=basePath %>/url/goodsAuthbuteUrl')
                      } else if (data.code == 0) {
                          alert("修改失败")
                      } else {
                          alert("系统繁忙")
                      }
                  }
              });

          }




      });






      var Height=$(window).height();//
      var Height1=$(window).height()-60;//
      var Width=$(window).width();

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
        window.history.go(-1);
    })


</script>
</body>
</html>
