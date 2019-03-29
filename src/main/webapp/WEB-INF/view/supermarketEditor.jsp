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
    <title>编辑产品</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/js/layui/css/layui.css" media="all">
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <script type="text/javascript" src="${ctx }/js/paging.js"></script>
    <script type="text/javascript" src="${ctx }/js/layui/layui.js"></script>
    <style>
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
                            <img  src="${ctx }/images/Full screen button.svg"/>
                            <div class="indexcontent-right-top-right">
                                <img  src="${ctx }/images/quit.svg"/>
                                <p>退出</p>
                            </div>
                        </div>

                        <div class="indexcontent-right-bottom" style="height:1450px;">
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
                                                    <input name="title" value="${goods.title}" placeholder="请输入产品名称(10字以内)"/>
                                                </div>
                                            </div>
                                            <div class="members-form-top-add" style="margin-top:50px;">
                                                <div class="members-form-top-add-left">
                                                    <div class="layui-upload">
                                                        <div class="layui-upload-list">
                                                            <!--预览图片-->
                                                            <img width="160" height="100" src="<%=basePath %>${goods.img}"  class="layui-upload-img"  id="demo1">
                                                            <!--提示上传信息-->
                                                            <p id="demoText"></p>
                                                        </div>
                                                        <button type="button" class="layui-btn" id="test1">上传图片</button>
                                                    </div>

                                                </div>
                                                <div class="members-form-top-add-right">
                                                    <div class="lines">
                                                        <p>产品额度</p>
                                                        <div class="linesInput">
                                                            <input name="Limit" value="${goods.limit}" placeholder="请输入额度" />
                                                        </div>
                                                        <span>元</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="members-form-top-adds">
                                                <div class="members-form-top-add-lefts">
                                                    <div class="members-form-top-text-adds">申请人数</div>
                                                    <div class="linesInput">
                                                        <input name="applyCount" value="${goods.applyCount}" placeholder="请输入人数" />
                                                    </div>
                                                    <span>人</span>
                                                </div>
                                                <div class="members-form-top-add-right">
                                                    <div class="lines">
                                                        <p>产品利率</p>
                                                        <div class="linesInput">
                                                            <input name="interestrate" value="${goods.interestrate}" placeholder="请输入利率" />
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

                                                            <select id="propertyIds" class="selects">
                                                                <option value="1">新户专享</option>
                                                                <option value="2">贷款超市</option>
                                                                <option value="3">大额快贷</option>
                                                                <option value="4">小额快贷</option>
                                                            </select>
                                                            <input type="hidden" id="proIds" value="${goods.propertyIds}">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="shopDate-right">
                                                    <div class="lines">
                                                        <div class="shopDate-title">标签名称</div>
                                                        <div class="shopDate-clooses">

                                                            <select id="tagId"  class="selects">
                                                                <option value="1" >热门</option>
                                                                <option value="2" >推荐</option>
                                                                <option value="3" >新品</option>
                                                                <option value="4" >精选</option>
                                                            </select>
                                                            <input type="hidden" id="tagIds" value="${goods.tagId}">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="describeAttribute">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">产品描述</div>
                                                    <div class="describe-clooses">
                                                        <input id="details" value="${goods.details}" name="details" placeholder="请输入相关产品描述(16个字以内)" />
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="productDetails">
                                                <div class="shopDate-lefts">
                                                    <div class="describeDate-title">产品详情</div>
                                                    <div class="product-texts" style="background:#fff;">
                                                        <div class="product-labelss">
                                                            <label class="bui-radios-label">
                                                                <input type="radio" checked="true" id="show" name="indexx" value="1" ><i  value="1"  class="bui-radios"></i>是
                                                            </label>
                                                            <label class="bui-radios-label" style="margin-left:30px;">
                                                                <input type="radio"id="hide" name="indexx" value="0"><i  value="0" class="bui-radios"></i>否
                                                            </label>
                                                        </div>
                                                        <input type="hidden" value="${goods.detailsId}" id="detailsId">
                                                        <div class="product-texts">
                                                            <div class="product-texts-main">
                                                                <div class="product-texts-item">
                                                                    <p>详情描述</p>
                                                                    <div><input name="description" placeholder="请输入详情描述" /></div>
                                                                </div>
                                                                <div class="product-texts-item">
                                                                    <p>申请条件</p>
                                                                    <div><input name="application_conditions"  placeholder="请输入申请条件" /></div>
                                                                </div>
                                                                <div class="product-texts-item">
                                                                    <p>循环额度</p>
                                                                    <div><input name="loop_liness" placeholder="请输入循环额度" /></div>
                                                                </div>
                                                                <div class="product-texts-item">
                                                                    <p>激活流程</p>
                                                                    <div><input name="activation_processs" placeholder="请输入激活流程" /></div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="sorting">
                                                <div class="sorting-lefts">
                                                    <div class="sorting-title">产品描述</div>
                                                    <div class="sorting-clooses" style="height:80px;">
                                                        <div class="sorting-p">默认点击最高</div>
                                                        <div class="sorting-clooses-main">
                                                            <div class="sorting-clooses-main-top">
                                                                <p>审核状态</p>
                                                                <select name="status" class="select-2">
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
                                                        <input name="url" value="${goods.url}" placeholder="请输入相关网站链接" />
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="members-form-bottoms">
                                                <div id="sub">提交</div>
                                                <div class="back">返回</div>
                                            </div>
                                            <input type="hidden" id="Imgx" value="${goods.img}">
                                            <input type="hidden" id="Pace_lendingx" value="${goods.paceLending}">
                                            <input type="hidden" id="Deadline" value="${goods.details}">
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

   <%--var dId=${goods.propertyIds}--%>
       <%--$("#propertyIds").val(dId).trigger("change")--%>

   <%--var dId2=${goods.tagId}--%>
       <%--$("#tagId").val(dId2).trigger("change")--%>
   <%--//期限--%>

   <%--&lt;%&ndash;//${goods.Deadline}&ndash;%&gt;--%>
   <%--var Deadline=$("#Deadline").val();--%>
       <%--alert(Deadline+"dd")--%>
   <%--if(Deadline!=null&&Deadline!=undefined&&Deadline!=''){--%>
       <%--$("#index").val(Deadline).trigger("change")--%>
   <%--}else {--%>
       <%--$("#index").hide();--%>
   <%--}--%>

//期限区域

   //$("#Pace_lendingx").val();
   // var PaceLending=$("#Pace_lendingx").val();
   //     if(PaceLending!=null&&PaceLending!=undefined&&PaceLending!=''){
   //         are=PaceLending.split("--")
   //          var PaceLending1=are[0]
   //         var PaceLending2=are[1]
   //         $("#index2").val(PaceLending1).trigger("change")
   //         $("#index3").val(PaceLending2).trigger("change")
   //
   //     }else {
   //         $("#index2").hide();
   //         $("#index3").hide();
   //     }


     //var indexx='';
    var imgaddress='';
    //打一个期限点击事件
    $(".date1").click(function(){
        var options=$("#index option:selected");
        var dat= options.val()
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
        var dat2= options2.val()

        var options3=$("#index3 option:selected");
        var dat3= options3.val()
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
                    imgaddress = res.items[0];
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


    $("#hide").click(function(){
        $(".product-texts-main").hide();

    });

    $("#show").click(function(){
        $(".product-texts-main").show();

    });
    /**点击提交
     * */
    $("#sub").click(function(){
        var title=$("input[name='title']").val();
        var applyCount=$("input[name='applyCount']").val();
        var Limit=$("input[name='Limit']").val();
        var Deadline = document.getElementById("index").value;
        var interestrate=$("input[name='interestrate']").val();
        var propertyIds=$("#propertyIds").val();
        var tagId=$("#tagId").val();
        var details=$("input[name='details']").val();
        var description=$("input[name='description']").val();//详请描述
        var applicationConditions=$("input[name='application_conditions']").val();//申请条件
        var loopLiness=$("input[name='loop_liness']").val();//循环额度
        var activationProcesss=$("input[name='activation_processs']").val();//激活流程
        var url=$("input[name='url']").val();//详请描述
        var img = imgaddress;//图片上传
        var id=${goods.id};
        var indexx=$('input:radio[name="indexx"]:checked').val();
        var detailsId=$("#detailsId").val();
        var Deadline1 = document.getElementById("index").value;
        var status=$("input[name='status']").val();

        if(img==''||img.valueOf("")||img==undefined){
            img=$("#Imgx").val();
        }

        if(Deadline1!=0){
            var Deadline=Deadline1
        }else {
            var Deadline2 = document.getElementById("index2").value;
            var Deadline3 = document.getElementById("index3").value;
            if(Deadline2!=null&&Deadline3!=null){
                if((Deadline3-Deadline2)>0){
                    var Pace_lending=Deadline2+"--"+Deadline3
                    Deadline=(Deadline3-Deadline2)
                    alert("获取的期限值2："+Deadline)
                }else {
                    alert("选择有误")
                    var noDead=1;
                }


            }
        }
        if(interestrate == ''||interestrate==null||interestrate==undefined ||  propertyIds == ''||propertyIds==null||propertyIds==undefined||noDead==1
            ||tagId == ''||tagId==null||tagId==undefined|| tagId == ''||details==null||details==undefined||  details == ''||url==null||url==undefined||url == ''||indexx==null||indexx==undefined||indexx==''
        ){
            layer.msg("选择错误！")
        }else{
        $.post('${ctx }/Supermarke/updateSupermarket',{id:id, title: title, applyCount:applyCount, Limit: Limit, Deadline:Deadline, interestrate:interestrate, propertyIds:propertyIds, tagId:tagId, details:details, description:description, applicationConditions:applicationConditions, loopLiness:loopLiness, activationProcesss:activationProcesss, url:url, img: img, indexx:indexx,detailsId:detailsId
            ,PaceLending:Pace_lending
            },function (res) {
                var jsonData=JSON.parse(res);
            if(jsonData.code=="200") {
                layer.msg("编辑成功!")
                window.history.go(-1);
            }else{
                layer.msg("编辑失败！")
            }
                }
            )
        }




    });


  $(document).ready(function() {
      var Height = $(window).height();//
      var Height1 = $(window).height() - 60;//
      var Width = $(window).width();
      /*$('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);*/

      $('.back').on('click', function () {
          window.history.go(-1);
      })



      var Deadlinex=$("#tagId").val();
      var Pace_lendingx=$("#Pace_lendingx").val();
      if(Deadlinex==''||Deadlinex==null||Deadlinex==undefined){
        //回显Pace_lendingx
      }
      if(Pace_lendingx==''||Pace_lendingx==null||Pace_lendingx==undefined){
          //回显Deadlinex
      }



  })

</script>
</body>
</html>
