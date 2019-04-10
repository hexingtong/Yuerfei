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
    <title>添加产品展示</title>
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
        .layui-upload-img{
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
            color:rgb(125,165,203);
            background: rgb(239,242,252);
        }

        /*自定义单选*/
        /*隐藏input*/
        label.bui-radios-label input[type="radio"]{
            position: absolute;
            opacity: 0;
            visibility: hidden;
        }
        /*自定义radio*/
        label.bui-radios-label .bui-radios{
            display: inline-block;
            position: relative;
            width: 13px;
            height: 13px;
            background-color: #fff;
            border: 1px solid #979797;
            border-radius: 50%;
            vertical-align: -2px;
            margin-right: 10px;
        }
        /*单选框选中后，自定义radio的样式*/
        label.bui-radios-label input[type="radio"]:checked + .bui-radios:after{
            position: absolute;
            content: "";
            width: 7px;
            height: 7px;
            background-color: #fff;
            border-radius: 50%;
            top: 3px;
            left: 3px;
        }
        label.bui-radios-label input[type="radio"]:checked + .bui-radios{
            background-color: #B2D8FF;
            border:1px solid rgb(226,236,255);
        }

        label.bui-radios-label input[type="radio"]:disabled:checked + .bui-radios:after{
            background-color: rgb(36,143,246);
        }
        input {
            outline:none
        }
        .thumbImg{
            width:100%;
            height:100%;
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
                        <div class="indexcont
                        ent-right-bottom" style="height:1450px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header">
                                    <div class="indexcontent-header-title">添加产品展示</div>
                                </div>
                                <div class="indexcontent-right-bottom-main-content">
                                    <form>
                                        <div class="members-form">
                                            <div class="members-form-top">
                                                <div class="members-form-top-text">产品名称</div>
                                                <div class="members-form-top-input">
                                                    <input name="title" placeholder="请输入产品名称(10字以内)"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top-add" style="margin-top:50px;">
                                                <div class="members-form-top-add-left">
                                                    <%--<div class="shop-form-top-text-add">图片名称</div>--%>
                                                    <%--<div class="shop-form-top-input-add user-img-wrap" id="header_thumb">--%>
                                                        <%--<img class="thumbImg"   src="${ctx }/images/微信截图_20190307101309.png"/>--%>
                                                    <%--</div>--%>
                                                        <div class="layui-upload">
                                                            <button type="button" class="layui-btn" id="test1">上传图片</button>
                                                            <div class="layui-upload-list">
                                                                <!--预览图片-->
                                                                <img width="160" height="100" name="demo1" class="layui-upload-img" id="demo1">
                                                                <!--提示上传信息-->
                                                                <p id="demoText"></p>
                                                            </div>
                                                        </div>

                                                </div>
                                                <div class="members-form-top-add-right">
                                                    <div class="lines">
                                                        <p>产品额度</p>
                                                        <div class="linesInput">
                                                            <input name="Limit" placeholder="请输入额度" />
                                                        </div>
                                                        <span>元</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="members-form-top-adds">
                                                <%--<div class="members-form-top-add-lefts">--%>
                                                    <%--<div class="members-form-top-text-adds">申请人数</div>--%>
                                                    <%--<div class="linesInput">--%>
                                                        <%--<input name="applyCount" placeholder="请输入人数" />--%>
                                                    <%--</div>--%>
                                                    <%--<span>人</span>--%>
                                                <%--</div>--%>
                                                <div class="members-form-top-add-right">
                                                    <div class="lines">
                                                        <p>产品利率</p>
                                                        <div class="linesInput">
                                                            <input name="interestrate" placeholder="请输入利率" />
                                                        </div>
                                                        <span>%</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="shopDate">
                                                <div class="shopDate-left">
                                                    <div class="shopDate-title">产品期限</div>
                                                    <div class="shopDate-cloose">
                                                        <div class="date1">
                                                                <select name="month" id="index">
                                                                    <option value="0">0</option>
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="2">5</option>
                                                                    <option value="6">6</option>
                                                                    <option value="7">7</option>
                                                                    <option value="8">8</option>
                                                                    <option value="9">9</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                </select>
                                                        </div>
                                                        <p>月</p>
                                                        <div class="date" style="margin-left:40px;" onclick="onclickss()">
                                                            <select name="month" id="index2">
                                                                <option value="0" >0</option>
                                                                <option value="1" selected="selected">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="2">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
                                                                <option value="11">11</option>
                                                                <option value="12">12</option>
                                                            </select>
                                                        </div>
                                                        <div class="date_">
                                                        </div>
                                                        <div class="date" onclick="onclickss()" >
                                                            <select name="month" id="index3">
                                                                <option value="0">0</option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="2">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
                                                                <option value="11">11</option>
                                                                <option value="12">12</option>
                                                            </select>
                                                        </div>
                                                        <p>月</p>
                                                    </div>
                                                </div>
                                                <div class="shopDate-right">
                                                   <!-- <div class="lines">
                                                        <p>产品利率</p>
                                                        <div class="linesInput">
                                                            <input placeholder="请输入利率" />
                                                        </div>
                                                        <span>%</span>
                                                    </div>-->
                                                </div>
                                            </div>
                                            <div class="shopAttribute">
                                                <div class="shopDate-left">
                                                    <div class="lines">
                                                        <div class="shopDate-title">产品属性</div>
                                                        <div class="shopDate-clooses">
                                                            <select id="propertyIds"  class="selects">
                                                                <option value="1">新户专享</option>
                                                                <option value="2">贷款超市</option>
                                                                <option value="3">大额快贷</option>
                                                                <option value="4">小额快贷</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="shopDate-right">
                                                    <div class="lines">
                                                        <div class="shopDate-title">标签名称</div>
                                                        <div class="shopDate-clooses">
                                                            <select id="tagId" class="selects">
                                                                <option value="1">热门</option>
                                                                <option value="2">推荐</option>
                                                                <option value="3">新品</option>
                                                                <option value="4">精选</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="describeAttribute">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">产品描述</div>
                                                    <div class="describe-clooses">
                                                        <input name="details" placeholder="请输入相关产品描述(16个字以内)" />
                                                    </div>
                                                </div>
                                            </div>
                                            <%--<div class="describeAttribute">--%>
                                                <%--<div class="shopDate-lefts">--%>
                                                    <%--<div class="describeDate-title">公司名字</div>--%>
                                                    <%--<div class="describe-clooses">--%>
                                                        <%--<input  value="" name="description" placeholder="请输入公司名字" />--%>
                                                    <%--</div>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>

                                            <%--<div class="describeAttribute">--%>
                                                <%--<div class="shopDate-lefts">--%>
                                                    <%--<div class="describeDate-title">激活流程</div>--%>
                                                    <%--<div class="describe-clooses">--%>
                                                        <%--<input  value="" name="activation_processs" placeholder="请输入相关激活流程" />--%>
                                                    <%--</div>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>

                                            <%--<div class="productDetails">--%>
                                                <%--<div class="shopDate-lefts">--%>
                                                    <%--<div class="describeDate-title">产品详情</div>--%>
                                                    <%--<div class="product-texts" style="background:#fff;">--%>
                                                        <%--<div class="product-labelss">--%>
                                                        <%--</div>--%>
                                                        <%--<div class="product-texts">--%>
                                                            <%--<div class="product-texts-main">--%>
                                                                <%--&lt;%&ndash;<div class="product-texts-item">&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<div><input name="application_conditions"   placeholder="请输入相关详情" /></div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;<div class="product-texts-item">&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<p>申请条件</p>&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<div><input name="application_conditions" placeholder="请输入申请条件" /></div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;<div class="product-texts-item">&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<p>循环额度</p>&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<div><input name="loop_liness" placeholder="请输入循环额度" /></div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;<div class="product-texts-item">&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<p>激活流程</p>&ndash;%&gt;--%>
                                                                    <%--&lt;%&ndash;<div><input name="activation_processs" placeholder="请输入激活流程" /></div>&ndash;%&gt;--%>
                                                                <%--&lt;%&ndash;</div>&ndash;%&gt;--%>

                                                            <%--</div>--%>
                                                        <%--</div>--%>
                                                    <%--</div>--%>
                                                <%--</div>--%>
                                            <%--</div>--%>
                                            <div class="sorting">
                                                <div class="sorting-lefts">
                                                    <div class="sorting-title">产品描述</div>
                                                    <div class="sorting-clooses" style="height:80px;">
                                                        <div class="sorting-p">默认点击最高</div>
                                                        <div class="sorting-clooses-main">
                                                            <div class="sorting-clooses-main-top">
                                                                <p>审核状态</p>
                                                                <select id="status" class="select-2">
                                                                    <option value="4">上架</option>
                                                                    <option value="5">保存</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="describeAttribute">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">网站链接</div>
                                                    <div class="describe-clooses">
                                                        <input name="url" placeholder="请输入相关网站链接" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="members-form-bottoms">
                                                <div id="sub">提交</div>
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
    var imgaddress='';

    //第一个期限点击事件
    $(".date1").click(function(){
        var options=$("#index option:selected");
       var dat= options.val();
  if(dat!=0){
      $("#index2").hide();
      $("#index3").hide();
  }else {
      $("#index2").show();
      $("#index3").show();
  }


    });
//第二个点击事件
    $(".date2").click(function(){
        var options2=$("#index2 option:selected");
        var dat2= options2.val();

        var options3=$("#index3 option:selected");
        var dat3= options3.val();
        if(dat2!=0&&dat3!=0){
            $("#index").hide();

        }else {
            $("#index").show();

        }


    });


    function onclickss(){
        var options2=$("#index2 option:selected");
        var dat2= options2.val()

        var options3=$("#index3 option:selected");
        var dat3= options3.val()
        if(dat2!=0&&dat3!=0){
            $("#index").hide();

        }else {
            $("#index").show();

        }
    }

    layui.use(['upload','jquery'], function(){
        var $ = layui.$,
            upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${ctx }/merchant/addUserInfo'
            ,before: function(obj){//文件上传前的回调
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）直接将图片地址赋值给img的src属性
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code=="404"){
                    return layer.msg('上传失败');
                }
                //上传成功

                if(res.code=="200"){
                    imgaddress = res.items[0]
                    layer.msg("上传成功")
                }

            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });
    });



    /**点击提交
     * */
    $("#sub").click(function(){
        var title=$("input[name='title']").val();
        // var applyCount=$("input[name='applyCount']").val();
        var Limit=$("input[name='Limit']").val();
        var Deadline1 = document.getElementById("index").value;
        if(Deadline1!=0){
        var Deadline=Deadline1
        }else {
            var Deadline2 = document.getElementById("index2").value;
            var Deadline3 = document.getElementById("index3").value;
            if(Deadline2!=null&&Deadline3!=null){
         if((Deadline3-Deadline2)>0){
             var Pace_lending=Deadline2+"--"+Deadline3
        Deadline=(Deadline3-Deadline2)
        // alert("获取的期限值2："+Deadline)
      }else {

      var noDead=1;
            }


            }
        }
        var folat=true;
        var Deadlines='';
        var interestrate=$("input[name='interestrate']").val();
        var propertyIds=$("#propertyIds").val();
        var tagId=$("#tagId").val();
        var details=$("input[name='details']").val();
        // var description=$("input[name='description']").val();//公司名字
        // var applicationConditions=$("input[name='application_conditions']").val();//产品详情
        // var loopLiness=$("input[name='loop_liness']").val();//循环额度
       // var activationProcesss=$("input[name='activation_processs']").val();//激活流程
        var url=$("input[name='url']").val();//网址链接
        var img = imgaddress;
        var indexx=0;
        var status=$("#status").val();
        var adminIdx=adminId;
        // var adminId=$("#adminId").val();
        // alert("用户Id为"+adminId)
        // alert("interestrate的值"+interestrate);
        // alert("propertyIds的值"+propertyIds);
        // alert("tagId的值"+tagId);
        // alert("details的值"+details);
        // alert("description的值"+description);
        // alert("applicationConditions的值"+applicationConditions);
        // alert("loopLiness的值"+loopLiness);
        // alert("activationProcesss的值"+activationProcesss);
        // alert("url的值"+url);
        // alert("img的值"+img);
        // alert("indexx的值"+indexx);
        // alert("Deadline的值是"+Deadlines);
        if(interestrate == ''||interestrate==null||interestrate==undefined){
            layer.msg("请输入利率!");
            folat=false
        }
        if(interestrate == ''||interestrate==null||interestrate==undefined){
            layer.msg("请输入利率!");
            folat=false
        }
        // if(applicationConditions == ''||applicationConditions==null||applicationConditions==undefined){
        //     layer.msg("请输入产品详情!");
        //     folat=false
        // }
        if(propertyIds == ''||propertyIds==null||propertyIds==undefined){
            layer.msg("请选择产品属性!");
            folat=false
        }
        if(tagId == ''||tagId==null||tagId==undefined){
            layer.msg("请选择标签名称!");
            folat=false
        }
        if(details==null||details==undefined||  details == ''){
            layer.msg("请输入产品描述!");
            folat=false
        }
        if(url==null||url==undefined||url == ''){
            layer.msg("请输入相关网站链接!");
            folat=false
        }
        if(img==null||img==undefined||img == ''){
            layer.msg("请上传图片!");
            folat=false
        }
        // if(activationProcesss == ''||activationProcesss==null||activationProcesss==undefined){
        //     layer.msg("请输入激活流程!");
        //     folat=false
        // }
        if(noDead==1){
            layer.msg("请选择期限！");
            folat=false
        }
        if(Limit == ''||Limit==null||Limit==undefined){
            layer.msg("请选择额度！");
            folat=false
        }
        if(title == ''||title==null||title==undefined){
            layer.msg("请选择产品名称！");
            folat=false
        }if(folat==true){
            $.post('${ctx }/Supermarke/insertSupermarket',{ title: title, Limit: Limit, Deadline:Deadline, interestrate:interestrate, propertyIds:propertyIds, tagId:tagId, details:details,url:url, img: img, indexx:indexx
                    ,PaceLending:Pace_lending,status:status,adminId:adminIdx},function (res) {
                    var jsonData=JSON.parse(res);
                    if(jsonData.code=="200") {
                        layer.msg("上传成功!")
                        window.history.go(-1);
                    }else{
                        layer.msg("上传失败！")
                    }
                }
            )
        }
    });
    $(document).ready(function(){

      var Height=$(window).height();//
      var Height1=$(window).height()-60;//
      var Width=$(window).width();
  });

    $('.back').on('click',function(){
        window.history.go(-1);
    })


</script>
</body>
</html>
