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
    <title>编辑管理员</title>
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
        .members-form-top-123 {
            width: 100%;
            height: 100px;
            display: flex;
            margin-bottom: 15px;
            margin-top: 50px;
            align-items: center;
        }

        .user-img-wrap {
            /* padding: .5rem; */
            overflow: hidden;
            display: flex;
            align-items: center;
        }

        .user-img-wrap .file-to-upload {
            display: none !important;
        }

        .user-img {
            width: 3rem;
            height: 3rem;
            margin-right: .2rem;
        }

        .user-img img {
            width: 3rem;
            height: 3rem;
            border-radius: 50%;
        }

        .shop-name {
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
                                <div class="indexcontent-header-title">编辑管理员</div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <form>
                                    <div class="members-form" style="margin:20px auto;">
                                        <div class="members-form-top">
                                            <div class="members-form-top-text">管理员姓名</div>
                                            <div class="members-form-top-input">
                                                <input placeholder="请输入管理员姓名(10字以内)" value="${knAdmin.title}"
                                                       id="title">
                                            </div>
                                        </div>

                                        <div class="members-form-top">
                                            <div class="members-form-top-text">账号</div>
                                            <div class="members-form-top-input">
                                                <input placeholder="请输入管理员姓名(以数字和英文相结合15字以内)" value="${knAdmin.phone}"
                                                       id="phone">
                                            </div>
                                        </div>
                                        <div class="members-form-top">
                                            <div class="members-form-top-text">密码</div>
                                            <div class="members-form-top-input">
                                                <input placeholder="请输入相关密码(以数字和英文相结合15字以内)" value="${knAdmin.pwd}"
                                                       id="pwd">
                                            </div>
                                        </div>

                                        <div class="members-form-top">
                                            <div class="members-form-top-text">管理员权限</div>
                                            <div class="members-form-top-input"
                                                 style="border:none;background:#fff;display: flex;align-items: center;font-size:14px;color:#2290FF;">
                                                <p>${roleInfo.roleName}</p>
                                            </div>
                                        </div>

                                        <div class="members-form-top-add">
                                            <div class="members-form-top-text-add">头像图片</div>
                                            <div class="members-form-top-input-add">
                                                <img src="<%=basePath %>${knAdmin.img}" id="img">
                                            </div>
                                        </div>


                                        <div class="members-form-top-123">
                                            <div class="members-form-top-text-add">修改头像图片</div>
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
<script type="text/javascript" src="${ctx }/js/upload/upload.js"></script>
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
            alert(title+phone+pwd+img)

            if (title == ''||title==null||title==undefined && phone == ''||phone==null||phone==undefined &&  pwd == ''||pwd==null||pwd==undefined) {
                alert("请填完成信息编辑");
            } else {
                $.ajax({
                    url: "<%=basePath %>/Manage/saveManagement",
                    type: "post",
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    data: JSON.stringify({
                        id:${knAdmin.id},
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
    $(document).ready(function () {
        var Height = $(window).height();//
        var Height1 = $(window).height() - 60;//
        var Width = $(window).width();
        var indexData = [
            {icon: "${ctx }/images/home-1.svg", text: "欢迎来到首页"},
            {icon: "${ctx }/images/member-1.svg", text: "会员管理列表"},
            {icon: "${ctx }/images/commercial tenant-1.svg", text: "商户管理列表"},
            {icon: "${ctx }/images/attributa-1.svg", text: "产品属性列表"},
            {icon: "${ctx }/images/label-1.svg", text: "标签展示列表"},
            {icon: "${ctx }/images/merchant display-1.svg", text: "商户展示列表"},
            {icon: "${ctx }/images/supermarket-1.svg", text: "超市展示列表"},
            {icon: "${ctx }/images/referral  link.svg", text: "推广链接列表"},
            {icon: "${ctx }/images/merchant display.svg", text: "管理人员列表"},
        ];
        console.log(Height + '+' + Width);
        $('#indexBox').css('width', Width);
        $('#indexBox').css('height', Height);
        $('.indexcontent-right-bottom').css('height', Height1);
        var h1 = '';
        for (var i = 0; i < indexData.length; i++) {
            if (i == 8) {
                h1 += '<div class="indexcontent-left-item active">' +
                    '<div class="indexcontent-left-item-left">' +
                    '<img src="' + indexData[i].icon + '"/>' +
                    '</div>' +
                    '<div class="indexcontent-left-item-middle">' + indexData[i].text + '</div>' +
                    '<div class="indexcontent-left-item-right">' +
                    '<i class="iconfont">&#xe912</i>' +
                    '</div>' +
                    '</div>';
            } else {
                h1 += '<div class="indexcontent-left-item grey">' +
                    '<div class="indexcontent-left-item-left">' +
                    '<img src="' + indexData[i].icon + '"/>' +
                    '</div>' +
                    '<div class="indexcontent-left-item-middle">' + indexData[i].text + '</div>' +
                    '<div class="indexcontent-left-item-right">' +
                    '<i class="iconfont">&#xe912</i>' +
                    '</div>' +
                    '</div>';
            }
            ;

        }
        ;
        $('.indexcontent-left-list-main').append(h1);


        /*点击左边切换右边*/
        $('.indexcontent-left-list-main>div').on('click', function () {
            var index = $(this).index();
            console.log(index);
            window.location.href = "index.html?id=" + index;
        })

    });

    $('.back').on('click', function () {
        window.location.href = "index.jsp";
    })


</script>
</body>
</html>
