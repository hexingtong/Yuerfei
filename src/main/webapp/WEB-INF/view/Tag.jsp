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
    <title>标签展示</title>
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
<!--标签展示右边-->
            <div class="indexcontent-right4" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="./images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="./images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 875px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">标签展示列表</div>
                                <div class="indexcontent-header-search">
                                    <input placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img src="./images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh" style="display: flex;">
                                    <div class="label-editor" style="color:#fff;background:#2290FF;">刷新</div>
                                    <div class="label-add" style="margin-left:-30px;color:#fff;background:#FF8D2F;">新增</div>
                                </div>
                                <div class="label-tab">
                                    <div class="label-thead">
                                        <ul>
                                            <li>标签名称</li>
                                            <li>添加时间</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="label-tbody">
                                        <div class="label-tbody-item">
                                            <ul>
                                                <li>新品</li>
                                                <li>2019-02-23 15:29:50</li>
                                                <li>
                                                    <div class="set">
                                                        <div class="labelEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="label-tbody-items">
                                            <ul>
                                                <li>新户</li>
                                                <li>2019-02-23 15:29:50</li>
                                                <li>
                                                    <div class="set">
                                                        <div class="labelEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="indexcontent-tabPage">
                                    <div class="zxf_pagediv4"><span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="zxfPagenum nextpage">2</a><a href="javascript:;" class="zxfPagenum">3</a><span>...</span><a href="javascript:;" class="nextbtn">下一页</a><span>共<b>20</b>页，</span><span>到第<input type="number" class="zxfinput" value="5">页</span><span class="zxfokbtn">确定</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>