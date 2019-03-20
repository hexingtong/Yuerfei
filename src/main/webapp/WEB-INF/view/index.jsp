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
    <title>首页</title>

    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx }/css/common.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/font/iconfont.css">
    <link rel="stylesheet" type="text/css" href="${ctx }/css/zxf_page.css"/>
    <script type="text/javascript" src="${ctx }/js/zxf_page.js"></script>
    <script type="text/javascript" src="${ctx }/js/layer/layer.js"></script>
    <style>

    </style>
</head>
<body>
    <div id="indexBox">
        <div class="indexcontent">
            <%@ include file="left.jsp" %>
                <%--<jsp:include page="${ctx }/left.jsp" flush="true"/><!--动态包含-->--%>
            <div class="right-collection">
                <!--首页右边-->
                <div class="indexcontent-right" style="display: block;">
                    <div class="indexcontent-right-main">
                        <%@ include file="top.jsp" %>
                        <div class="indexcontent-right-bottom" style="height: 884px;">
                            <div class="indexcontent-right-bottom-main">
                                <div class="indexcontent-right-bottom-main-header" style="border:none;">
                                    <div class="indexcontent-header-title">欢迎来到首页</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<script>

    function index() {
        $(location).attr('href', '${ctx }/admin12/TagEditor?id='+id+'')
    }
    //标签删除
    function Tagdelect(id){
        //询问框
        layer.confirm('是否删除', {
            btn: ['是','否'] //按钮
        }, function(){
            $.ajax({
                type:"post",
                dateType:"json",
                url:"${ctx }/Tag/TagDelete",
                data:{id:id},
                success:function(result){
                    var jsonData=JSON.parse(result);
                    if(jsonData.code==200){
                        layer.msg('删除成功', {icon: 1,time: 5000});
                        window.location.reload();
                    }
                    if(jsonDate.code==404){
                        layer.msg('删除失败')
                    }
                },error:function(result){
                    layer.msg(result.code);
                }
            })
        }, function(){

        });
    }
  $(document).ready(function(){
      var Height=$(window).height();//浏览器当前窗口可视区域高度;
      var Height1=$(window).height()-60;//
      var Width=$(window).width();
      var biaoshi=true;

      $('#indexBox').css('width',Width);
      $('#indexBox').css('height',Height);
      $('.indexcontent-right-bottom').css('height',Height1);

      /*获取子页面返回的左边菜单栏id*/
      function GetQueryString(name)
      {
          var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
          var r = window.location.search.substr(1).match(reg);//search,查询？后面的参数，并匹配正则
          if(r!=null)return  unescape(r[2]); return null;
      }
      var childID=GetQueryString("id");
      console.log(childID);

      if(childID==null){
          var h1 = '';
          for(var i=0;i<indexData.length;i++){
              if(i==0){
                  h1 += '<div class="indexcontent-left-item active">'+
                          '<div class="indexcontent-left-item-left">'+
                          '<i class="iconfont">'+indexData[i].icon+'</i>'+
                          '</div>'+
                          '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                          '<div class="indexcontent-left-item-right">'+
                          '<i class="iconfont">&#xe912</i>'+
                          '</div>'+
                          '</div>';
                  $('.right-collection>div').eq(0).show().siblings('div').hide();
              }else{
                  h1 += '<div class="indexcontent-left-item">'+
                          '<div class="indexcontent-left-item-left">'+
                          '<i class="iconfont">'+indexData[i].icon+'</i>'+
                          '</div>'+
                          '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                          '<div class="indexcontent-left-item-right">'+
                          '<i class="iconfont">&#xe912</i>'+
                          '</div>'+
                          '</div>';
                  $('.right-collection>div').eq(childID).show().siblings('div').hide();
              };

          };
      }else{
          var h1 = '';
          for(var i=0;i<indexData.length;i++){
              if(i==childID){
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
                  h1 += '<div class="indexcontent-left-item">'+
                          '<div class="indexcontent-left-item-left">'+
                          '<i class="iconfont">'+indexData[i].icon+'</i>'+
                          '</div>'+
                          '<div class="indexcontent-left-item-middle">'+indexData[i].text+'</div>'+
                          '<div class="indexcontent-left-item-right">'+
                          '<i class="iconfont">&#xe912</i>'+
                          '</div>'+
                          '</div>';
                  $('.right-collection>div').eq(childID).show().siblings('div').hide();
              };

          };
      }
      $('.indexcontent-left-list-main').append(h1);

      /*点击左边切换右边*/
      $('.indexcontent-left-list-main>div').on('click',function(){
          var index=$(this).index();
          $(this).addClass('active').siblings().removeClass('active');
          $('.right-collection>div').eq(index).show().siblings('div').hide();

          if(index==4){
              layer.msg("进入编辑");
              $.ajax({
                  type:"post",
                  dateType:"json",
                  url:"${ctx }/Tag/MercjatTagList",
                  data:{},
                  success: function(result){
                      var jsonData=JSON.parse(result);
                      var I=jsonData.items[0].rows.length;
                      // if(biaoshi==false){
                      //     layer.msg('重复请求啦');
                      //     return ;
                      // }
                      if (jsonData.length!==0) {
                          var o = $(".label-tbody-item");
                          for(var G=0;G<I;G++){
                              var D =' <ul>' +
                                  '<li>'+jsonData.items[0].rows[G].title+'</li>'+
                                  '<li>'+jsonData.items[0].rows[G].addTime+'</li>' +
                                  '<li>'+
                                  '<div class="set">'
                                  +'<div class="labelEditor"  onclick="Tagbianji(this.id)" id="'+jsonData.items[0].rows[G].id+'">编辑</div>' +
                                  '<div class="laveidelete" onclick="Tagdelect(this.id)" id="'+jsonData.items[0].rows[G].id+'">删除</div>' +
                                  '</div>'+
                                  '</li>'+
                                  '</ul>';
                              var K=$(D);
                              biaoshi=false;
                              o.append(K);
                              <%--o.find('.labelEditor').off().on('click',function(){--%>
                              <%--&lt;%&ndash;window.location.href="${ctx }/Tag/MercjatTagListUpadete?id="+jsonData.items[0].rows[G].id+"";&ndash;%&gt;--%>
                              <%--$(location).attr('href', '${ctx }/Tag/MercjatTagListUpadete?id='+jsonData.items[0].rows[G].id+'')--%>
                              <%--// $("#mycar").html(data.data.user.user_account);--%>
                              <%--});--%>
                          }
                      }

                  },
                  error:function(){
                      alert("错误")
                  }
              })
              //ajax结束
          }//标签页结束
      });
          /*列表偶数行背景色*/
      $(" .indexcontent-tbody-items :even").css("background","rgb(239,242,250)");//偶数行

      /*跳转到会员账号页面*/
      $('.indexcontentEditors').on('click',function(){
          window.location.href="membersCode.html";
      });

      /*跳转账户管理页面*/
      $('.userEditor').on('click',function(){
          window.location.href="accountManagement.html";
      });


      /*产品部分*/
       /*跳到新增*/
      $('.product-add').on('click',function(){
          window.location.href="productAdd.html";
      })
      /*跳到编辑*/
      $('.clickEditor').on('click',function(){
          window.location.href="productEditor.html";
      })

      /*标签部分*/
      /*跳到新增*/
      $('.label-add').on('click',function(){
          window.location.href="labelAdd.html";
      });

      /*跳到编辑*/
      // $('.labelEditor').on('click',function(){
      //     window.location.href="labelEditor.html";
      // })
      /*跳到图形*/
      $('.merchantsgraphics').on('click',function(){
          window.location.href="graphics.html";
      });


      /*超市展示部分*/
      /*跳到新增*/
      $('.supermarketEditor').on('click',function(){
          window.location.href="supermarketEditor.html";
      });

      $('.super-add').on('click',function(){
          window.location.href="supermarketAdd.html";
      });

      // 推广 ---- 
      
      $('.promote-add').on('click',function(){
          window.location.href="promoteAdd.html";
      });

      $('.promoteEditor').on('click',function(){
          window.location.href="promoteEditor.html";
      });

    //   ---

      /*商户展示部分*/
      /*跳到新增*/
      $('.shoppEditor').on('click',function(){
          window.location.href="shopAdd .html";
      });

      /*管理人员部分*/
      /*跳到新增*/
      $('.managementAdd').on('click',function(){
          window.location.href="managementAdd.html";
      });
      /*跳到编辑*/
      $('.managementEditor').on('click',function(){
          window.location.href="managementEditor.html";
      });

  });




</script>
</body>
</html>
