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
    <title>管理</title>
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
<!--商户管理右边-->
            <div class="indexcontent-right2" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="${ctx }/images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="${ctx }/images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 875px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">商户管理列表</div>
                                <div class="indexcontent-header-search">
                                    <input placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img src="./images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh">
                                    <div style="border:1px solid  rgb(239,242,250);color:#fff;background:#2290FF;" onclick="location.reload()" >刷新</div>

                                </div>
                                <div class="indexcontent-tab">
                                    <div class="indexcontent-thead">
                                        <ul>
                                            <li>唯一ID</li>
                                            <li>会员账号</li>
                                            <li>注册来源</li>
                                            <li>注册账号</li>
                                            <li>最后登录时间</li>
                                            <li>最后登录IP</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="indexcontent-tbody1">



                                        <div class="indexcontent-tbody-item">
                                            <ul>
                                                <li>123456</li>
                                                <li>123 4567 8901</li>
                                                <li>自动注册</li>
                                                <li>2019-02-20</li>
                                                <li>2019-02-23 15:29:50</li>
                                                <li>230.103.333.50</li>
                                                <li>
                                                    <div class="set">
                                                        <div class="userEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="indexcontent-tbody-items">
                                            <ul>
                                                <li style="background: rgb(239, 242, 250);">123456</li>
                                                <li>123 4567 8901</li>
                                                <li style="background: rgb(239, 242, 250);">自动注册</li>
                                                <li>2019-02-20</li>
                                                <li style="background: rgb(239, 242, 250);">2019-02-23 15:29:50</li>
                                                <li>230.103.333.50</li>
                                                <li style="background: rgb(239, 242, 250);">
                                                    <div class="set">
                                                        <div class="userEditor" style="background: rgb(239, 242, 250);">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="indexcontent-tbody-item">
                                            <ul>
                                                <li>123456</li>
                                                <li>123 4567 8901</li>
                                                <li>自动注册</li>
                                                <li>2019-02-20</li>
                                                <li>2019-02-23 15:29:50</li>
                                                <li>230.103.333.50</li>
                                                <li>
                                                    <div class="set">
                                                        <div class="userEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="indexcontent-tabPage">
                                    <div class="zxf_pagediv2"><span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="zxfPagenum nextpage">2</a><a href="javascript:;" class="zxfPagenum">3</a><span>...</span><a href="javascript:;" class="nextbtn">下一页</a><span>共<b>20</b>页，</span><span>到第<input type="number" class="zxfinput" value="5">页</span><span class="zxfokbtn">确定</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>