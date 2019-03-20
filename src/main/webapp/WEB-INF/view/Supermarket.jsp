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
    <title>超市展示</title>
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
<!--超市展示右边-->
            <div class="indexcontent-right6" style="display: block;">
                <div class="indexcontent-right-main">
                    <div class="indexcontent-right-top">
                        <img src="${ctx }/images/Full screen button.svg">
                        <div class="indexcontent-right-top-right">
                            <img src="${ctx }/images/quit.svg">
                            <p>退出</p>
                        </div>
                    </div>
                    <div class="indexcontent-right-bottom" style="height: 884px;">
                        <div class="indexcontent-right-bottom-main">
                            <div class="indexcontent-right-bottom-main-header">
                                <div class="indexcontent-header-title">超市展示列表</div>
                                <div class="indexcontent-header-search">
                                    <input placeholder="请输入搜索关键词">
                                    <div class="search-img">
                                        <img src="${ctx }/images/SEARCH.svg">
                                    </div>
                                </div>
                            </div>
                            <div class="indexcontent-right-bottom-main-content">
                                <div class="refresh">
                                    <div style="background: rgb(36,143,255);color:#fff;">刷新</div>
                                    <div class="super-add" style="margin-left:-30px;background:#FF8D2F;color:#fff;">新增</div>
                                    <div class="labelSelet" style="width:80%;height:90px;margin-left:20px;margin-top:10px;padding:0px;">
                                        <div class="labelSelet-main">
                                            <div class="selectDiv">
                                                <p>排序方式</p>
                                                <select class="select">
                                                    <option>推荐级别</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                </select>
                                            </div>

                                            <div class="selectDiv">
                                                <p>产品属性</p>
                                                <select class="select">
                                                    <option>新户专享</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                </select>
                                            </div>
                                            <div class="selectDiv">
                                                <p>筛选</p>
                                                <select class="select">
                                                    <option>审核中</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                    <option>添加时间</option>
                                                    <option>点击量</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="shopping-tab">
                                    <div class="shopping-thead">
                                        <ul>
                                            <li>产品图片</li>
                                            <li>产品名称</li>
                                            <li>所属属性</li>
                                            <li>上架状态</li>
                                            <li>添加时间</li>
                                            <li>PV</li>
                                            <li>UV</li>
                                            <li>操作</li>
                                        </ul>
                                    </div>
                                    <div class="shopping-tbody1">
                                        <div class="shopping-tbody-item">
                                            <ul>
                                                <li>
                                                    <img src="${ctx }/images/微信截图_20190307101309.png">
                                                </li>
                                                <li>速贷贷款</li>
                                                <li>新户专享</li>
                                                <li>审核中</li>
                                                <li>2019-02-23</li>
                                                <li>78</li>
                                                <li>8</li>
                                                <li>
                                                    <div class="sets">
                                                        <div class="supermarketgraphics">图形数据</div>
                                                        <div class="supermarketEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="shopping-tbody-items">
                                            <ul>
                                                <li>
                                                    <img src="${ctx }/images/微信截图_20190307101309.png">
                                                </li>
                                                <li>速贷贷款</li>
                                                <li>新户专享</li>
                                                <li>审核中</li>
                                                <li>2019-02-23</li>
                                                <li>78</li>
                                                <li>8</li>
                                                <li>
                                                    <div class="sets">
                                                        <div class="supermarketgraphics">图形数据</div>
                                                        <div class="supermarketEditor">编辑</div>
                                                        <div>删除</div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                                <div class="indexcontent-tabPage">
                                    <div class="zxf_pagediv6"><span class="disabled">上一页</span><span class="current">1</span><a href="javascript:;" class="zxfPagenum nextpage">2</a><a href="javascript:;" class="zxfPagenum">3</a><span>...</span><a href="javascript:;" class="nextbtn">下一页</a><span>共<b>20</b>页，</span><span>到第<input type="number" class="zxfinput" value="5">页</span><span class="zxfokbtn">确定</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
</body>
</html>